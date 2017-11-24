package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.Nominal;
import com.pnp.resource.model.Occupation;

public interface NominalService {
	public List<Nominal> getAllData();
	public Nominal findByOccupation(int occupationId);
	public boolean addNominal(Nominal nominal);
	public boolean updateNominal(Nominal nominal);
	public Occupation findById(int id);
}
