package com.eShoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int categoryId;	
	
	@OneToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@NotEmpty(message ="Category name cannot be empty")
	@Column(name="name")
	private String cateogoryName;

	@Column(name="description")
	private String description;

	

	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCateogoryName() {
		return cateogoryName;
	}

	public void setCateogoryName(String cateogoryName) {
		this.cateogoryName = cateogoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
