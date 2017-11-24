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
		return ticketSubCategoryService.addTicketSubCategory(data);
	}
	
	@RequestMapping(value="/reward/updatecategory", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean updateCategory(@RequestBody TicketCategory data){
		return ticketCategoryService.updateTicketCategory(data);
	}
	
	@RequestMapping(value="/reward/deletecategory", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean deleteCategory(@RequestBody TicketCategory data){
		TicketCategory cat = ticketCategoryService.findById(data.getCategoryId());
		cat.setStatus("Non Aktif");
		return ticketCategoryService.updateTicketCategory(cat);
	}
	
	@RequestMapping(value="/reward/updatesubcategory", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean updateSubCategory(@RequestBody TicketSubCategory data){
		TicketCategory cat = ticketCategoryService.findById(data.getTicketCategory().getCategoryId());
		data.setTicketCategory(cat);
		return ticketSubCategoryService.updateTicketSubCategory(data);
	}
	
	@RequestMapping(value="/reward/deletesubcategory", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean deleteSubCategory(@RequestBody TicketSubCategory data){
		TicketSubCategory cat = ticketSubCategoryService.findById(data.getSubCategoryId());
		cat.setStatus("Non Aktif");
		return ticketSubCategoryService.updateTicketSubCategory(cat);
	}
	
	
}
