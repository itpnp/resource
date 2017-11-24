package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.NominalDao;
import com.pnp.resource.dao.OccupationDao;
import com.pnp.resource.model.Nominal;
import com.pnp.resource.model.Occupation;
import com.pnp.resource.service.NominalService;

@Service("nominalService")
public class NominalServiceImpl implements NominalService{

	@Autowired
	private NominalDao nominalDao;
	
	@Autowired
	private OccupationDao occupationDao;
	
	@Override
	public List<Nominal> getAllData() {
		// TODO Auto-generated method stub
		return nominalDao.getAllData();
	}

	@Override
	public Nominal findByOccupation(int occupationId) {
		// TODO Auto-generated method stub
		return nominalDao.findByOccupation(occupationId);
	}

	@Override
	public boolean addNominal(Nominal nominal) {
		// TODO Auto-generated method stub
		return nominalDao.addNominal(nominal);
	}

	@Override
	public boolean updateNominal(Nominal nominal) {
		// TODO Auto-generated method stub
		return nominalDao.updateNominal(nominal);
	}

	@Override
	public Occupation findById(int id) {
		// TODO Auto-generated method stub
		return occupationDao.findById(id);
	}

}
