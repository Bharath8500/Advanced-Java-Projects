package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/prime")
public class Prime extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws 
	ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		 int n = Integer.parseInt(req.getParameter("val"));
		 int count=0;
		 for(int i=1;i<=n;i++)
		 {
			 if(n%i==0)
			 {
				 count++;
			 }
		 }
		 if(count==2) pw.println("Prime Number..<br>");
		 else pw.println("Not Prime Number...<br>");
		 RequestDispatcher rd =
				 req.getRequestDispatcher("input.html");
		 rd.include(req, res);

	}

}
