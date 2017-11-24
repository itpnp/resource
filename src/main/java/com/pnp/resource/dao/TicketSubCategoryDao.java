package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.TicketSubCategory;

public interface TicketSubCategoryDao {
	public List<TicketSubCategory> getAllData();
	public TicketSubCategory findById(int id);
	public boolean addTicketSubCategory(TicketSubCategory category);
	public boolean updateTicketSubCategory(TicketSubCategory category);
}
