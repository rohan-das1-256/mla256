package com.test;

import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Exp1 {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/mladec";
		String user = "root";
		String pass = "root@39";
		
		String sql_create = "create table book1(b_id int, b_name varchar(50), b_price int)";
		
		String sql = "insert into book1 values(1, 'java', 250)";
		
		// 1.load the driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. establish or connection object
		Connection con = DriverManager.getConnection(url, user, pass);
		
		//3. create statement object
		Statement stmt = con.createStatement();
		
		stmt.addBatch("insert into book1 values(1, 'javascript', 200)");
		stmt.addBatch("insert into book1 values(1, 'python', 240)");
		
		//4. Execute query
//		stmt.execute(sql);
//		stmt.executeBatch();
		
		String sql_select = "select * from book1";
		ResultSet rs = stmt.executeQuery(sql_select);
		
		while(rs.next()) {
			System.out.println("ID: "+ rs.getInt(1) + "  Name: " + rs.getString(2) + "  Price: " + rs.getInt(3));
		}
		
		//5. close connection
		con.close();
		System.out.println("done");
				
		

	}

}
