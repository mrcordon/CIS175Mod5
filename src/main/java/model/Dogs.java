// TODO add comment header

package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dogs")
public class Dogs {	
	// attributes
	@Id
	@GeneratedValue
	@Column(name="ID")  // primary key
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="BREED")
	private String breed;
	@Column(name="COLOR")
	private String color;
	
	// default constructor, no args
	public Dogs() {
		
	}

	// constructor for creating db rows
	public Dogs(String name, String breed, String color) {
		
		this.name = name;
		this.breed = breed;
		this.color = color;
	}

	
	// getters and setters
	// getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public String getColor() {
		return color;
	}

	
	// setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setColor(String color) {
		this.color = color;
	}


	// helper method
	
	public String returnDogDetails() {
		return name + ": " + this.color + " " + this.breed;
	}	
	
}

