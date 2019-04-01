package com.eShoppingCart.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eShoppingCart.dao.AttributeDao;
import com.eShoppingCart.model.Attribute;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;


@Repository
@Transactional
public class AttributeDaoImpl implements AttributeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Attribute> getAttributeAll() {
		List<Attribute> att=sessionFactory.getCurrentSession().createQuery("from Attribute")
                .list();
		return att;
	}

	@Override
	public void addAttribute(Attribute att) {
		sessionFactory.getCurrentSession().save(att);
		
	}

	@Override
	public void deleteAttribute(int att) {
		sessionFactory.getCurrentSession().createQuery("delete from Attribute c where c.id=:att")
        .setParameter("att", att).executeUpdate();
		
	}

	@Override
	public Attribute getAttributeById(int id) {
		return (Attribute) sessionFactory.getCurrentSession().get(
				Attribute.class, id);
	}

	@Override
	public void editAttribute(Attribute att) {
		sessionFactory.getCurrentSession().update(att);
		
	}

	@Override
	public List<AttributeValue> getAttributeValue(int id) {
		List<AttributeValue> att=sessionFactory.getCurrentSession().createQuery("from AttributeValue a where a.attributeId=:att")
                .setParameter("att", id)
				.list();
		return att;
	}

	@Override
	public void addAttributeValue(AttributeValue att) {
		sessionFactory.getCurrentSession().save(att);
		
	}
	@Override
	public void deleteAttributeValue(int att) {
		sessionFactory.getCurrentSession().createQuery("delete from AttributeValue c where c.id=:att")
        .setParameter("att", att).executeUpdate();
		
	}
}
