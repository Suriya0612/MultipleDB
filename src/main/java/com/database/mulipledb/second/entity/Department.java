package com.database.mulipledb.second.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="Department_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "sequenceid", 
    allocationSize = 1, name = "sequencceid")
	private Long id;
	@Column(name="dept")
	private String dept;
	@Column(name="stafname")
	private String stafname;
	
	public Department(){
		
	}
	public Department(Long id, String dept, String stafname) {
		super();
		this.id = id;
		this.dept = dept;
		this.stafname = stafname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getStafname() {
		return stafname;
	}
	public void setStafname(String stafname) {
		this.stafname = stafname;
	}

	
	
}
