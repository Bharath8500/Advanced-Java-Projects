package test;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pCode = (String) req.getParameter("code");
		String PName = (String) req.getParameter("name");
		float pPrice = Float.parseFloat(req.getParameter("price"));
		float pQty = Float.parseFloat(req.getParameter("qty"));
		ProductBean pb = new ProductBean();
		pb.setpCode(pCode);
		pb.setpName(PName);
		pb.setpPrice(pPrice);
		pb.setpQty(pQty);
		int k = new DAOLayerProduct().insert(pb);
		if(k>0) {
			req.setAttribute("msg", "Product is Added successfully<br>");
			 RequestDispatcher rd = req.getRequestDispatcher("AddProduct.jsp");
			 rd.forward(req, res);
		}
	}
}
