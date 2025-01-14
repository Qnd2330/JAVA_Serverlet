package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartmentDAOImpl;
@WebServlet("/DepartmentDelete")
public class DepartmentDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorString = null;
		String deptIdStr = (String) request.getParameter("deptId");
		
		int deptId = 0;
		try {
			deptId = Integer.parseInt(deptIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}

		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DepartmentDelete.jsp");
			dispatcher.forward(request, response);
		}else {
			
			boolean flag = new DepartmentDAOImpl().deleteDepartment(deptId);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/DepartmentList");
			}
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
