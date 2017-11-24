package com.pnp.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnp.resource.dao.TicketDao;
import com.pnp.resource.model.Ticket;
import com.pnp.resource.service.TicketService;

@Service("ticketService")
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDao ticketDao;
	@Override
	public List<Ticket> getAllData() {
		// TODO Auto-generated method stub
		return ticketDao.getAllData();
	}

	@Override
	public Ticket findById(int id) {
		// TODO Auto-generated method stub
		return ticketDao.findById(id);
	}

	@Override
	public List<Ticket> findByNik(String nik) {
		// TODO Auto-generated method stub
		return ticketDao.findByNik(nik);
	}

	@Override
	public List<Ticket> findByDepartmentName(String name) {
		// TODO Auto-generated method stub
		return ticketDao.findByDepartmentName(name);
	}

	@Override
	public List<Ticket> findByDepartmentAndMonth(String name, String month, String year) {
		// TODO Auto-generated method stub
		return ticketDao.findByDepartmentAndMonth(name, month, year);
	}

	@Override
	public int getTotalTicketByEmployeeAndMonth(String nik, String month, String year) {
		// TODO Auto-generated method stub
		return ticketDao.getTotalTicketByEmployeeAndMonth(nik, month, year);
	}

	@Override
	public List<Ticket> findByMonth(String month, String year) {
		// TODO Auto-generated method stub
		return ticketDao.findByMonth(month, year);
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.updateTicket(ticket);
	}

	@Override
	public boolean addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.addTicket(ticket);
	}

}
