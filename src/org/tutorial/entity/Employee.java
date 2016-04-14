package org.tutorial.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "Employee_Details")
public class Employee {
	
	@Id
	private int employeeID;
	@Column (name = "FirstName")
	private String firstName;
	@Column (name = "Last_Name")
	private String lastName;
	@Column (name = "Date_Of_Joining")
	@Temporal (TemporalType.DATE)
	private Date doj;
	
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Column (name = "Salary")
	private int salary;
	
	public Employee() {
		
	}

	public Employee(int employeeID, String firstName, String lastName, Date doj, int salary) {
		
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doj=doj;
		this.salary = salary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
