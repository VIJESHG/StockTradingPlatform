package com.cs.stocktrading.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.stocktrading.daos.SectRepo;
import com.cs.stocktrading.domains.Sector;
@RestController
public class SectorController {
	
	@Autowired
	SectRepo sect;
	
	@RequestMapping("/sector")
	public List<Sector> listSectors(){
		return sect.findAll();
	}
	
	
	@RequestMapping("/sector/{sec_id}")
	public Sector requestSector(@PathVariable int sec_id) {
		return sect.findSectorById(sec_id);
	}
	
	@RequestMapping(value="/sector",method=RequestMethod.POST)
	public Sector create(@RequestBody Sector s){
		return sect.create(s);
	}
	
	@RequestMapping(value="/sector/{sec_id}",method=RequestMethod.POST)
	public List<Sector> delete(@PathVariable int sec_id){
		return sect.delete(sec_id);
	}
	
}
