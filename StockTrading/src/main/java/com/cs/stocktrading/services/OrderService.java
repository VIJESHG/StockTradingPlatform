package com.cs.stocktrading.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.stocktrading.daos.OrderDao;
import com.cs.stocktrading.domains.Order;

@Service
public class OrderService {
	@Autowired
	OrderDao od;
	
	public int create(Order o,int id){
		return od.create(o,id);
	}
}
