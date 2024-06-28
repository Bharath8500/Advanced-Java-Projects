package com.FileInputStream.project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.sql.*;
import java.util.*;
public class InputStreamProject {

	public static void main(String[] args) throws SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/bharath",
				"root",
				"Bharath@123");
	    DatabaseMetaData dbmd = con.getMetaData();
	    dbmd.getDriverName();
	    PreparedStatement ps = con.prepareStatement("insert into StreamTab57 values(?,?)");
	    PreparedStatement ps1 = con.prepareStatement("Select * from StreamTab57 where id=?");
	   System.out.println("Enter the id to insert: ");
	    int id = sc.nextInt();
	    ps.setInt(1, id);
	    sc.nextLine();
	    System.out.println("Enter the filepath with name: ");
	    String filePath = sc.nextLine();
	    File file = new File(filePath);
	    if(file.exists()) {
		    FileInputStream fis = new FileInputStream(file);
		    ps.setBinaryStream(2, fis, file.length());
            int k =ps.executeUpdate();
            if(k>0) {
            	System.out.println("Image is successfully uploaded into database");
            }
	    }
	    else {
	    	System.out.println("Invalid path");
	    }
	    System.out.println("Enter the id: ");
	    int id1 = sc.nextInt();
	    ps1.setInt(1, id1);
	    sc.nextLine();
	   ResultSet rs1= ps1.executeQuery();
	   if(rs1.next()) {
		   Blob blob = rs1.getBlob(2);
		   byte[] b = blob.getBytes(1, (int) blob.length());
		   System.out.println("enter the path of the file: ");
		   String path = sc.nextLine();
		   File file1 = new File(path);
		   try (FileOutputStream fos = new FileOutputStream(file1)) {
			fos.write(b);
			System.out.println("Image retrieved successfully");
		}
		   
	   }
	    con.close();
	}

}
