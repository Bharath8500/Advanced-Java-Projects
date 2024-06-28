package test;
import java.io.*;
import jakarta.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/factorial")
public class Factorial extends GenericServlet{

	@Override
	public void service(ServletRequest req, 
			ServletResponse res) throws 
	        ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		// TODO Auto-generated method stub
        int num = Integer.parseInt(req.getParameter("val"));
        int fact=1;
        for(int i=num;i>=1;i--) {
        	fact = fact*i;
        }
        pw.println("Factorial: "+fact+"<br>");
        RequestDispatcher rd  = req.getRequestDispatcher("input.html");
        rd.include(req, res);	
	}

}
