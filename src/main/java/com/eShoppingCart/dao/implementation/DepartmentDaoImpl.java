package com.eShoppingCart.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.DepartmentDao;
import com.eShoppingCart.model.Department;
import com.eShoppingCart.model.Product;


@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Department> getDepartmentList() {
		return sessionFactory.getCurrentSession().createQuery("from Department")
                .list();
	}

	@Override
	public Department getDepartmentById(int deptId) {
		return (Department) sessionFactory.getCurrentSession().get(
				Department.class, deptId);
	}

	@Override
	public void deleteDepartment(Department dept) {
		sessionFactory.getCurrentSession().delete(dept);

	}

	@Override
	public void addDepartment(Department dept) {
		sessionFactory.getCurrentSession().save(dept);

	}

	@Override
	public void editDepartment(Department dept) {
		sessionFactory.getCurrentSession().update(dept);

	}

}
