
package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends GenericServlet{
	@Override
	public void init()throws ServletException {
	//NoCode
		}
	
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
		PrintWriter pw = servletResponse.getWriter();
		servletResponse.setContentType("text/html");
		String var = servletRequest.getParameter("productCode");
		String var1 = servletRequest.getParameter("productName");
		String var2 = servletRequest.getParameter("productPrice");
		String var3 = servletRequest.getParameter("productQty");
        pw.print("*****DisplayServlet****");
        pw.println("<br>Productcode: "+var);
        pw.println("<br>ProductName: "+var1);
        pw.println("<br>ProductPrice: "+var2);
        pw.println("<br>ProductQty: "+var3);
	}
	@Override
	public void destroy() {
	//NoCode
		}
	}
