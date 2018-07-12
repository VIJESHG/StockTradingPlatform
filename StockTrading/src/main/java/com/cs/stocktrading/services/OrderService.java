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
	public List<Order> getOrderByStatus(String status){
		return od.getOrderByStatus(status);
		
	}
	public List<Order> getOrderByTicker(String ticker){
		return od.getOrderByTicker(ticker);		
	}
	public List<Order> getOrderByQuantity(int from,int to){
		return od.getOrderByQuantity(from,to);		
	}
	public List<Order> getOrderByTime(int from,int to){
		return od.getOrderByTime(from,to);		
	}
	public List<Order> sortByTicker(String sort){
		return od.sortByTicker(sort);
	}
	public List<Order> sortByPrice(String sort){
		return od.sortByPrice(sort);
	}
	public List<Order> listOrderByOrderSide()
	{
	return od.listOrderByOrderSide();
	}

	public List<Order> listOrderByOrderSideBuySell(String request1)
	{
	return od.listOrderByOrderSideBuySell(request1);
	}

	public List<Order> listOrderByOrderType()
	{
	return od.listOrderByOrderType();
	}

	public List<Order> listOrderByOrderTypeMarketLimit(String order_type)
	{
	return od.listOrderByOrderTypeMarketLimit(order_type);
	}

	public List<Order> listOrderByStatus()
	{
	return od.listOrderByStatus();
	}
}
