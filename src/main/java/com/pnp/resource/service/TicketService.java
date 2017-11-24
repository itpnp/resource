package com.pnp.resource.service;

import java.util.List;

import com.pnp.resource.model.Ticket;

public interface TicketService {
	public List<Ticket> getAllData();
	public Ticket findById(int id);
	public List<Ticket> findByNik(String nik);
	public List<Ticket> findByDepartmentName(String name);
	public List<Ticket> findByDepartmentAndMonth(String name, String month, String year);
	public int getTotalTicketByEmployeeAndMonth(String nik, String month, String year);
	public List<Ticket> findByMonth(String month, String year);
	public boolean updateTicket(Ticket ticket);
	public boolean addTicket(Ticket ticket);
}
