package com.pnp.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnp.resource.model.KartuKerja;
import com.pnp.resource.service.KartuKerjaService;


@RestController
public class KartuKerjaController {
	@Autowired
    KartuKerjaService kartuKerjaService;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value="/kartukerja", method = RequestMethod.GET, headers="Accept=application/json")
	public List getAllData(){
		List<KartuKerja> listKartuKerja= new ArrayList();
		listKartuKerja = kartuKerjaService.getAllData();
		return listKartuKerja;
	}
	
	@RequestMapping(value="/reward/employee/findByDesain", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody List<KartuKerja> findByDesain(@RequestBody KartuKerja nomor){
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<KartuKerja> listKartuKerja= new ArrayList();
		listKartuKerja = kartuKerjaService.findByDesain(String.valueOf(nomor.getDesain()));
		return listKartuKerja;
	}
}
