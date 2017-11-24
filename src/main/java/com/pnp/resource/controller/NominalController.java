package com.pnp.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.pnp.resource.model.Nominal;
import com.pnp.resource.model.Occupation;
import com.pnp.resource.service.NominalService;

@RestController
public class NominalController {
	
	@Autowired
	private NominalService nominalService;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value="/reward/nominal", method = RequestMethod.GET, headers="Accept=application/json")
	public List getAllNominal(){
		List<Nominal> listNominal= new ArrayList();
		listNominal= nominalService.getAllData();
		return listNominal;
	}
	
	@RequestMapping(value="/reward/nominal/findbyoccupation", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Nominal findNominalByOccupationId(@RequestBody Occupation op){
		Nominal nominal = nominalService.findByOccupation(op.getOccupationId());
		return nominal;
	}
	
	@RequestMapping(value="/reward/nominal/updateNominal", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody boolean updateCredential(@RequestBody Nominal data){
		Occupation ocp = nominalService.findById(data.getOccupation().getOccupationId());
		data.setOccupation(ocp);
		return nominalService.updateNominal(data);
	}

}
