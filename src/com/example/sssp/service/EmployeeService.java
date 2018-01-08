package com.example.sssp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sssp.entities.Employee;
import com.example.sssp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Page<Employee> getPage(int pageNo, int pageSize) {

		Order order1 = new Order(Direction.ASC, "id");
		Sort sort = new Sort(order1);
		PageRequest pagable = new PageRequest(pageNo-1, pageSize, sort);
		Page<Employee> page = employeeRepository.findAll(pagable);
		
		System.out.println("总记录数:  "+page.getTotalElements());
		System.out.println("当前第几页:  "+(page.getNumber()+1));
		System.out.println("总页数:  "+page.getTotalPages());
		System.out.println("当前页面的List:  "+page.getContent());
		System.out.println("当前页面记录数: "+page.getNumberOfElements());
		return page;
	}
	@Transactional(readOnly=true)
	public Employee getByLastName(String lastName){
		
		return employeeRepository.getByLastName(lastName);
	}
	public void save(Employee employee){
		//设置创建时间
		employee.setCreateTime(new Date());
		employeeRepository.saveAndFlush(employee);
	}
	@Transactional(readOnly=true)
	public Employee get(Integer id){
		return  employeeRepository.findOne(id);
	}
}
