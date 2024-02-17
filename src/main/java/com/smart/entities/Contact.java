package com.smart.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CONTACT")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String Contact_Name;
	private String Second_Name;
	private String Work;
	@Column(unique=true)
	private String Email;
	
	// yaha par image ka path store hoga.
	private String Image;
	@Column(length=50000)
	private String description;
	@ManyToOne
	private User user;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getContact_Name() {
		return Contact_Name;
	}
	public void setContact_Name(String contact_Name) {
		Contact_Name = contact_Name;
	}
	public String getSecond_Name() {
		return Second_Name;
	}
	public void setSecond_Name(String second_Name) {
		Second_Name = second_Name;
	}
	public String getWork() {
		return Work;
	}
	public void setWork(String work) {
		Work = work;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", Contact_Name=" + Contact_Name + ", Second_Name=" + Second_Name + ", Work="
				+ Work + ", Email=" + Email + ", Image=" + Image + ", description=" + description + ", user=" + user
				+ "]";
	}
	
	
}
