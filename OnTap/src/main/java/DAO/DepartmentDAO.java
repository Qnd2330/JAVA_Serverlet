package DAO;

import java.util.List;

import Entity.Department;

public interface DepartmentDAO {
	public List<Department> getAllDepartment();
	public Department getDepartmentById(int id);
	public boolean insertDepartment(Department department);
	public boolean updateDepartment(Department department);
	public boolean deleteDepartment(int id);
}
