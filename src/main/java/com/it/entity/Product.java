package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "product")
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Positive(message = "You Have Entered Invalid Id") //id should not be zero or negative
	private int id;
	
	
	@Column(name = "name")
	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 100, message = "Name should be between 3 to 100 characters") //Name should be between min 3 and max 15 characters
	private String name;

//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
	@ManyToOne(fetch = FetchType.EAGER )
	@JsonIgnoreProperties(value = {"product", "handler","hibernateLazyInitializer"}, allowSetters = true)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "price")
	@Positive(message = "Invalid Price")	//id should not be zero or negative
	@Min(value = 1, message = "Price should not be less than 0")		//min salary should be 5000
	private double price;

	@Column(name = "quantity")
	@Positive(message = "You Have Entered Invalid quantity") //id should not be zero or negative
	private int quantity;
	
	@Column(name = "description")
	@NotNull(message = "description cannot be null")
	@Size(min = 0, max = 500, message = "description should be between 0 to 500 characters") //Name should be between min 3 and max 15 characters
	private String description;

	
	public Product() {}

	public Product(int id, String name, double price, int quantity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}