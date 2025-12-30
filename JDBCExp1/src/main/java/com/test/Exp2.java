package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Exp2 {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/mladec";
		String user = "root";
		String pass = "root@39";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String sql_insert = "insert into book1(?,?,?)";
		
		String sql_update ="update book1 set b_name = ? where b_id = ?";
		String sql_select = "select * from book1";
		
		PreparedStatement pstmt = con.prepareStatement(sql_insert);
		pstmt.setInt(1, 3);
		pstmt.setString(2, "Pearl");
		pstmt.setInt(3, 225);
		
		PreparedStatement pstmt2 = con.prepareStatement(sql_update);
		pstmt2.setString(1, "kotlin");
		pstmt2.setInt(2, 1);
		
		
		PreparedStatement pstmt3 = con.prepareStatement(sql_select);
		
//		pstmt.addBatch();
		pstmt2.addBatch();
		
//		pstmt.executeBatch();
		pstmt2.executeBatch();
		
		ResultSet rs = pstmt3.executeQuery();
		while(rs.next()) {
			System.out.println("ID: "+ rs.getInt(1) + "  Name: " + rs.getString(2) + "  Price: " + rs.getInt(3));
		}
		
		ResultSetMetaData rsd = rs.getMetaData();
		System.out.println(rsd.getColumnName(1));
		
		
	}

}
