package com.employee;
import java.sql.*;
import java.util.*;
public class Employee {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "Bharath@123");
    PreparedStatement ps1 = con.prepareStatement("insert into Employee values(?,?,?,?)");
    PreparedStatement ps2 = con.prepareStatement("Select * from Employee");
    PreparedStatement ps3 = con.prepareStatement("Select * from Employee where eId =?");
    PreparedStatement ps4 = con.prepareStatement("Update Employee set basicSalary = ?, totalSalary=? where eId=? ");
    PreparedStatement ps5 = con.prepareStatement("Delete from Employee where eId=? ");
    while(true) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("******Choice******");
        System.out.println("1.AddEmployee");
        System.out.println("2.ViewAllEmployees");
        System.out.println("3.ViewEmployeeById");
        System.out.println("4.UpdateEmployeeById-(basicSalary)");
        System.out.println("5.DeleteEmployeeById");
        System.out.println("6.Exit");
    	System.out.print("Enter the specific number from choice to perfom action: ");
    	int num = sc.nextInt();
    	switch(num) {
    	case 1:
    		System.out.print("Enter the employee Id: ");
    		int eId = sc.nextInt();
    		sc.nextLine();
    		System.out.print("Enter the employee name: ");
    		String eName = sc.nextLine();
    		System.out.print("Enter the employee basic salary: ");
    		float bSalary = sc.nextFloat();
            float totalSalary;
            float hra = (float) (0.93 * bSalary);
            float da = (float) (0.61 * bSalary);
            totalSalary  = (hra + da)+bSalary;
            ps1.setInt(1, eId);
            ps1.setString(2, eName);
            ps1.setFloat(3, bSalary);
            ps1.setFloat(4, totalSalary);
            int check = ps1.executeUpdate();
            if(check>0) {
            	System.out.println("Details are created successfully");
            }else {
            	System.out.println("Unsuccessfull");
            }
    		break;
    	case 2:
    		ResultSet rs1 = ps2.executeQuery();
    		while(rs1.next()) {
    			System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getFloat(3)+" "+rs1.getFloat(4));
    		}
    		break;
    	case 3:
    		System.out.println("Enter the employee Id: ");
    		int employeeId = sc.nextInt();
    		ps3.setInt(1, employeeId);
    		ResultSet rs3 = ps3.executeQuery();
    		if(rs3.next()) {
    			System.out.println(rs3.getInt(1)+" "+rs3.getString(2)+" "+rs3.getFloat(3)+" "+rs3.getFloat(4));
    		}
    		else {
    			System.out.println("Invalid ID");
    		}
    		break;
    	case 4:
    		System.out.println("Enter the employee ID: ");
    		int empId = sc.nextInt();
    		System.out.println("Enter the employee basic salary to update: ");
    		float empBasicSalary = sc.nextFloat();
    		ps4.setFloat(1, empBasicSalary);
    		float hra1 = (float) (0.93 * empBasicSalary);
            float da1 = (float) (0.61 * empBasicSalary);
    		float totalSalary1 = (hra1 + da1)+empBasicSalary;
    		ps4.setFloat(2, totalSalary1);
    		ps4.setInt(3, empId);
    		int check1 = ps4.executeUpdate();
    		if(check1>0) {
    			System.out.println("Details are successfully updated");
    		}
    		else {
    			System.out.println("Invalid Details");
    		}
    		
    		break;
    	case 5:
    		System.out.println("Enter the employee ID: ");
    		int empId1 = sc.nextInt();
    		ps5.setInt(1, empId1);
    		int check2 = ps5.executeUpdate();
    		if(check2>0) {
    			System.out.println("Employee details are successfully deleted");
    		}
    		else {
    			System.out.println("Invalid Employee Details");

    		}
    		break;
    	case 6:
    		System.out.println("Operation are ended");
    		System.exit(0);
            break;
    	case 7:
    		System.out.println("Invalid choice");
    	}
    }

	}

}
