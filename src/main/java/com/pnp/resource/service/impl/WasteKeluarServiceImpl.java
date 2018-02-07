package com.pnp.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.WasteKeluarDao;
import com.pnp.resource.model.WasteKeluar;
import com.pnp.resource.service.WasteKeluarService;

@Service("wasteKeluarService")
public class WasteKeluarServiceImpl implements WasteKeluarService {

	@Autowired
	private WasteKeluarDao wasteKeluar;

	@Override
	public int getLastId() {
		return wasteKeluar.getLastId();
	}

	@Override
	public boolean saveWaste(WasteKeluar wasteKeluar) {
		// TODO Auto-generated method stub
		return false;
	}
}
