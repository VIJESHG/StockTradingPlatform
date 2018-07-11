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
	
	public Sector create(final Sector sect) {
		return srepo.create(sect);
	}
	
	public List<Sector> update(final int sec_id, final Sector s){
		return srepo.update(sec_id, s);
	}
	
	public List<Sector> delete(final int sec_id){
		return srepo.delete(sec_id);
	}

	
}
