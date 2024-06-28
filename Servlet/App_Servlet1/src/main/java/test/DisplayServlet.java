package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends GenericServlet {
@Override
public void init()throws ServletException {
//NoCode
	}
@Override
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
String uName = req.getParameter("uname");
String mId = req.getParameter("mid");
pw.println("*****DisplayServlet****");
pw.println("<br>UserName:"+uName);
pw.println("<br>MailId:"+mId);
}
@Override
public void destroy() {
//NoCode
	}
}
