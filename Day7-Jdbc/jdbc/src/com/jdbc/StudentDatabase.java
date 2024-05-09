package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDatabase {
	
	private static Connection connection;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		StudentDatabase studentDatabase = new StudentDatabase();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pwd = "Sa123";
			connection = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("enter 1 to insert record");
			System.out.println("enter 2 to select by employee id");
			System.out.println("enter 3 to select all employees");
			System.out.println("enter 4 to update fields");
			System.out.println("enter 5 to delete employee");
			
			System.out.println("========================");
			
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				studentDatabase.insertRecord();
				break;
			}
			case 2: {
				studentDatabase.selectEmpById();
				break;
			}
			case 3: {
				studentDatabase.selectAll();
				break;
			}
			case 4: {
				studentDatabase.update();
				break;
			}
			case 5: {
				studentDatabase.delete();
				break;
			}
			default:
				System.out.println("invalid choice plaese enter a valid choice");
			}
			
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void insertRecord() throws SQLException{
		
		String query = "insert into employee(name,salary,dept) values(?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		while(true) {
			System.out.println("enter emp name");
			preparedStatement.setString(1, sc.next());
			
			System.out.println("enter salary");
			preparedStatement.setDouble(2, sc.nextDouble());
			
			System.out.println("enter emp department");
			preparedStatement.setString(3, sc.next());
			
			System.out.println("data inserted");
			preparedStatement.execute();
			
			System.out.println("to more data enter y");
			char ch = sc.next().charAt(0);
			if(ch!= 'y') {
				break;
			}
		}

	}
	
	private void selectEmpById() throws SQLException{
		
		System.out.println("enter emp id to fetch record");
		int id = sc.nextInt();
		
		String query = "select * from employee where id = " + id;
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		if(resultSet.next()) {
			int eId = resultSet.getInt("id");
			String eName = resultSet.getString("name");
			double sal = resultSet.getDouble("salary");
			String edept = resultSet.getString("dept");
			
			System.out.println("Id : " + eId);
			System.out.println("Name : " + eName);
			System.out.println("Salary : " + sal);
			System.out.println("Department : " + edept);

		}
		else {
			System.out.println("Record not found !!!");
		}

	}
	
	private void selectAll() throws SQLException {
		
	String query = "select * from employee";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			int eId = resultSet.getInt("id");
			String eName = resultSet.getString("name");
			double sal = resultSet.getDouble("salary");
			String edept = resultSet.getString("dept");
			
			System.out.println("Id : " + eId);
			System.out.println("Name : " + eName);
			System.out.println("Salary : " + sal);
			System.out.println("Department : " + edept);
			
			System.out.println("---------------------");
		}
	}
	
	private void update() throws SQLException {
		
		System.out.println("enter 1 to update name");
		System.out.println("enter 2 to update salary");
		System.out.println("enter 3 to update department");
		
		int choice = sc.nextInt();
		
		System.out.println("enter id to update");
		int id = sc.nextInt();
		
		Statement statement = connection.createStatement();
		
		switch (choice) {
		case 1: {
			
			String query = "update employee set name = ? where id = " + id;
	
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			System.out.println("enter new name");
			preparedStatement.setString(1, sc.next());
			
			preparedStatement.execute();
			
			System.out.println("Name updated...");
			
			break;
		}
		
		case 2: {
	
			String query = "update employee set salary = ? where id = " + id;
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			System.out.println("enter new salary");
			preparedStatement.setDouble(1, sc.nextDouble());
			
			preparedStatement.execute();
			
			System.out.println("Salary updated...");
			
			break;
		}
		
		case 3: {
	
			String query = "update employee set dept = ? where id = " + id;

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			System.out.println("enter new department");
			preparedStatement.setString(1, sc.next());
			
			preparedStatement.execute();
			
			System.out.println("Department updated...");
			
			break;
		}
		
		default:
			System.out.println("invalid choice !!");
		}
		
	}

	private void delete() throws SQLException {
		
		System.out.println("enter id to delete");
		int id = sc.nextInt();
		
		String query = "delete from employee where id = " + id ;
		 
		Statement statement = connection.createStatement();
		
		statement.executeUpdate(query);
		
		System.out.println("Record deleted successfully");
	}

}