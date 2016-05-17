package org.tutorial.drivers;

import java.util.Date;
import java.util.HashSet;

import org.tutorial.entity.Certificate;
import org.tutorial.entity.Vehicle;
import org.tutorial.managers.CertificatesManager;
import org.tutorial.managers.EmployeeManager;
import org.tutorial.managers.VehicleManager;

import utilities.SessionFactoryManager;

/**@author Arijit
 *
 *
 *This class provides the basic driver class for the application
 */
public class EmployeeDriver {

	public static void main(String[] args) {
		
		/*
		
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
		
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		Vehicle v3 = new Vehicle();
		
		v1.setVehicleName("Hyndai Elantra");
		v2.setVehicleName("Thunderbird");
		v3.setVehicleName("Tata Bolt");
		
				
		EmployeeManager empManager = new EmployeeManager();
		Integer empID1 = empManager.addEmployee("Arijit", "Das",new Date(), 10000, set1,v1);
		Integer empID2 = empManager.addEmployee("Amit", "Das",new Date(), 20000,set2,v2);
		Integer empID3 = empManager.addEmployee("Sandipa", "Dutta",new Date(), 10000,set1,v3);
		
		empManager.listEmployees();
		empManager.updateEmployee(empID2, 15000);
		empManager.listEmployees();
		//empManager.deleteEmployee(empID1);
		empManager.listEmployees();*/
		
		SessionFactoryManager.buildSessionFactory();
		
		VehicleManager vm = new VehicleManager();
		CertificatesManager cm = new CertificatesManager();
		
		Vehicle v1 = vm.addVehicle("Four Wheeler", "Ford Figo Aspire");
		Vehicle v2 = vm.addVehicle("Two Wheeler", "Royal Enfield");
		Vehicle v3 = vm.addVehicle("Four Wheeler", "Hyndai Elantra");
				
		Certificate c1 = cm.addCertificates("Diploma");
		Certificate c2 = cm.addCertificates("B.Sc");
		Certificate c3 = cm.addCertificates("B.Tech");
		
			
		HashSet<Certificate> cert1 = new HashSet<>();
		HashSet<Certificate> cert2 = new HashSet<>();
		HashSet<Certificate> cert3 = new HashSet<>();
		
		cert1.add(c1);
		cert2.add(c2);
		cert2.add(c3);
		
		cert3.add(c2);
		cert3.add(c3);
		
		EmployeeManager emp = new EmployeeManager();
		
		emp.addEmployee("Amit", "Das", new Date(), 50000, cert1, v2);
		emp.addEmployee("Arijit", "Das", new Date(), 30000, cert2, v1);
		emp.addEmployee("Mitrani", "Das", new Date(), 100000, cert3, v3);
		
		
		emp.listEmployees();
		
		/*CertificatesManager certM = new CertificatesManager();
		
		certM.viewCertificates();
		
		VehicleManager vehiM = new VehicleManager();
		
		vehiM.viewVehicles();		
		*/
		
	}

}
