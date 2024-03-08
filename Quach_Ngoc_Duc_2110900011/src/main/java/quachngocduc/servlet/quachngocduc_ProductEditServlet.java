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
 * Servlet implementation class quachngocduc_ProductEditServlet
 */
@WebServlet("/productEdit")
public class quachngocduc_ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quachngocduc_ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
		int code = Integer.parseInt(request.getParameter("code"));
		if(code == 0) {
			errorString="Bạn chưa chọn sản phẩm cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		QuachNgocDuc_2110900011_Product product = null;
		errorString = null;
		try {
			conn = ConnectionUtils.getSQLConnection();
			product = quachngocduc_ProductUtils.findProduct(conn, code);
			if(product==null) {
				errorString="Không tìm thấy sản phẩm có mã" + code;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || product == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String MaSP_2110900011 = request.getParameter("MaSP");
		String TenSP_2110900011 = request.getParameter("TenSP");
		String SoLuong_2110900011 = (String) request.getParameter("SoLuong");
		String DonGia_2110900011 = (String) request.getParameter("DonGia");
		String Anh_2110900011 = (String) request.getParameter("Anh");
		int maSP = 0;
		int soluong = 0;
		float donGia=0;
		try {
			maSP = Integer.parseInt(MaSP_2110900011);
			soluong = Integer.parseInt(SoLuong_2110900011);
			donGia = Float.parseFloat(DonGia_2110900011);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		QuachNgocDuc_2110900011_Product product = new QuachNgocDuc_2110900011_Product(maSP,TenSP_2110900011,soluong,donGia,Anh_2110900011);
		if (errorString != null) {
request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getSQLConnection();
			quachngocduc_ProductUtils.UpdateProduct(conn, product);
			response.sendRedirect(request.getContextPath() + "/ProductList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
