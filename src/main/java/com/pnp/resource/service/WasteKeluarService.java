package com.pnp.resource.service;

import com.pnp.resource.model.WasteKeluar;

public interface WasteKeluarService {

	public int getLastId();
	public boolean saveWaste(WasteKeluar wasteKeluar);
}
