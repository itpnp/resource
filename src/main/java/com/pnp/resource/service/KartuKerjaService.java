package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.KartuKerja;

public interface KartuKerjaService {

	public List<KartuKerja> getAllData();
	public List<KartuKerja> findByDesain(String desain);
	public boolean save(KartuKerja kartuKerja);
}
