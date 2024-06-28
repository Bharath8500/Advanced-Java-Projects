package com.transaction.bank.project;
import java.util.*;
import java.sql.*;
public class BankProject {

	/*
	 * Step-1: Check the commit operation
	 * Step-2: Set the autocommit to false using the method setAutoCommit() method;
	 * Step-3: create PrepareStatement Object and provide sql query in parameter to retrieve 
	 * the deatils of the customer.
	 * Step-4: Create another PrepareStatement object to update the customer balance
	 * Step-5: Create a savepoint 
	 * Step-6: If the account number is present in the database processed to do the transaction 
	 * else print the invalid account number
	 * Step-7: If sub-statements are successfully done print the transaction is done 
	 * successfully and perform commit operation
	 * Step-8: else rollback the operation.     
	 * */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, Invalid {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the account number: ");
        int acctNo = scanner.nextInt();
        try{
        checkBankDetials(acctNo);
	}
        catch(Invalid excep) {
        	System.out.println(excep.getMessage());
        }
	}
	public static void checkBankDetials(int acctNo) throws ClassNotFoundException, SQLException, Invalid {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/bharath", 
				"root", 
				"Bharath@123"
				);
		PreparedStatement ps1 = con.prepareStatement(
				"select * from CustomerBank where acctNo = ?"
				);
		PreparedStatement ps2 = con.prepareStatement(
				"Update CustomerBank set cusBal = cusBal+? where acctNo =? "
				);
             System.out.println("Checking commit operation: "+con.getAutoCommit());
             con.setAutoCommit(false); 
             System.out.println("Checking commit operation: "+con.getAutoCommit());
             ps1.setInt(1, acctNo);
             Savepoint sp =con.setSavepoint();
            ResultSet rs1 =  ps1.executeQuery();
             if(rs1.next()){
            	 Double balance1 =rs1.getDouble(3);
            	 System.out.println("Details are present");
            	 System.out.println("Enter the benificiary account number: ");
            	 int benAcctNo = sc.nextInt();
                 ResultSet rs2 =  ps1.executeQuery();
            	 if(rs2.next()) {
            		 System.out.println("Enter the amount to be transfered: ");
                	 double amtTransfer = sc.nextDouble();
                	 if(amtTransfer<=balance1)
                	 ps2.setDouble(1, -amtTransfer);
                	 ps2.setInt(2,acctNo);
                	 int transferingAcct = ps2.executeUpdate();
                	 ps2.setDouble(2, amtTransfer);
                	 ps2.setInt(2, benAcctNo);
                	 int benficiaryAcct = ps2.executeUpdate();
                	 if(transferingAcct==1 && benficiaryAcct==1) {
                		 con.commit();
                		 System.out.println("Transaction is done successfully");
                	 }
                	 else {
                		 con.rollback(sp);
                		 throw new Invalid("Unsuccessfully");
                	 }
            	 }
            	 else {
            		 con.rollback();
            	 }
             }
             else {
            	 throw new Invalid("Invalid account Number");
             }
             
			}
}