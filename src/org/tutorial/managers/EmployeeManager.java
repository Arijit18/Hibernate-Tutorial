package org.tutorial.managers;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.tutorial.entity.Employee;

public class EmployeeManager {

	public static SessionFactory sessionFactory ;
		
	public EmployeeManager(){
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.err.println("Session factory successfully created.");
		}catch (Throwable ex){
			System.err.println("Cannot create session factory. +ex");
		}
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
	public void addEmployee(int employeeId, String firstName, String lastName, int salary){
		Session session = sessionFactory.openSession();
		Transaction transaction =  null;
		
		try{
			
			transaction = session.beginTransaction();
			Employee emp = new Employee(employeeId, firstName, lastName, salary);
			session.save(emp);
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
	}
	
	/**@author Arijit
	 * @param none
	 */
	/*	Method to list out records of all the employees in the database
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void listEmployees(){
		Session session = sessionFactory.openSession();
		Transaction transaction =  null;
		
		try{
			transaction = session.beginTransaction();
			List employees = session.createQuery("from Employee").list();
			Iterator<Employee> iterator = employees.iterator();
			System.out.println("\n--------------------------------------------------------------------------------------");
			System.out.println("Employee ID\tFirst Name\tLast Name\tSalary");
			while(iterator.hasNext()){
				Employee employee = (Employee) iterator.next();
				
				System.out.printf("%-15d%-10s%-10s%-10d\n", employee.getEmployeeID(),employee.getFirstName(),employee.getLastName(),employee.getSalary());
				/*System.out.println("Employee ID: "+employee.getEmployeeID());
				System.out.println("First Name: "+employee.getFirstName());
				System.out.println("Last Name: "+employee.getLastName());
				System.out.println("Salary: "+employee.getSalary());*/
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
	public void updateEmployee(int employeeID, int salary){
		Session session = sessionFactory.openSession();
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
	public void deleteEmployee(int employeeID){
		Session session = sessionFactory.openSession();
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
