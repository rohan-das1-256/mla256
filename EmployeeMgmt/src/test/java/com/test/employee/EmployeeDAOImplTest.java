package com.test.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDAOImplTest {

    private static Connection con;
    private static EmployeeDAO dao;

    // --- SQL DDL & seed ---
    private static final String CREATE_TABLE_SQL = """
        CREATE TABLE IF NOT EXISTS employees (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(100) NOT NULL,
            email VARCHAR(150) UNIQUE NOT NULL,
            department VARCHAR(100),
            salary DECIMAL(10,2) NOT NULL,
            joined_on DATE NOT NULL,
            is_active TINYINT(1) NOT NULL DEFAULT 1
        );
    """;

    private static final String TRUNCATE_SQL = "TRUNCATE TABLE employees;";

    private static final String SEED_SQL = """
        INSERT INTO employees (name, email, department, salary, joined_on, is_active) VALUES
          ('Alice', 'alice@example.com', 'IT', 75000.00, DATE '2024-01-10', 1),
          ('Bob',   'bob@example.com',   'HR', 55000.00, DATE '2023-05-03', 1);
    """;

    @BeforeAll
    static void globalInit() throws Exception {
        // Build a test Connection (H2 in MySQL mode) and create schema
        con = TestConnections.h2MySqlMode();
        dao = new EmployeeDAOImpl(); // your implementation

        try (Statement st = con.createStatement()) {
            st.execute(CREATE_TABLE_SQL);
        }
    }

    @BeforeEach
    void resetData() throws SQLException {
        try (Statement st = con.createStatement()) {
            st.execute(TRUNCATE_SQL);
            st.execute(SEED_SQL);
        }
    }

    @AfterAll
    static void cleanup() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /* ========== addEmployee ========== */

    @Test
    @Order(1)
    void addEmployee_positive_generatesIdAndPersists() {
        Employee e = new Employee(
                null, "Carol", "carol@example.com", "Finance",
                new BigDecimal("82000.00"),
                LocalDate.of(2024, 2, 1),
                true
        );

        Employee saved = dao.addEmployee(e, con);
        assertNotNull(saved.getId(), "ID must be auto-generated");
        assertEquals("Carol", saved.getName());
        assertEquals("carol@example.com", saved.getEmail());

        List<Employee> all = dao.getAllEmployees(con);
        assertTrue(all.stream().anyMatch(emp -> "carol@example.com".equals(emp.getEmail())));
    }

    @Test
    @Order(2)
    void addEmployee_negative_duplicateEmail_throws() {
        Employee dup = new Employee(
                null, "Bobby", "bob@example.com", "HR",  // email already exists
                new BigDecimal("60000.00"),
                LocalDate.of(2023, 6, 1),
                true
        );

        RuntimeException ex = assertThrows(RuntimeException.class, () -> dao.addEmployee(dup, con));
        // Be flexible about message content across drivers
        String msg = ex.getMessage().toLowerCase();
        assertTrue(msg.contains("unique") || msg.contains("constraint") || msg.contains("duplicate"),
                "Message should indicate unique/duplicate violation: " + msg);
    }

    @Test
    @Order(3)
    void addEmployee_negative_nullRequiredFields_throws() {
        Employee bad = new Employee(
                null, null,  // name is required
                "bad@example.com", "IT",
                new BigDecimal("100.00"), LocalDate.now(), true
        );
        assertThrows(RuntimeException.class, () -> dao.addEmployee(bad, con));
    }

    /* ========== getAllEmployees ========== */

    @Test
    @Order(4)
    void getAllEmployees_positive_returnsSeededRows() {
        List<Employee> all = dao.getAllEmployees(con);
        assertEquals(2, all.size(), "Seed inserted 2 rows");
        assertEquals("Alice", all.get(0).getName());
    }

    /* ========== updateEmployee ========== */

    @Test
    @Order(5)
    void updateEmployee_positive_updatesFields() {
        // Find Alice
        Employee alice = dao.getAllEmployees(con).stream()
                .filter(e -> "alice@example.com".equals(e.getEmail()))
                .findFirst()
                .orElseThrow();

        alice.setDepartment("Engineering");
        alice.setSalary(new BigDecimal("90000.00"));

        Employee updated = dao.updateEmployee(alice, con);

        assertEquals("Engineering", updated.getDepartment());
        assertEquals(new BigDecimal("90000.00"), updated.getSalary());
    }

    @Test
    @Order(6)
    void updateEmployee_negative_missingId_throws() {
        Employee noId = new Employee(
                null, "NoId", "noid@example.com", "Ops",
                new BigDecimal("50000.00"), LocalDate.now(), true
        );

        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class, () -> dao.updateEmployee(noId, con));
        assertTrue(ex.getMessage().toLowerCase().contains("id"), "Should mention missing id");
    }

    @Test
    @Order(7)
    void updateEmployee_negative_nonExistingId_throwsRuntime() {
        Employee ghost = new Employee(
                9999, "Ghost", "ghost@example.com", "Unknown",
                new BigDecimal("1.00"), LocalDate.of(2000, 1, 1), false
        );

        RuntimeException ex = assertThrows(RuntimeException.class, () -> dao.updateEmployee(ghost, con));
        assertTrue(ex.getMessage().toLowerCase().contains("no employee found"),
                "Should indicate row not found");
    }

    /* ========== deleteEmployee ========== */

    @Test
    @Order(8)
    void deleteEmployee_positive_removesRowAndReturnsRemaining() {
        int idToDelete = dao.getAllEmployees(con).stream()
                .filter(e -> "bob@example.com".equals(e.getEmail()))
                .map(Employee::getId)
                .findFirst().orElseThrow();

        List<Employee> remaining = dao.deleteEmployee(idToDelete, con);

        assertTrue(remaining.stream().noneMatch(e -> e.getId() == idToDelete),
                   "Deleted ID must be absent");
        assertEquals(1, remaining.size(), "Seed 2 rows -> now 1");
    }

    @Test
    @Order(9)
    void deleteEmployee_negative_missingRow_throws() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> dao.deleteEmployee(9999, con));
        assertTrue(ex.getMessage().toLowerCase().contains("no employee"), "Should indicate not found");
    }
}

