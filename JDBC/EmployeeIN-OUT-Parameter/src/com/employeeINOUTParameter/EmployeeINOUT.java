package com.employeeINOUTParameter;
import java.sql.*;
import java.util.*;
public class EmployeeINOUT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			try {
				
		Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath","root","Bharath@123");
          CallableStatement cs = con.prepareCall("{call retrieveEmpDetails(?,?,?,?,?)}");
          System.out.println("Enter the Employee Id to retrieve Data: ");
          String empId = sc.nextLine();
          cs.setString(1, empId);
          cs.registerOutParameter(2, Types.VARCHAR);
          cs.registerOutParameter(3, Types.VARCHAR);
          cs.registerOutParameter(4,Types.DOUBLE);
          cs.registerOutParameter(5,Types.DOUBLE);
          cs.execute();
          System.out.println("*******Employee Details*******");
          System.out.println("\n Employee Name: "+cs.getString(2)+"\n Employee Designation: "+cs.getString(3)+"\n Employee BasicSalary: "+cs.getDouble(4)+"\n Employee TotalSalary: "+cs.getDouble(5));
          cs.close();
          con.close();
	}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
