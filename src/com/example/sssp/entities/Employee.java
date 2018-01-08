package com.example.sssp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Table(name="SSSP_EMPS")
@Entity
public class Employee {
	private Integer id;
	private String lastName;
	private String email;
	private Date birth;
	private Date createTime;
    
	private Department department;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}
    @Temporal(TemporalType.DATE)
	public void setBirth(Date birth) {
		this.birth = birth;
	}
    
	public Date getCreateTime() {
		return createTime;
	}
    
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JoinColumn(name="DEPT_ID")
    @ManyToOne(fetch=FetchType.LAZY)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", birth=" + birth
				+ ", createTime=" + createTime + ", department=" + department + "]";
	}


}
