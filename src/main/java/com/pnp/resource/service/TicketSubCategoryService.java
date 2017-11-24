package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.TicketSubCategory;

public interface TicketSubCategoryService {
	public List<TicketSubCategory> getAllData();
	public TicketSubCategory findById(int id);
	public boolean addTicketSubCategory(TicketSubCategory category);
	public boolean updateTicketSubCategory(TicketSubCategory category);
}
