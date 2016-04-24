package org.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
		
	/*@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int certificateID;*/
	
	@Column (name = "Certificate_Name")
	private String certificateName;
		
	/*public int getCertificateID() {
		return certificateID;
	}*/

	public String getCertificateName() {
		return certificateName;
	}

	/*public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}*/

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	
	/*@Override
	public boolean equals(Object obj){
		if(obj == null ) 
			return false;
		if(!this.getClass().equals(obj.getClass())) 
			return false;
		
		Certificate obj2 = (Certificate) obj;
		if((this.certificateID == obj2.getCertificateID())&&(this.certificateName.equals(obj2.getCertificateName()))){
			return true;
		}else
		{
			return false;
		}
		
	}*/
	
	/*@Override
	public int hashCode(){
		int temp = 0;
		
		temp = (certificateID + certificateName).hashCode();
		return temp;
	}*/
	
	
}
