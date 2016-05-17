package org.tutorial.managers;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorial.entity.Certificate;

import utilities.SessionFactoryManager;

public class CertificatesManager {

	public CertificatesManager() {
		
	}
	
	/**@author Arijit
	 * 
	 * @param name
	 */
	public Certificate addCertificates(String name){
		Certificate cert = new Certificate();
		cert.setCertificateName(name);
		Integer certID;
		
		Session session = SessionFactoryManager.sessionFactory.openSession();
		
		Transaction tx = null;
		
		try{
			tx=session.beginTransaction();
			
			certID = (Integer) session.save(cert);
			
			tx.commit();
			
		}catch(HibernateException hex){
			if(tx!=null){
				tx.rollback();
			}
			
			hex.printStackTrace();
		}
		
		return cert;
	}
	
	/**@author Arijit
	 * 
	 */
	public void viewCertificates(){
			
		Session session = SessionFactoryManager.sessionFactory.openSession();
		
		Transaction tx = null;
		
		try{
			tx=session.beginTransaction();
			List certificates = session.createQuery("from Certificate").list();
			
			Iterator<Certificate> certIt = certificates.iterator();
			
			while(certIt.hasNext()){
				Certificate cert = (Certificate) certIt.next();
				
				System.out.printf("%-5d%-10s%\n", cert.getCertificateID(),cert.getCertificateName());
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
