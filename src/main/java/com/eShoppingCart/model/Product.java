package com.eShoppingCart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = -3086081491042317787L;
	
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "The product name must not be null")
	private String name;
	private String description;
	@Min(value=0, message= "Product price must not be less than 0")
	private double price;
	@Column(name="discounted_price")
	private double discountedPrice;
	@Transient
	private MultipartFile imag;
	private String image;
	@Transient
	private MultipartFile ima;
	private String image_2;
	@Transient
	private MultipartFile im;
	private String thumbnail;
	private int display;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage_2() {
		return image_2;
	}
	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public MultipartFile getImag() {
		return imag;
	}
	public void setImag(MultipartFile imag) {
		this.imag = imag;
	}
	public MultipartFile getIma() {
		return ima;
	}
	public void setIma(MultipartFile ima) {
		this.ima = ima;
	}
	public MultipartFile getIm() {
		return im;
	}
	public void setIm(MultipartFile im) {
		this.im = im;
	}
	
	

	
	

}
