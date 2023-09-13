package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Positive(message = "You Have Entered Invalid Id") //id should not be zero or negative
	private int id;
	
	
	@Column(name = "name")
	@NotNull(message = "Name cannot be null")
	@Size(min = 0, max = 100, message = "Name should be between 0 to 100 characters") //Name should be between min 3 and max 15 characters
	private String name;
	
		
	@Column(name = "description")
	@NotNull(message = "description cannot be null")
	@Size(min = 0, max = 500, message = "description should be between 0 to 500 characters") //Name should be between min 3 and max 15 characters
	private String description;

	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}