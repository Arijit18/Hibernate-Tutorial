package org.tutorial.drivers;

import java.util.Date;

import org.tutorial.managers.EmployeeManager;

/**@author Arijit
 *
 *
 *This class provides the basic driver class for the application
 */
public class EmployeeDriver {

	public static void main(String[] args) {
		
		EmployeeManager empManager = new EmployeeManager();
		
		empManager.addEmployee(101, "Arijit", "Das",new Date(), 10000);
		empManager.addEmployee(102, "Amit", "Das",new Date(), 20000);
		empManager.addEmployee(103, "Sandipa", "Dutta",new Date(), 10000);
		
		empManager.listEmployees();
		empManager.updateEmployee(101, 15000);
		empManager.listEmployees();
		empManager.deleteEmployee(101);
		empManager.listEmployees();
		
	}

}
