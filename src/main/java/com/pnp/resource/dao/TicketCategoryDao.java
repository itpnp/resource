package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.TicketCategory;

public interface TicketCategoryDao {
	public List<TicketCategory> getAllData();
	public TicketCategory findById(int id);
	public boolean addTicketCategory(TicketCategory category);
	public boolean deleteTicketCategory(TicketCategory category);
	
}
