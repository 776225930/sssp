package com.example.sssp.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.sssp.entities.Department;
import com.example.sssp.repository.DepartmentRepository;

public class SSSPTest {
	private ApplicationContext ctx = null;
	private DepartmentRepository departmentRepository = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    departmentRepository=ctx.getBean(DepartmentRepository.class);
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void testRepositorySecondlevelCache() {
		List<Department> depts = departmentRepository.getAll();
		depts = departmentRepository.getAll();
	}
}
