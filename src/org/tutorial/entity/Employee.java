package org.tutorial.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


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
	/*@Column (name = "Certificates")
	@ElementCollection
	@JoinTable(name = "Employee_Qualifications",
				joinColumns=@JoinColumn(name="employeeID"))
	@GenericGenerator(name="hilo-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "CertificateID") }, generator = "hilo-gen", type = @Type(type = "long"))*/ 
	@OneToMany
	@JoinTable(name = "Employee_Certificates", joinColumns=@JoinColumn(name = "EmployeeID"),
						inverseJoinColumns=@JoinColumn(name = "CertificateID"))
	private Collection<Certificate> certificates = new ArrayList<Certificate>();
	
	@OneToOne
	/*@Column (name = "Vehicle")*/
	private Vehicle vehicles;
	@Column (name = "Salary")
	private int salary;
	
	
	public Employee(){
		
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

	public Collection<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(Collection<Certificate> certificates) {
		this.certificates = certificates;
	}
	public Vehicle getVehicles() {
		return vehicles;
	}
	public void setVehicles(Vehicle vehicles) {
		this.vehicles = vehicles;
	}

	
	
}
