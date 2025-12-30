//CRUD operation


package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver ="com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/mladec";
		String user = "root";
		String pass = "root@39";
		
		Scanner sc = new Scanner(System.in);
		Integer p_id;
		String p_name;
		int p_age;
		String p_mobile;
		String  p_email;
		String source;
		String destination;
		
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String sql_create ="CREATE TABLE travelData(p_id int PRIMARY KEY, p_name varchar(50),"
				+ " p_age int, p_mobile varchar(20), p_email varchar(50), source varchar(50),"
				+ " destination varchar(50))";
		
		
		// CREATING TABLE
		Statement stmt = con.createStatement();
		stmt.execute(sql_create);
		
		//show all
		String sql_select = "select * from travelData";
		PreparedStatement ps_select = con.prepareStatement(sql_select);
		
		//adding data to the table
		String sql_insert = "INSERT INTO travelData values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps_insert = con.prepareStatement(sql_insert);
		
		System.out.println("provide p_id: ");
		p_id = sc.nextInt();
		ps_insert.setInt(1, p_id);
		
		System.out.println("provide p_name: ");
		p_name = sc.next();
		ps_insert.setString(2, p_name);
		
		System.out.println("provide p_age: ");
		p_age = sc.nextInt();
		ps_insert.setInt(3, p_age);
		
		System.out.println("provide p_mobile: ");
		p_mobile = sc.next();
		ps_insert.setString(4, p_mobile);
		
		System.out.println("provide p_email: ");
		p_email = sc.next();
		ps_insert.setString(5, p_email);
		
		System.out.println("provide source: ");
		source = sc.next();
		ps_insert.setString(6, source);
		
		System.out.println("provide destination: ");
		destination = sc.next();
		ps_insert.setString(7, destination);
		
		
		
		//EXECUTION
		ps_insert.addBatch();
		ps_insert.executeBatch();
		
		
		ResultSet rs = ps_select.executeQuery();
		while(rs.next()) {
			System.out.println("ID: "+ rs.getInt(1) + "  Name: " + rs.getString(2) + "  Age: " + rs.getInt(3) + " Mobile: " + rs.getString(4) + " Email: " + rs.getString(5)
			+ " Source: " + rs.getString(6) + " Destination: " + rs.getString(7));
		}
		
	
		
		
	}

}
