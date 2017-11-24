package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.Nominal;

public interface NominalDao {
	public List<Nominal> getAllData();
	public Nominal findByOccupation(int occupationId);
	public boolean addNominal(Nominal nominal);
	public boolean updateNominal(Nominal nominal);
	
}
