package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.TicketSubCategory;

public interface TicketSubCategoryDao {
	public List<TicketSubCategory> getAllData();
	public TicketSubCategory findById(int id);
	public boolean addTicketCategory(TicketSubCategory category);
	public boolean deleteTicketCategory(TicketSubCategory category);
}
