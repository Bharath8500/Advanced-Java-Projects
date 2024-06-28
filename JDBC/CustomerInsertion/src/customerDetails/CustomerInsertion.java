package customerDetails;
import java.sql.*;
import java.io.*;
import java.util.*;
public class CustomerInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Scanner sc = new Scanner(System.in);
		//cid,cName, cage, ccity, mid
		System.out.println("Enter the customer ID: ");
		int id = Integer.parseInt(sc.nextLine());
		/*
		System.out.println("Enter the customer Name: ");
		String cName = sc.nextLine();
		System.out.println("Enter customer age: ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Enter customer city: ");
		String city = sc.nextLine();
		System.out.println("Enter customer mail ID: ");
		String mid = sc.nextLine();
		*/
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "Bharath@123");
		Statement st = cn.createStatement();
		/*
		int value = st.executeUpdate("insert into CustomerInfo values('"+id+"','"+cName+"', '"+age+"', '"+city+"','"+mid+"' )");
		if(value>0) {
			System.out.println("Customer Details are inserted sucessfully");
		}
		ResultSet rs = st.executeQuery("select * from CustomerInfo");
        while(rs.next()) {
        	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
		*/
        ResultSet rs1 = st.executeQuery("select * from CustomerInfo where cid = '"+id+"'");
        if(rs1.next()) {
        	System.out.println("Hello");
        	System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5));
        	}
        else {
        	System.out.println("Invalid Details");
        }
		}
		catch (SQLIntegrityConstraintViolationException sq) {
			System.out.println("This details already provided");
			
		}
		catch (Exception e) {
          e.printStackTrace();			
		}
		

	}

}
