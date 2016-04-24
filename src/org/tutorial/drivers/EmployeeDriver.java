package org.tutorial.drivers;

import java.util.Date;
import java.util.HashSet;

import org.tutorial.entity.Certificate;
import org.tutorial.managers.EmployeeManager;

/**@author Arijit
 *
 *
 *This class provides the basic driver class for the application
 */
public class EmployeeDriver {

	public static void main(String[] args) {
		
		
		
		HashSet<Certificate> set1 =  new HashSet<Certificate>();
		
		Certificate cert1 = new Certificate();
		cert1.setCertificateName("BSc");
		Certificate cert2 = new Certificate();
		cert2.setCertificateName("BTech");
		Certificate cert3 = new Certificate();
		cert3.setCertificateName("Diploma");
		
		set1.add(cert1);
		set1.add(cert2);
		
		HashSet<Certificate> set2 =  new HashSet<Certificate>();
		
		set2.add(cert3);
				
		EmployeeManager empManager = new EmployeeManager();
		Integer empID1 = empManager.addEmployee("Arijit", "Das",new Date(), 10000, set1);
		Integer empID2 = empManager.addEmployee("Amit", "Das",new Date(), 20000,set2);
		Integer empID3 = empManager.addEmployee("Sandipa", "Dutta",new Date(), 10000,set1);
		
		empManager.listEmployees();
		empManager.updateEmployee(empID2, 15000);
		empManager.listEmployees();
		empManager.deleteEmployee(empID1);
		empManager.listEmployees();
		
	}

}
