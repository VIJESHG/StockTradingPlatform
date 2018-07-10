package com.cs.stocktrading.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.stocktrading.daos.CompRepo;
import com.cs.stocktrading.domains.Company;

@RestController
public class CompanyController {
	@Autowired
	CompRepo cmp;
	
	@RequestMapping("/company")
	public List<Company> listCompanies(){
		return cmp.findAll();
	}
	
	
	@RequestMapping("/company/{ticker}")
	public Company requestCompany(@PathVariable String ticker) {
		return cmp.findCompanyByTicker(ticker);
	}
	
	@RequestMapping(value="/company",method=RequestMethod.POST)
	public Company create(@RequestBody Company c){
		return cmp.create(c);
	}
	
	@RequestMapping(value="/company/{ticker}",method=RequestMethod.POST)
	public List<Company> create(@PathVariable String ticker){
		return cmp.delete(ticker);
	}
	
	
	
}
