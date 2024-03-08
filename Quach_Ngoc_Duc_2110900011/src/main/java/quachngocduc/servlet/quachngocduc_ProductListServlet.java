package quachngocduc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quachngocduc.beans.QuachNgocDuc_2110900011_Product;
import quachngocduc.conn.quachngocducConnection.ConnectionUtils;
import quachngocduc.utils.quachngocduc_ProductUtils;



/**
 * Servlet implementation class quachngocduc_ProductListServlet
 */
@WebServlet("/ProductList")
public class quachngocduc_ProductListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public quachngocduc_ProductListServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		List<QuachNgocDuc_2110900011_Product> list = null;
		try {
			conn = ConnectionUtils.getSQLConnection();
			
			try {
				list = quachngocduc_ProductUtils.queryProduct(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			// Store info in request attribute, before forward to views
			request.setAttribute("errorString", errorString);
			request.setAttribute("productList", list);
			// Forward to /WEB-INF/views/productListView.jsp
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductList.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
