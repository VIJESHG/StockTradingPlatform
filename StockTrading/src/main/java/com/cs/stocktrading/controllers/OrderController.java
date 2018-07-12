package com.cs.stocktrading.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	
	@RequestMapping(value="/order/cancel/{order_id}",method=RequestMethod.PUT)
	public String cancelOrder(@PathVariable(value="order_id") int order_id)
	{
		return os.cancelOrder(order_id);
				
	}
	
	@RequestMapping(value="/order/update/{order_id}",method=RequestMethod.PUT,
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Order updateOrder(@RequestBody Order o2,@PathVariable (value="order_id") int order_id )
	{
		return os.updateOrder(order_id,o2);
	}
	
	@RequestMapping(value="/trader/{id}/order/add",method=RequestMethod.POST)
	public String createOrder(@RequestBody Order o,@PathVariable(value="id") int trad_id){
	return "Your order Id is : "+os.create(o,trad_id);
	}
	
	@RequestMapping(value="/admin/order/{trader_id}",method=RequestMethod.GET,
	produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Order> findOrderByTrader(@PathVariable(value="trader_id") int trader_id )
	{
		return os.listOrderByTrader(trader_id);
	}
}
