package com.lti.Hib_ex3.Hibernate_Project3.Hibernate_Proj3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employe")
public class Employe {
	private int employeeId;
	private String name;
	private String branch;
	
	@Id
	@Column(name="employeeId")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="acseq")
	@SequenceGenerator(name="acseq",sequenceName="emp_seq")
	
	public int getEmployeeId(){
		return employeeId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="branch")
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Employe [employeeId=" + employeeId + ", name=" + name + ", branch=" + branch + "]";
	}

}
