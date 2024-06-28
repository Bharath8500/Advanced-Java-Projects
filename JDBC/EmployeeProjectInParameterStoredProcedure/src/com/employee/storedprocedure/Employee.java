package com.employee.storedprocedure;
import java.util.*;
import java.sql.*;
import javax.sql.*;
public class Employee {
//In-parameter stored procedure program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try(sc;) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath","root","Bharath@123");
                CallableStatement cs = con.prepareCall("{call InsertDetails(?,?,?,?,?)}");
                System.out.println("Enter the Employee ID: ");
                String empId = sc.nextLine();
                System.out.println("Enter the Employee Name: ");
                String eName = sc.nextLine();
                System.out.println("Enter the Employee Designation: ");
                String eDesig = sc.nextLine();
                System.out.println("Enter the Employee Basic Salary: ");
                double eBasicSal = sc.nextDouble();
                double eTotalSal = (0.93 * eBasicSal) + (0.63 *eBasicSal) ;
                cs.setString(1,empId);
                cs.setString(2, eName);
                cs.setString(3, eDesig);
                cs.setDouble(4, eBasicSal);
                cs.setDouble(5,eTotalSal);
                cs.execute();
                System.out.println("Details are successfully created");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}
}
