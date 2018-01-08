package com.example.sssp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="SSSP_DEPTS")
@Entity
public class Department {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	private String deparmentName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeparmentName() {
		return deparmentName;
	}

	public void setDeparmentName(String deparmentName) {
		this.deparmentName = deparmentName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deparmentName=" + deparmentName + "]";
	}

}
