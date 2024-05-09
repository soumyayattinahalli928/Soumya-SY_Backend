package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url ="jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pwd = "Sa123";
			
			Connection c =DriverManager.getConnection(url,user,pwd);
			
//			String query = "insert into student values(4,'Ram',78.9,'Mysore')";
			//static query
//			Statement s = c.createStatement();
//			s.executeUpdate(query);
			
			//dynamic query
			String query = "insert into student(name,percentage,address) values(?,?,?)";
			
			PreparedStatement p = c.prepareStatement(query);
			
			while(true) {
				System.out.println("enter name");
				p.setString(1, sc.next());
				
				System.out.println("enter percentage");
				p.setDouble(2, sc.nextDouble());
				
				System.out.println("enter address");
				p.setString(3, sc.next());
				
				System.out.println("data inserted");
				
				System.out.println("more data enter y");
				char ch = sc.next().charAt(0);
				if(ch!= 'y') {
					break;
				}
			}
			
			p.execute();
			
			
			c.close();
			
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
	}
}
