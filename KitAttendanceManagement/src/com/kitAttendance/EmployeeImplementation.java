package com.kitAttendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;


	public class EmployeeImplementation implements EmployeeInterface{
		Scanner scan=new Scanner(System.in);
		@Override
		public void addEmployee() {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/kitdatabase", "root", "root");
				PreparedStatement ps=connection.prepareStatement("insert into employee values(?,?,?,?,?)");
				System.out.println("Enter Employee Id");
				ps.setInt(1,scan.nextInt());

				System.out.println("Enter Employee Name");
				ps.setString(2, scan.next());

				System.out.println("Enter Employee In-time");
				ps.setString(3,scan.next());

				System.out.println("Enter Employee Out-time");
				ps.setString(4,scan.next());

				System.out.println("Enter Employee status");
				ps.setString(5,scan.next());

				ps.execute();
				connection.close();
				System.out.println("Date saved");


			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


		@Override
		public void getAllEmployeeDetails() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/kitdatabase", "root", "root");
				PreparedStatement ps=connection.prepareStatement("select * from employee");
				ResultSet resultset=ps.executeQuery();
				while(resultset.next()) {
					System.out.println("Employee Id : "+resultset.getInt(1));
					System.out.println("Employee name :"+resultset.getString(2));
					System.out.println("Employee In-time : "+resultset.getString(3));
					System.out.println("Employee out-time: "+resultset.getString(4));
					System.out.println("Employee status : "+resultset.getString(5));
					System.out.println("----------------------------------");
				}
				ps.execute();
				connection.close();
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		}

		@Override
		public void deleteEmployee() {
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/kitdatabase", "root", "root");
				PreparedStatement ps=connection.prepareStatement("delete from employee where id=?");
				System.out.println("Enter the Id");
				ps.setInt(1, scan.nextInt());
				ps.execute();
				connection.close();
				System.out.println("Data deleted");

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

			
		}


	
}
