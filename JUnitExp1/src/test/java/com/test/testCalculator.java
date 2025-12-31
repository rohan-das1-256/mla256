package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@Suite
@SuiteDisplayName("mla junit testcases")
public class testCalculator {

	Calculator  cal;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all test case");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("after all test case");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("before each test method");
		cal = new Calculator();
	}

	@AfterEach
	public void afterEach() {
		System.out.println("after each test method");
	}
	
	@Test
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	public void testAdd() {
		System.out.println("test add method");
		assertEquals(20, cal.add(10, 10));
		
	}
	
	@Test
	public void testSub() {
		System.out.println("test sub method");
		assertEquals(10, cal.sub(20, 10));
	}
	@Test
	public void testMul() {
		System.out.println("test mul method");
		assertEquals(30, cal.mul(5, 6));
	}
	
	@Test
	public void testListNames() {
		System.out.println("test list data");
		
		List<String> names = Arrays.asList("rohit", "dhoni", "kohli", "rahul");
		assertEquals(4, cal.listNames(names).size());
	}
	
	@Test
	public void testGreetUser() {
		System.out.println("test greet user method");
		
		assertEquals("rohit, garden, sky", cal.greetUser("rohit, garden, sky"));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", ""})
	public void testIsEmpty(String str) {
		Assertions.assertTrue(cal.isEmpty(str));
	}
	
	@Test
	public void testAge() {
		IllegalArgumentException excp = assertThrows(IllegalArgumentException.class, () -> cal.checkAge(5));
		
		assertEquals("age must be greater than zero", excp.getMessage());
	}
	
	
}
