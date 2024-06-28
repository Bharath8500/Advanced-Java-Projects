/*
Ex-program:
Construct JDBC Application to perform the following operations on DB-table 
Product57 based on User Choice:
          1.AddProduct
          2.ViewAllProducts
          3.UpdateProductByCode
          4.UpdateProductByCode(price-qty)
          5.DeleteProductByCode
          6.DeleteAllTheRecords
*/

package com.product57;
import java.sql.*;
import java.io.*;
import java.util.*;
public class Product57 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
			try {
		//Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath","root","Bharath@123");
		//PrepareStatement
		PreparedStatement ps1 = con.prepareStatement("insert into Product57 values (?,?,?,?)");//Compilation
		PreparedStatement ps2 =  con.prepareStatement("Select * from Product57");
		PreparedStatement ps3 =  con.prepareStatement("Select * from Product57 where code =?");		
		PreparedStatement ps4 = con.prepareStatement("update Product57 set price =?,qty =qty+? where code=?");
		PreparedStatement ps5 = con.prepareStatement("Delete from Product57 where code = ?");
		PreparedStatement ps6 = con.prepareStatement("Delete from Product57");
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*********Choice******");
			System.out.println("1.AddProduct");
			System.out.println("2.ViewAllProducts");
			System.out.println("3.UpdateProductByCode");
			System.out.println("4.UpdateProductByCode(price-qty)");
			System.out.println("5.DeleteProductByCode");
			System.out.print("Enter the choice to perform: ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1:
				/*Create table Product57(code varchar2(10), 
				 * name varchar2(15), price number(10,2), qty number(10), 
				 * primary key(code));*/
				System.out.print("Enter the Product code: ");
				String pC = sc.nextLine();
				System.out.print("Enter the product name: ");
				String pN = sc.nextLine();
				System.out.print("Enter the product price: ");
				int pP = Integer.parseInt(sc.nextLine());
				System.out.print("Enter the quantity of the product: ");
				int qP = Integer.parseInt(sc.nextLine());
				ps1.setString(1, pC);
				ps1.setString(2, pN);
				ps1.setInt(3, pP);
				ps1.setInt(4, qP);
				int value = ps1.executeUpdate();
				if(value>0) {
					System.out.println("The product details are sucessuflly created in the Database");
				}
				break;
			case 2:
				ResultSet rs = ps2.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				}
				break;
			case 3:
				System.out.println("Enter the product code: ");
				String pcode = sc.nextLine();
				ps3.setString(1, pcode);
				ResultSet rs3 = ps3.executeQuery(); 
				if(rs3.next()) {
					System.out.println("This is Old Details");
					System.out.println("Product code: "+rs3.getString(1)+" Product Name: "+rs3.getString(2)+" Product price :"+rs3.getInt(3)+" Product qty: "+rs3.getInt(4));
				}
				else {
					System.out.println("Invalid Product ID");
				}
				
				break;
			case 4:
				System.out.println("Enter the product code: ");
				String pcode1 = sc.nextLine();
				ps3.setString(1, pcode1);
				ResultSet rs4 = ps3.executeQuery();
				if(rs4.next()) {
					System.out.println("This is Old Details");
					System.out.println("Product code: "+rs4.getString(1)+" Product Name: "+rs4.getString(2)+" Product price :"+rs4.getInt(3)+" Product qty: "+rs4.getInt(4));
					System.out.println("Enter the new price: ");
					int newPrice = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the quantity: ");
					int newQuantity = Integer.parseInt(sc.nextLine());
					ps4.setInt(1, newPrice);
					ps4.setInt(2, newQuantity);
					ps4.setString(3, rs4.getString(1));
					int updateDetails = ps4.executeUpdate();
					if(updateDetails>0) {
						System.out.println("Details are Updated successfully");
					}
					else {
						System.out.println("Invalid Product ID");
					}
				}
				break;
			case 5:
				//Delete Product by code
				System.out.print("Enter the product code: ");
				String productCode = sc.nextLine();
				ps5.setString(1,productCode);
				int valueCheck = ps5.executeUpdate();
				if(valueCheck>0) {
                  System.out.println("The row is successfully deleted");
				}
				else {
					System.out.println("Invalid Details");
				}
				break;
			case 6:
				int k6 = ps6.executeUpdate();
				if(k6>0) {
					System.out.println("All the records in the table are deleted");
				}
				break;
			case 7:
			System.out.println("Operations stopped");
			System.exit(0);
			case 8:
				System.out.println("                         ");
				System.out.println("******Invalid Entry******");
				System.out.println("                         ");

			}
		}
	 }
			
			catch (SQLIntegrityConstraintViolationException sl) {
				sl.printStackTrace();
			}
			finally {
				
			}

  }
}
