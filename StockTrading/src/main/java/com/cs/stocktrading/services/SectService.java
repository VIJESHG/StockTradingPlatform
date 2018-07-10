package com.cs.stocktrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cs.stocktrading.daos.SectRepo;
import com.cs.stocktrading.domains.Sector;

public class SectService {
	@Autowired 
	SectRepo srepo;
	
	public List<Sector> findAll(){
		return srepo.findAll();
	}
	
	public Sector findSectorById(int sec_id) {
		return srepo.findSectorById(sec_id);
	}
	
}
