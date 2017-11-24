package com.pnp.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.resource.model.Employee;
import com.pnp.resource.service.EmployeeService;

@RestController
public class EmployeeController{
	
	@Autowired
    EmployeeService employeeService;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value="/employees", method = RequestMethod.GET, headers="Accept=application/json")
	public List getAllEmployees(){
		List<Employee> listEmployees = new ArrayList();
		listEmployees = employeeService.getAllEmployee();
		return listEmployees;
	}
	
	@RequestMapping(value="/reward/employee/find", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Employee findById(@RequestBody Employee nik){
		Employee emp = employeeService.findById(nik.getNik());
		return emp;
	}
}
