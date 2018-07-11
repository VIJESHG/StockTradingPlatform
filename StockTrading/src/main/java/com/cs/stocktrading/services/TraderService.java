package com.cs.stocktrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.stocktrading.daos.TraderDao;
import com.cs.stocktrading.domains.Trader;

@Service
public class TraderService {
	@Autowired
	TraderDao td;
	
	public Trader getTraderById(int trad_id)
	{
	return td.getTraderById(trad_id);

	}

	public String deleteTrader(int trad_id)
	{
	return td.deleteTrader(trad_id);
	}
	
	public List<Trader> findAll(){
		return td.findAll();
	}
	
	public Trader create(Trader t){
		return td.create(t);
	}
}
