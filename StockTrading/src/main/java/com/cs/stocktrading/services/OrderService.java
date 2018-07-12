package com.cs.stocktrading.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.stocktrading.daos.OrderDao;
import com.cs.stocktrading.domains.Order;

@Service
public class OrderService {

	@Autowired
	OrderDao od;
	
	public String cancelOrder(int order_id)
	{
		return od.cancelOrder(order_id);
	}
	
	public Order updateOrder(int order_id,Order o2)
	{
		return od.updateOrder(order_id,o2);
	}
	
	public int create(Order o,int id){
		return od.create(o,id);
		}
	
	public List<Order> listOrderByTrader(int trader_id)
	{
	return od.listOrderByTrader(trader_id);
	}
}
