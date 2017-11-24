package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public Employee findById(String nik);
}
