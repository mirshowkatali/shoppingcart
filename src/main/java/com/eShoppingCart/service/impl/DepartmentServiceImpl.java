package com.eShoppingCart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShoppingCart.dao.DepartmentDao;
import com.eShoppingCart.dao.ProductDao;
import com.eShoppingCart.model.Department;
import com.eShoppingCart.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> getDepartmentList() {
		return departmentDao.getDepartmentList();
	}

	@Override
	public Department getDepartmentById(int deptId) {
		return departmentDao.getDepartmentById(deptId);
	}

	@Override
	public void deleteDepartment(Department dept) {
		departmentDao.deleteDepartment(dept);
		
	}

	@Override
	public void addDepartment(Department dept) {
		departmentDao.addDepartment(dept);
		
	}

	@Override
	public void editDepartment(Department dept) {
		departmentDao.editDepartment(dept);
		
	}

}
