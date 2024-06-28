package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/choice")
public class ServletChoice extends GenericServlet{

	@Override
	public void service(ServletRequest req,
			ServletResponse res) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = req.getParameter("s1");
		if(s1.equals("Factorial")) {
			RequestDispatcher rd = req.getRequestDispatcher("/factorial");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd1 = req.getRequestDispatcher("/prime");
			rd1.forward(req, res);
		}
		
	}

}
