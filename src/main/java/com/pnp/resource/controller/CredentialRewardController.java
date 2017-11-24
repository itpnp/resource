package com.pnp.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.resource.model.Credential;
import com.pnp.resource.model.Employee;
import com.pnp.resource.service.CredentialService;

@RestController
public class CredentialRewardController {
	
	@Autowired
	CredentialService credentialService;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value="/reward/credential", method = RequestMethod.GET, headers="Accept=application/json")
	public List getAllEmployees(){
		List<Credential> listCredential= new ArrayList();
		listCredential = credentialService.listCredential();
		return listCredential;
	}
	
	@RequestMapping(value="/reward/login", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Credential login(@RequestBody Credential data){
		Credential credential = credentialService.login(data.getUsername(), data.getPassword());
		return credential;
	}
	
	@RequestMapping(value="/reward/addCredential", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean addCredential(@RequestBody Credential data){
		Employee emp = credentialService.findById(data.getEmployee().getNik());
		data.setEmployee(emp);
		return credentialService.addCredential(data);
	}
	
	@RequestMapping(value="/reward/updateCredential", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean updateCredential(@RequestBody Credential data){
		Employee emp = credentialService.findById(data.getEmployee().getNik());
		data.setEmployee(emp);
		return credentialService.updateCredential(data);
	}
}
