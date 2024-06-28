package com.connectionpooling.project;
import java.sql.*;
import java.util.*;
public class ConnectionPooling {
	String url;
	String userName;
	String password;
	public ConnectionPooling(String url,String userName, String password) {
		this.url=url;
		this.userName = userName;
		this.password=password;
	}
	public Vector<Connection> vc = new Vector<Connection>();
	public void addConnectionToPool() throws SQLException {
		int count=1;
		Connection con = DriverManager.getConnection(url, userName, password);
		while(vc.size()<5) {
			System.out.println("Pool is not filled");
			vc.addElement(con);
			System.out.println("Connection Object: "+count+" Connection hashcode: "+con);
			count++;
		}
		if(vc.size()==5) {
			System.out.println("Pool is filled");
		}
	}
	public Connection userConnectionFromPool() {
		Connection con = vc.elementAt(0);
		vc.removeElementAt(0);
       System.out.println("Size of the Connectionpool: "+vc.size());
       return con;
	}
	public void returnConnectionToPool(Connection con) {
		vc.addElement(con);
		System.out.println("Size of the connectionpool: "+vc.size());
	}

}
