package com.eShoppingCart.service;

import java.util.List;

import com.eShoppingCart.model.Department;
import com.eShoppingCart.model.Product;

public interface DepartmentService {
	List<Department> getDepartmentList();

	Department getDepartmentById(int deptId);
    
    void deleteDepartment(Department dept);
    
    void addDepartment(Department dept);
    
    void editDepartment(Department dept);
}
