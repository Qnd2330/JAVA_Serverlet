package quachngocduc.servlet;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class quachngocduc_ProductCreateServlet
 */
@WebServlet("/productCreate")
public class quachngocduc_ProductCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quachngocduc_ProductCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String MaSP_2110900011 = request.getParameter("MaSP");
		String TenSP_2110900011 = request.getParameter("TenSP");
		String SoLuong_2110900011 = (String) request.getParameter("SoLuong");
		String DonGia_2110900011 = (String) request.getParameter("DonGia");
		String Anh_2110900011 = (String) request.getParameter("Anh");
		int maSP = 0;
		int soluong = 0;
		float donGia=0;
		try {
			maSP = Integer.valueOf(MaSP_2110900011);
			soluong = Integer.parseInt(SoLuong_2110900011);
			donGia = Float.parseFloat(DonGia_2110900011);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		QuachNgocDuc_2110900011_Product product = new QuachNgocDuc_2110900011_Product(maSP,TenSP_2110900011,soluong,donGia,Anh_2110900011);
		// Kiểm tra code ít nhất 1 ký tự là zA-Z_0-9]
		String regex = "\\w+";
		if (MaSP_2110900011 == null) {
			errorString = "Product maSP invalid!";
		}

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		Connection conn = null;
		try {
			conn = ConnectionUtils.getSQLConnection();
			quachngocduc_ProductUtils.insertProduct (conn, product);
			response.sendRedirect(request.getContextPath() + "/ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
			dispatcher.forward(request, response);
		}
	}
}
