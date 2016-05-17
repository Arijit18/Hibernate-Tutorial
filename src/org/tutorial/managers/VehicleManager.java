package org.tutorial.managers;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tutorial.entity.Certificate;
import org.tutorial.entity.Vehicle;

import utilities.SessionFactoryManager;

public class VehicleManager {

	public VehicleManager() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle addVehicle(String type, String name){
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType(type);
		vehicle.setVehicleName(name);
		Integer vehicleID = null;
		
		Session session = SessionFactoryManager.sessionFactory.openSession();
		
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			
			vehicleID = (Integer) session.save(vehicle);
			
			tx.commit();
			
		}catch(HibernateException hex){
			if(tx!=null){
				tx.rollback();
			}
			
			hex.printStackTrace();
		}
		
		return vehicle;
		
	}
	
	/**@author Arijit
	 * 
	 */
	public void viewVehicles(){
			
		Session session = SessionFactoryManager.sessionFactory.openSession();
		
		Transaction tx = null;
		
		try{
			tx=session.beginTransaction();
			List vehicles = session.createQuery("from Vehicle").list();
			
			Iterator<Vehicle> vehicleIT = vehicles.iterator();
			
			while(vehicleIT.hasNext()){
				Vehicle vehicle = (Vehicle) vehicleIT.next();
				
				System.out.printf("%-5d%-10s%-10s\n",vehicle.getVehicleID(),vehicle.getVehicleType(),vehicle.getVehicleName());
			}
			
			tx.commit();
			
		}catch(HibernateException hex){
			if(tx!=null){
				tx.rollback();
			}
			
			hex.printStackTrace();
		}
	}
}
