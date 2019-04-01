package com.eShoppingCart.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.CategoryDao;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Department;
import com.eShoppingCart.model.Product;
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoryById(int id) {
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category c where c.department.departmentId=:dept")
                .setParameter("dept", id)
				.list();
	}

	@Override
	public void deleteCategory(int cat) {
		sessionFactory.getCurrentSession().createQuery("delete from Category c where c.categoryId=:cat")
        .setParameter("cat", cat).executeUpdate();
		
	}

	@Override
	public void addCategory(Category cat) {
		sessionFactory.getCurrentSession().save(cat);
		
	}

	@Override
	public void editCategory(Category cat) {
		sessionFactory.getCurrentSession().update(cat);
		
	}

	@Override
	public Category getCategoryById1(int id) {
		return (Category) sessionFactory.getCurrentSession().get(
				Category.class, id);
	}

	
	@Override
	public List<Category> getCategoryAll() {
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category")
                .list();
	}

	@Override
	public List<Integer> getProductByCategoryId(int id) {
		return (List<Integer>) sessionFactory.getCurrentSession().createQuery("select productId from ProductCategory c where c.categoryId=:prod")
                .setParameter("prod", id)
				.list();
	}
	@Override
	public Product getProductByProductId(int id) {
		return (Product) sessionFactory.getCurrentSession().createQuery("from Product c where c.id=:prod")
                .setParameter("prod", id)
				.uniqueResult();
	}

	@Override
	public List<Object> getAttributeValues(int id) {
		return (List<Object>) sessionFactory.getCurrentSession().createQuery("select c.id, c.attributeId, c.value from AttributeValue c,ProductAttribute p,Attribute a where c.id=p.attributeValue and c.attributeId=a.id and p.id=:prod and a.name='Color'")
                .setParameter("prod", id)
				.list();
	}
	
	@Override
	public List<Object> getAttributeValues1(int id) {
		return (List<Object>) sessionFactory.getCurrentSession().createQuery("select c.id, c.attributeId, c.value from AttributeValue c,ProductAttribute p,Attribute a where c.id=p.attributeValue and c.attributeId=a.id and p.id=:prod and a.name='Size'")
                .setParameter("prod", id)
				.list();
	}
}
