package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.TicketCategory;

public interface TicketCategoryService {
	public List<TicketCategory> getAllData();
	public TicketCategory findById(int id);
	public boolean addTicketCategory(TicketCategory category);
	public boolean deleteTicketCategory(TicketCategory category);
}
