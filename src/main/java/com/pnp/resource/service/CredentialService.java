package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.Credential;
import com.pnp.resource.model.Employee;

public interface CredentialService {
	public List<Credential> listCredential();
	public Credential login(String username, String password);
	public boolean addCredential(Credential credential);
	public boolean updateCredential(Credential credential);
	public Employee findById(String nik);
}
