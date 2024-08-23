package com.becoder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "notes_details")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	@Column(length = 2000)
private String title;
	@Column(length = 10000)
private String description;
private String date;
	@ManyToOne
private User user;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "Notes [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + ", user="
				+ user + "]";
	}

	
	

}
