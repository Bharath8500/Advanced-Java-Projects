package com.rowsetconcepts;
import java.sql.SQLException;
import java.util.*;
import javax.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
public class RowSetConcept {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();
        System.out.println("*********choice*********");
        System.out.println("1.JDBC RowSet\n2.Cached Row Set\nEnter the choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice) {
        case 1:
        JdbcRowSet jrs = rsf.createJdbcRowSet();
        jrs.setUrl("jdbc:mysql://localhost:3306/bharath");
        jrs.setUsername("root");
        jrs.setPassword("Bharath@123");
        	break;
        case 2:
        	CachedRowSet crs = rsf.createCachedRowSet();
        	crs.setUrl("jdbc:mysql://localhost:3306/bharath");
        	crs.setUsername("root");
        	crs.setPassword("Bharath@123");
        	break;
        case 3:
        	System.out.println("Invalid choice");
        	break;
        }
        
	}

}
