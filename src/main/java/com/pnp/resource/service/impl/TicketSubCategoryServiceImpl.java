package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.TicketSubCategoryDao;
import com.pnp.resource.model.TicketSubCategory;
import com.pnp.resource.service.TicketSubCategoryService;

@Service("ticketSubCategoryService")
public class TicketSubCategoryServiceImpl implements TicketSubCategoryService{

	@Autowired
	private TicketSubCategoryDao ticketSubCategoryDao;
	
	@Override
	public List<TicketSubCategory> getAllData() {
		// TODO Auto-generated method stub
		return ticketSubCategoryDao.getAllData();
	}

	@Override
	public TicketSubCategory findById(int id) {
		// TODO Auto-generated method stub
		return ticketSubCategoryDao.findById(id);
	}

	@Override
	public boolean addTicketSubCategory(TicketSubCategory category) {
		// TODO Auto-generated method stub
		return ticketSubCategoryDao.addTicketSubCategory(category);
	}

	@Override
	public boolean updateTicketSubCategory(TicketSubCategory category) {
		// TODO Auto-generated method stub
		return ticketSubCategoryDao.updateTicketSubCategory(category);
	}

}
