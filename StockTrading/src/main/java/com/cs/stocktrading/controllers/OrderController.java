package com.cs.stocktrading.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs.stocktrading.domains.Order;
import com.cs.stocktrading.services.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService os;
	@RequestMapping(value="/trader/{id}/order/add",method=RequestMethod.POST)
	public String createOrder(@RequestBody Order o,@PathVariable(value="id") int trad_id){
		return "Your order Id is : "+os.create(o,trad_id);
	}
}
