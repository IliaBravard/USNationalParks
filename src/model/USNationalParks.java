package model; // The package where this class is located at

/**
 * @author Ilia Bravard - igbravard
 * CIS175 - Fall 2022
 * Sep 13, 2022
 */

// Using the appropriate imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is the POJO to be used as an entity for the database application.
 */

/*
 * Annotating this POJO to decocrate this source code with metadata
 * to allow the JPA persistence provider manage persistent behavior.
 * It is superior and easier to using XML.
 */

@Entity // Represents the Entity.JPA
@Table(name = "parks") // Represents the database table with a new name
public class USNationalParks {

	@Id // Represents the primary key field in the database
	@GeneratedValue // To auto-generate the key field (Strategy = IDENTITY)

	// Declaring the needed fields
	@Column(name = "ID") // The instance variables in this class become fields (columns) in the database
	private int id = 0;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATE")
	private String state;

	@Column(name = "AREA")
	private double area;

	/**
	 * This is the default, no-argument constructor.
	 */
	public USNationalParks() {
	}

	/**
	 * This is the non-default constructor that sets the instance variables of this
	 * class.
	 * 
	 * @param parkName the name of the national park
	 * @param usState  the state where the park is located at
	 * @param parkArea the area of the national park (in acres)
	 */
	public USNationalParks(String parkName, String usState, double parkArea) {
		this.name = parkName;
		this.state = usState;
		this.area = parkArea;
	}

	// Generating the accessors and mutators needed for this application

	public double getId() {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * This is a helper method that returns all details for each particular national
	 * park in the database.
	 * 
	 * @return the details for each national park (name, state, and area)
	 */
	@Override
	public String toString() {
		return "[Park Name] = " + name + "; [State] = " + state + "; [Area] = " + area;
	}
}