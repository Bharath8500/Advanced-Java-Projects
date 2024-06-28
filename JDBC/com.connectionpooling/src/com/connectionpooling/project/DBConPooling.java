package com.connectionpooling.project;
import java.sql.*;
public class DBConPooling {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ConnectionPooling cp = new ConnectionPooling("jdbc:mysql://localhost:3306/bharath","root","Bharath@123");
		cp.addConnectionToPool();
		System.out.println("Using connectionPool");
		System.out.println("***User-1***");
		Connection con1 = cp.userConnectionFromPool();
		System.out.println("***User-2***");
		Connection con2 =cp.userConnectionFromPool();
		System.out.println("***User-3***");
		Connection con3 = cp.userConnectionFromPool();
		System.out.println("Returning connection to pool");
		cp.returnConnectionToPool(con1);
		cp.returnConnectionToPool(con2);
		cp.returnConnectionToPool(con3);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	

}
