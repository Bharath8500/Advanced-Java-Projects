 package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.*;
public class DAOLayerProduct
	{
		public int k=0;
		public int insert(ProductBean pb) {
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/bharath", 
						"root", "Bharath@123");
//				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into product58 values(?,?,?,?)");
				ps.setString(1, pb.getpCode());
				ps.setString(2, pb.getpName());
				ps.setFloat(3, pb.getpPrice());
				ps.setFloat(4,pb.getpQty());
				int k = ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return k;
		}
}