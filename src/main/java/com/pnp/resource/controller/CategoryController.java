package com.pnp.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.resource.model.TicketCategory;
import com.pnp.resource.model.TicketSubCategory;
import com.pnp.resource.service.TicketCategoryService;
import com.pnp.resource.service.TicketSubCategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private TicketCategoryService ticketCategoryService;
	
	@Autowired
	private TicketSubCategoryService ticketSubCategoryService;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value="/reward/category", method = RequestMethod.GET, headers="Accept=application/json")
	public List getAllCategory(){
		List<TicketCategory> listCategory = new ArrayList();
		listCategory = ticketCategoryService.getAllData();
		return listCategory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value="/reward/subcategory", method = RequestMethod.GET, headers="Accept=application/json")
	public List getAllSubCategory(){
		List<TicketSubCategory> listSubCategory = new ArrayList();
		listSubCategory = ticketSubCategoryService.getAllData();
		return listSubCategory;
	}
	
	@RequestMapping(value="/reward/addcategory", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean addCategory(@RequestBody TicketCategory data){
		return ticketCategoryService.addTicketCategory(data);
	}
	
	@RequestMapping(value="/reward/addsubcategory", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean addSubCategory(@RequestBody TicketSubCategory data){
		TicketCategory cat = ticketCategoryService.findById(data.getTicketCategory().getCategoryId());
		data.setTicketCategory(cat);
		return ticketSubCategoryService.addTicketCategory(data);
	}
}
