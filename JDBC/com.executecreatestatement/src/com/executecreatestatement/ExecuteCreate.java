package com.executecreatestatement;
import java.sql.*;
import java.util.*;

/*
 * Create table Cust( cid INT primary key, cname varchar(50), cage int, ccity varchar(10), mid varchar(20))
 * select * from EmpData
 * Update EmpData set eName ="Kavya" where eId=1
 * delete from EmpData where eId =2
 * */
public class ExecuteCreate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bharath", 
				"root", 
				"Bharath@123");
		 Statement st = con.createStatement();
		 System.out.println("Enter the query create/update to execute: ");
		 String choice = sc.nextLine();
		 if(choice.equals("create")) {
			 System.out.println("Enter the query: ");
			 String query5 = sc.nextLine();
				int v =  st.executeUpdate(query5);
				System.out.println("Value of executeUpdate: "+v);
				if(v==0) {
					System.out.println("Created successfully");
				}
				else {
					System.out.println("Table is not created");
				}

			 
			 
		 }
			 else {
				 System.out.println("Enter the query to update select/delete/update");
				 String choice1 = sc.nextLine();
				 
				 switch(choice1) {
				 case "select":
					 System.out.println("Enter the query: ");
					 String query1 = sc.nextLine();
					 ResultSet rs = st.executeQuery(query1);
					 if(rs.next()) {
						 System.out.println(
								 "id: "+rs.getInt(1)+
								 " empName: "+rs.getString(2)+ 
								 " empDesig: "+rs.getString(3));
						 
				 }
				 case "update":
					 System.out.println("Enter the query: ");
					 String query2 = sc.nextLine();
					 int ex1 = st.executeUpdate(query2);
					 if(ex1>0) {
						 System.out.println("Updated successfully");
					 }
					 else {
						 System.out.println("Updatation is failed");
					 }
					 System.out.println("Value of executeUpdate: "+ex1);
				 case "delete":
					 System.out.println("Enter the query: ");
					 String query3 = sc.nextLine();
					 int ex3 = st.executeUpdate(query3);
					 if(ex3>0) {
						 System.out.println("Deleted successfully");
					 }
					 else {
						 System.out.println("Deleted is failed");
					 }
					 System.out.println("Value of executeUpdate: "+ex3);

					
		 }

	}

}
}
