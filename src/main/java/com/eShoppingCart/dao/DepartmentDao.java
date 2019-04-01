package com.eShoppingCart.dao;

import java.util.List;

import com.eShoppingCart.model.Department;

public interface DepartmentDao {
	List<Department> getDepartmentList();

	Department getDepartmentById(int deptId);
    
    void deleteDepartment(Department dept);
    
    void addDepartment(Department dept);
    
    void editDepartment(Department dept);
}
