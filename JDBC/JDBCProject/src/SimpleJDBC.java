import java.sql.*;
import java.io.*;

public class SimpleJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "Bharath@123");
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("select * from example_table");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

	}
}
