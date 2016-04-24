package org.tutorial.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name = "Employee_Details")
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeID;
	@Column (name = "FirstName")
	private String firstName;
	@Column (name = "Last_Name")
	private String lastName;
	@Column (name = "Date_Of_Joining")
	@Temporal (TemporalType.DATE)
	private Date doj;
	@Column (name = "Certificates")
	@ElementCollection
	private Set<Certificate> certificates = new HashSet<Certificate>();
	@Column (name = "Salary")
	private int salary;
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, Date doj, int salary) {
		
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
	
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}
	
}
