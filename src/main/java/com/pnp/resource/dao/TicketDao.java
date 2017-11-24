package com.pnp.resource.dao;

import java.util.List;

import com.pnp.resource.model.Ticket;

public interface TicketDao {
	public List<Ticket> getAllData();
	public Ticket findById(int id);
	public List<Ticket> findByNik(String nik);
	public List<Ticket> findByDepartmentName(String name);
	public List<Ticket> findByDepartmentAndMonth(String name, String month, String year);
	public int getTotalTicketByEmployeeAndMonth(String nik, String month);
	public List<Ticket> findByMonth(String month, String year);
	public boolean updateTicket(Ticket ticket);
	public boolean addTicket(Ticket ticket);
	
}
