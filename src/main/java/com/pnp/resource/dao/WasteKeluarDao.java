package com.pnp.resource.dao;

import com.pnp.resource.model.WasteKeluar;

public interface WasteKeluarDao {

	public int getLastId();
	public boolean saveWaste(WasteKeluar wasteKeluar);
}
