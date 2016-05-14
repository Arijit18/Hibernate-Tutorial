package org.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Certificates")
public class Certificate {
		
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "Certificate_Id")
	private int certificateID;
	
	@Column (name = "Certificate_Name")
	private String certificateName;

	public int getCertificateID() {
		return certificateID;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}	
		
}
