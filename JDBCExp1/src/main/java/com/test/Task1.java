package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Task1 {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/mladec";
		String user = "root";
		String pass = "root@39";

		String sql_create = "create table city(c_id int, c_name varchar(50), c_price int, c_varient varchar(50), c_color varchar(20))";

		// 1.load the driver class
		Class.forName("com.mysql.jdbc.Driver");

		// 2. establish or connection object
		Connection con = DriverManager.getConnection(url, user, pass);

		// 3. create statement object
		Statement stmt = con.createStatement();

//		stmt.addBatch("insert into city values(1, 'Lada', 6000, 'JetFuel', 'White')");
		stmt.addBatch("insert into city values(2, 'Mahindra', 2000, 'Petrol-E20', 'Black')");
//		stmt.addBatch("insert into city values(3, 'EcoRide', 950000, 'Electric', 'Blue')");

		// 4. Execute query
//				stmt.execute(sql_create);
				stmt.executeBatch();

//		String sql_select = "select * from city";
//		ResultSet rs = stmt.executeQuery(sql_select);
//
//		while (rs.next()) {
//			System.out.println("ID: " + rs.getInt(1) + "  Name: " + rs.getString(2) + "  Price: " + rs.getInt(3));
//		}.

		// 5. close connection
		con.close();
		System.out.println("done");

	}

}
