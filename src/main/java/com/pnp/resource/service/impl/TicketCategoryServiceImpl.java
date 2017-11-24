package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.TicketCategoryDao;
import com.pnp.resource.model.TicketCategory;
import com.pnp.resource.service.TicketCategoryService;

@Service("ticketCategoryService")
public class TicketCategoryServiceImpl implements TicketCategoryService {

	@Autowired
	private TicketCategoryDao ticketCategoryDao;
	
	@Override
	public List<TicketCategory> getAllData() {
		// TODO Auto-generated method stub
		return ticketCategoryDao.getAllData();
	}

	@Override
	public TicketCategory findById(int id) {
		// TODO Auto-generated method stub
		return ticketCategoryDao.findById(id);
	}

	@Override
	public boolean addTicketCategory(TicketCategory category) {
		// TODO Auto-generated method stub
		return ticketCategoryDao.addTicketCategory(category);
	}

	@Override
	public boolean updateTicketCategory(TicketCategory category) {
		// TODO Auto-generated method stub
		return ticketCategoryDao.updateTicketCategory(category);
	}
	
}
