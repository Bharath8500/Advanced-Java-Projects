package customerDataProject;
import java.util.*;
import java.sql.*;
public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try(scanner;){
			try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "Bharath@123");
        
		CallableStatement cs = con.prepareCall("{call insertCustomerDetails(?,?,?,?,?,?,?)}");
		CallableStatement cs1 = con.prepareCall("{call retrieveCustomerDetails(?,?,?,?,?,?,?)}");
		System.out.println("Enter the choice: ");
		System.out.println("1.Insert Details \n2.Retrieve Details");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
		System.out.println("Enter the customer Id: ");
		int cId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the customer Name: ");
		String cName = scanner.nextLine();
		System.out.println("Enter the customer city: ");
		String cCity = scanner.nextLine();
		System.out.println("Enter the customer state: ");
		String cState = scanner.nextLine();
		System.out.println("Enter the customer pincode: ");
		String cPincode = scanner.nextLine();
		System.out.println("Enter the customer MailId: ");
		String cMailId = scanner.nextLine();
		System.out.println("Enter the customer phone number: ");
		String cPhno = scanner.nextLine();
		cs.setInt(1, cId);
		cs.setString(2, cName);
		cs.setString(3, cCity);
		cs.setString(4, cState);
		cs.setString(5, cPincode);
		cs.setString(6, cMailId);
		cs.setString(7, cPhno);
        cs.execute();
        System.out.println("Succefully inserted");
        break;
		case 2:
        System.out.println("Enter the customer id to get the details of customer: ");
        int cusId = scanner.nextInt();
        cs1.setInt(1, cusId);
        cs1.registerOutParameter(2, Types.VARCHAR);
        cs1.registerOutParameter(3, Types.VARCHAR);
        cs1.registerOutParameter(4, Types.VARCHAR);
        cs1.registerOutParameter(5, Types.VARCHAR);
        cs1.registerOutParameter(6, Types.VARCHAR);
        cs1.registerOutParameter(7, Types.INTEGER);
        cs1.execute();
        System.out.println("Customer Name: "+cs1.getString(2)+"\n Customer city: "+cs1.getString(3)+"\n Customer state: "+cs1.getString(4)+
        		"\n Customer pincode: "+cs1.getString(5)+"\n Customer MailId: "+cs1.getString(6)+" \n Customer PhoneNo: "+cs1.getString(7));
        break;
	}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	}
}
