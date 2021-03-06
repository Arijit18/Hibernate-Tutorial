package org.tutorial.managers;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.tutorial.entity.Certificate;
import org.tutorial.entity.Employee;
import org.tutorial.entity.Vehicle;

import utilities.SessionFactoryManager;

public class EmployeeManager {

			
	public EmployeeManager(){
		
	}
	/**@author Arijit
	 * 
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param salary
	 */
	 
	/*
	 * Method to create an employee record in the database
	 * 
	 */
	public Integer addEmployee(String firstName, String lastName, Date doj, int salary, Set<Certificate> certificates,Vehicle vehicle){
		Session session = SessionFactoryManager.sessionFactory.openSession();
		Transaction transaction =  null;
		Integer employeeID = null;
		try{
			
			transaction = session.beginTransaction();
			Employee emp = new Employee(firstName, lastName, doj,salary);
			emp.setCertificates(certificates);
			emp.setVehicles(vehicle);
			employeeID = (Integer) session.save(emp);
			transaction.commit();
			
		}catch(HibernateException hex){
			if(transaction!=null){
				transaction.rollback();
			}
			
			hex.printStackTrace();
		}
		finally{
			session.close();
		}
		return employeeID;

	}
	
	/**@author Arijit
	 * @param none
	 */
	/*	Method to list out records of all the employees in the database
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void listEmployees(){
		Session session = SessionFactoryManager.sessionFactory.openSession();
		Transaction transaction =  null;
		
		try{
			transaction = session.beginTransaction();
			List employees = session.createQuery("from Employee").list();
			Iterator<Employee> iterator = employees.iterator();
			System.out.println("\n--------------------------------------------------------------------------------------");
			System.out.println("Employee ID\tFirst Name\tLast Name\tSalary");
			while(iterator.hasNext()){
				Employee employee = (Employee) iterator.next();
				
				System.out.printf("%-15d%-10s%-10s%-10s%-10d\n", employee.getEmployeeID(),employee.getFirstName(),employee.getLastName(),employee.getDoj(),employee.getSalary());
				/*System.out.println("Employee ID: "+employee.getEmployeeID());
				System.out.println("First Name: "+employee.getFirstName());
				System.out.println("Last Name: "+employee.getLastName());
				System.out.println("Salary: "+employee.getSalary());*/
				
				Collection<Certificate> certificates = employee.getCertificates();
				for(Iterator<Certificate> iter = certificates.iterator();
						iter.hasNext();){
					Certificate cert = (Certificate) iter.next();
					System.out.println("\n"+cert.getCertificateName());
				}
			}
			System.out.println("\n--------------------------------------------------------------------------------------");
			
			transaction.commit();
		}catch(HibernateException hex){
			if(transaction!=null)
				transaction.rollback();
			hex.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	/**@author Arijit
	 * 
	 * @param employeeID
	 * @param salary
	 */
	
	/*
	 * Method to update salary for an employee at a time
	 */
	public void updateEmployee(Integer employeeID, int salary){
		Session session = SessionFactoryManager.sessionFactory.openSession();
		Transaction transaction =  null;
		
		try{
			
			transaction = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, employeeID);
			
			employee.setSalary(salary);
			session.update(employee);
			transaction.commit();
			
		}catch(HibernateException hex){
			if(transaction!=null)
				transaction.rollback();
			hex.printStackTrace();
		}finally{
			session.close();
		}
	}
	/**@author Arijit
	 * 
	 * @param employeeID
	 */
	/*
	 * Method to delete an employee record from the database
	 */
	public void deleteEmployee(Integer employeeID){
		Session session = SessionFactoryManager.sessionFactory.openSession();
		Transaction transaction =  null;
		
		try{
			transaction = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, employeeID);
			session.delete(employee);
			transaction.commit();
		}catch(HibernateException hex){
			if(transaction!=null)
				transaction.rollback();
			hex.printStackTrace();
		}finally{
			session.close();
		}
	}
		
}
