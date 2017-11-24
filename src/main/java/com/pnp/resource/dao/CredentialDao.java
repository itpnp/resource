package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.Credential;
import com.pnp.resource.model.Employee;

public interface CredentialDao {
	
	/*
	 * @Return List Credential
	 */
	public List<Credential> listUserApp();
	
	/*
	 * @Param String username, String password
	 */
	public Credential login(String username, String password);
	
	/*
	 * 
	 */
	public boolean addCredential(Credential credential);
	public boolean updateCredential(Credential credential);
	public Employee findByEmployeeId(String nik);
	public Credential findById(int id);
}
