package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.KartuKerjaDao;
import com.pnp.resource.model.KartuKerja;
import com.pnp.resource.service.KartuKerjaService;

@Service("kartuKerjaService")
public class KartuKerjaServiceImpl implements KartuKerjaService {
	
	@Autowired
	private KartuKerjaDao kartuKerjaDao;
	
	@Override
	public List<KartuKerja> getAllData() {
		// TODO Auto-generated method stub
		return kartuKerjaDao.getAllData();
	}

	@Override
	public List<KartuKerja> findByDesain(String desain) {
		// TODO Auto-generated method stub
		return kartuKerjaDao.findByDesain(desain);
	}

	@Override
	public boolean save(KartuKerja kartuKerja) {
		// TODO Auto-generated method stub
		return kartuKerjaDao.save(kartuKerja);
	}

}
