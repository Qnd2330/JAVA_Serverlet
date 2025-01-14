package Servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartmentDAOImpl;
import DAO.EmployeeDAOImpl;
import Entity.Department;
import Entity.Employee;

@WebServlet("/EmployeeCreate")
public class EmployeeCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorString = null;
		List<Department> listD = null;
		List<Employee> listE = null;
			
		listD = new DepartmentDAOImpl().getAllDepartment();
		listE = new EmployeeDAOImpl().getAllEmployee();
		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("departmentList", listD);
		request.setAttribute("employeeList", listE);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String empIdStr = (String) request.getParameter("empId");
		String empName = (String) request.getParameter("empName");
		String empNo = (String) request.getParameter("empNo");
		String departmentStr = (String) request.getParameter("department");
		String job = (String) request.getParameter("job");
		String salaryStr = (String) request.getParameter("salary");
		String employeeStr = (String) request.getParameter("employee");

		BigInteger empId = new BigInteger("0");
		int department = 0;
		float salary = 0;
		BigInteger employee = new BigInteger("0");
		try {
			department = Integer.parseInt(departmentStr);
			salary = Float.parseFloat(salaryStr);
			empId = new BigInteger(empIdStr);
			employee = new BigInteger(employeeStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		Department dept = new DepartmentDAOImpl().getDepartmentById(department);
		Employee emp = new EmployeeDAOImpl().getEmployeeById(employee);
		Calendar cal = Calendar.getInstance();
		Employee newEmployee = new Employee(empId, dept, emp, empName, empNo, (Date) cal.getTime(), job, salary);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		String regex = "\\d+";
		if (empIdStr == null || !empIdStr.matches(regex)) {
			errorString = "Mã nhân viên phải là số invalid!";
		}

		if (errorString != null){
			request.setAttribute("errorString", errorString);
			request.setAttribute("employee", newEmployee);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeCreate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		try {
			boolean flag = new EmployeeDAOImpl().insertEmployee(newEmployee);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/EmployeeList");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/EmployeeCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
