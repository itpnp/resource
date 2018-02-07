package com.pnp.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.resource.service.EmployeeService;
import com.pnp.resource.service.TicketService;
import com.pnp.resource.service.TicketSubCategoryService;
import com.pnp.resource.dto.Parameter;
import com.pnp.resource.model.Department;
import com.pnp.resource.model.Employee;
import com.pnp.resource.model.Ticket;
import com.pnp.resource.model.TicketSubCategory;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TicketSubCategoryService categoryService;
	
	@RequestMapping(value="/ticket/findbydateandemployee", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Long findByDateAndEmployee(@RequestBody Parameter param){
		Long total = ticketService.getTotalTicketByEmployeeAndMonth(param.getGeneral(), param.getMonth(), param.getYear());
		return total;
	}
	
	@RequestMapping(value="/ticket/save", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean saveTicket(@RequestBody Ticket ticket){
		Employee pelaku = employeeService.findById(ticket.getSubject().getNik());
		Employee penilang = employeeService.findById(ticket.getOfficer().getNik());
		TicketSubCategory subCategory = categoryService.findById(ticket.getSubCategoryTicket().getSubCategoryId());
		ticket.setOfficer(penilang);
		ticket.setSubject(pelaku);
		ticket.setSubCategoryTicket(subCategory);
		return ticketService.addTicket(ticket);
	}
	
	@RequestMapping(value="/ticket/getalldata", method = RequestMethod.GET, headers="Accept=application/json")
	public List<Ticket> getAllTicket(){
		List<Ticket> listTicket = new ArrayList<>();
		listTicket = ticketService.getAllData();
		return listTicket;
	}
	
	@RequestMapping(value="/ticket/findbydepartmentname", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody List<Ticket> findDepartmentName(@RequestBody Department dept){
		List<Ticket> listTicket = ticketService.findByDepartmentName(dept.getDepartmentName());
		return listTicket;
	}
	
	@RequestMapping(value="/ticket/findbydepartmentandmonth", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody List<Ticket> findDepartmentAndMonth(@RequestBody Parameter param){
		List<Ticket> listTicket = ticketService.findByDepartmentAndMonth(param.getGeneral(), param.getMonth(), param.getYear());
		return listTicket;
	}
	
	@RequestMapping(value="/ticket/findbymonth", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody List<Ticket> findByMonth(@RequestBody Parameter param){
		List<Ticket> listTicket = ticketService.findByMonth(param.getMonth(), param.getYear());
		return listTicket;
	}
	
	@RequestMapping(value="/ticket/findbyid", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Ticket findById(@RequestBody Parameter param){
		Ticket ticket = ticketService.findById(Integer.parseInt(param.getGeneral()));
		return ticket;
	}
	
	@RequestMapping(value="/ticket/updateticket", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Boolean updateTicket(@RequestBody Ticket ticket){
		Employee pelaku = employeeService.findById(ticket.getSubject().getNik());
		Employee penilang = employeeService.findById(ticket.getOfficer().getNik());
		TicketSubCategory subCategory = categoryService.findById(ticket.getSubCategoryTicket().getSubCategoryId());
		ticket.setOfficer(penilang);
		ticket.setSubject(pelaku);
		ticket.setSubCategoryTicket(subCategory);
		return ticketService.updateTicket(ticket);
	}

}
