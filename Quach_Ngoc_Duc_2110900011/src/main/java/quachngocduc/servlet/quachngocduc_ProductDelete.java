package quachngocduc.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quachngocduc.conn.quachngocducConnection.ConnectionUtils;
import quachngocduc.utils.quachngocduc_ProductUtils;



/**
 * Servlet implementation class quachngocduc_ProductDelete
 */
@WebServlet("/productDelete")
public class quachngocduc_ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quachngocduc_ProductDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		String code = (String)request.getParameter("code");
		int maSP = 0;
		try {
			maSP = Integer.parseInt(code);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		try {
			conn = ConnectionUtils.getSQLConnection();
			quachngocduc_ProductUtils.deleteProduct(conn, maSP);
		}catch(Exception e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productDelete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/ProductList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
