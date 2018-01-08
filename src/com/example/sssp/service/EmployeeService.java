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
		
		System.out.println("�ܼ�¼��:  "+page.getTotalElements());
		System.out.println("��ǰ�ڼ�ҳ:  "+(page.getNumber()+1));
		System.out.println("��ҳ��:  "+page.getTotalPages());
		System.out.println("��ǰҳ���List:  "+page.getContent());
		System.out.println("��ǰҳ���¼��: "+page.getNumberOfElements());
		return page;
	}
	@Transactional(readOnly=true)
	public Employee getByLastName(String lastName){
		
		return employeeRepository.getByLastName(lastName);
	}
	public void save(Employee employee){
		//���ô���ʱ��
		employee.setCreateTime(new Date());
		employeeRepository.saveAndFlush(employee);
	}
	@Transactional(readOnly=true)
	public Employee get(Integer id){
		return  employeeRepository.findOne(id);
	}
}
