package com.database.mulipledb.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="Student_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "sequenceid", 
    allocationSize = 1, name = "sequencceid")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="dept")
	private String dept;
	
	public Student() {
		
	}
	
	public Student(Long id, String name, String email, String address, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dept = dept;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
