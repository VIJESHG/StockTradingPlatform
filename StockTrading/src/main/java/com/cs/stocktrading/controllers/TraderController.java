package com.cs.stocktrading.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.stocktrading.domains.Trader;
import com.cs.stocktrading.services.TraderService;

@RestController
public class TraderController {

	@Autowired
	TraderService ts;
	
	@RequestMapping(value="/trader/{trad_id}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public Trader getTraderById(@PathVariable(value="trad_id") int trad_id)
	{
	return ts.getTraderById(trad_id);
	}

	@RequestMapping(value="/trader/{trad_id}",method=RequestMethod.PUT)
	public String deleteTrader(@PathVariable(value="trad_id")int trad_id)
	{
	return ts.deleteTrader(trad_id);
	}
	
	@RequestMapping(value="/trader")
	public List<Trader> findAll(){
		return ts.findAll();
	}
	
	@RequestMapping(value="/trader/add",method=RequestMethod.POST)
	public Trader createTrader(@RequestBody Trader t){
		return ts.create(t);
	}
}
