package com.kitAttendance;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		EmployeeInterface si=new EmployeeImplementation();

		while(true) {
			System.out.println("Empoyee Database");
			System.out.println("1.AddEmployee\n2.DeleteEmployee\n3.GetAllEmployeeDetails");
			System.out.println("Enter your choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				si.addEmployee();
				break;
			case 2:
				si.deleteEmployee();
				break;
			case 3:
				si.getAllEmployeeDetails();
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}



	}


