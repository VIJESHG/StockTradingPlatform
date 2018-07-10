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
	
}
