package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.EmployeeDao;
import com.pnp.resource.model.Employee;
import com.pnp.resource.service.EmployeeService;

@Service ("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}
	@Override
	public Employee findById(String nik) {
		// TODO Auto-generated method stub
		return employeeDao.findById(nik);
	}

}
