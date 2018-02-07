package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.KartuKerja;

public interface KartuKerjaDao {
	public List<KartuKerja> getAllData();
	public List<KartuKerja> findByDesain(String desain);
	public boolean save(KartuKerja kartuKerja);
}
