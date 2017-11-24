package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.CredentialDao;
import com.pnp.resource.model.Credential;
import com.pnp.resource.model.Employee;
import com.pnp.resource.service.CredentialService;

@Service("credentialService")
public class CredentialServiceImpl implements CredentialService{
	
	@Autowired
	private CredentialDao credentialDao;

	@Override
	public List<Credential> listCredential() {
		// TODO Auto-generated method stub
		return credentialDao.listUserApp();
	}

	@Override
	public Credential login(String username, String password) {
		// TODO Auto-generated method stub
		return credentialDao.login(username, password);
	}

	@Override
	public boolean addCredential(Credential credential) {
		// TODO Auto-generated method stub
		return credentialDao.addCredential(credential);
	}

	@Override
	public Employee findById(String nik) {
		// TODO Auto-generated method stub
		return credentialDao.findById(nik);
	}

	@Override
	public boolean updateCredential(Credential credential) {
		// TODO Auto-generated method stub
		return credentialDao.updateCredential(credential);
	}


}
