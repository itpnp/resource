package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.TicketSubCategory;

public interface TicketSubCategoryService {
	public List<TicketSubCategory> getAllData();
	public TicketSubCategory findById(int id);
	public boolean addTicketCategory(TicketSubCategory category);
	public boolean deleteTicketCategory(TicketSubCategory category);
}
