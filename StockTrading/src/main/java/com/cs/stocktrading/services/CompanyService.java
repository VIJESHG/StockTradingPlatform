package com.cs.stocktrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.stocktrading.daos.CompRepo;
import com.cs.stocktrading.domains.Company;

@Service
public class CompanyService {
	@Autowired 
	CompRepo crepo;
	
	public List<Company> findAll(){
		return crepo.findAll();
	}
	
	public Company findCompanyByTicker(String ticker) {
		return crepo.findCompanyByTicker(ticker);
	}
	
	public Company create(final Company cmp) {
		return crepo.create(cmp);
	}
	
	public List<Company> delete(final String ticker){
		return crepo.delete(ticker);
	}
	
	public List<Company> update(final String ticker, final Company cmp){
		return crepo.update(ticker, cmp);
	}	
}
