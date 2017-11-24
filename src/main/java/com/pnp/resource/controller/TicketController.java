package com.pnp.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.resource.service.TicketService;
import com.pnp.resource.dto.Parameter;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	@RequestMapping(value="/reward/employee/find", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody int findById(@RequestBody Parameter param){
		int total = ticketService.getTotalTicketByEmployeeAndMonth(param.getNik(), param.getMonth(), param.getYear());
		return total;
	}
}
