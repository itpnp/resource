package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployee();
	public Employee findById(String nik);
}
