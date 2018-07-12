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
	
	//Cancel order
	@RequestMapping(value="/order/cancel/{order_id}",method=RequestMethod.PUT)
	public String cancelOrder(@PathVariable(value="order_id") int order_id)
	{
		return os.cancelOrder(order_id);
				
	}
	
	//Update order
	@RequestMapping(value="/order/update/{order_id}",method=RequestMethod.PUT,
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Order updateOrder(@RequestBody Order o2,@PathVariable (value="order_id") int order_id )
	{
		return os.updateOrder(order_id,o2);
	}
	
	//Place order
	@RequestMapping(value="order/add/{id}",method=RequestMethod.POST)
	public String createOrder(@RequestBody Order o,@PathVariable(value="id") int trad_id){
	return "Your order Id is : "+os.create(o,trad_id);
	}
	
	@RequestMapping(value="/admin/order/{trader_id}",method=RequestMethod.GET,
	produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Order> findOrderByTrader(@PathVariable(value="trader_id") int trader_id )
	{
		return os.listOrderByTrader(trader_id);
	}
	
	//Get order with status
	@RequestMapping(value="/order/list/status/{status}")
	public List<Order> getOrderByStatus(@PathVariable(value="status")String status){
		status=status.toUpperCase();
		return os.getOrderByStatus(status);
		
	}
	
	//Get order with Ticker name
	@RequestMapping(value="/order/list/ticker/{ticker}")
	public List<Order> getOrderByTicker(@PathVariable(value="ticker")String ticker){
		ticker=ticker.toUpperCase();
		return os.getOrderByTicker(ticker);		
	}
	
	//Get orders within quantities
	@RequestMapping(value="/order/list/quantity/from={from}/to={to}")
	public List<Order> getOrderByQuantity(@PathVariable(value="from")int from,@PathVariable(value="to")int to){
		return os.getOrderByQuantity(from,to);		
	}
	
	//Get orders within TimeStamp
	@RequestMapping(value="/order/list/time/from={from}/to={to}")
	public List<Order> getOrderByTime(@PathVariable(value="from")int from,@PathVariable(value="to")int to){
		return os.getOrderByTime(from,to);		
	}
	
	//get sorted list with ticker name
	@RequestMapping(value="/order/list/sort/ticker/{sort}")
	public List<Order> sortByTicker(@PathVariable(value="sort")String sort){
		//sort=sort.toUpperCase();
		return os.sortByTicker(sort);
	}
	
	//Get sorted list with price
	@RequestMapping(value="/order/list/sort/price/{sort}")
	public List<Order> sortByPrice(@PathVariable(value="sort")String sort){
		//sort=sort.toUpperCase();
		return os.sortByPrice(sort);
	}
			
			//Group order by Buy or sell
			@RequestMapping(value="/order/list/orderside",method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
			public List<Order> listOrderByOrderSide()
			{
			return os.listOrderByOrderSide();
			}

			//List orders by Buy or sell
			@RequestMapping(value="/order/list/orderside/{request}",method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
			public List<Order> listOrderByOrderSide(@PathVariable(value="request") String request1)
			{
			return os.listOrderByOrderSideBuySell(request1.toUpperCase());
			}


			//Group orders by type
			@RequestMapping(value="/order/list/ordertype",method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
			public List<Order> listOrderByOrderType()
			{
			return os.listOrderByOrderType();
			}

			//list order by Market or Limit
			@RequestMapping(value="/order/list/ordertype/{order_type}",method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
			public List<Order> listOrderByOrderTypeMarketLimit(@PathVariable(value="order_type") String order_type)
			{
			return os.listOrderByOrderTypeMarketLimit(order_type.toUpperCase());
			}

			//Group order by status
			@RequestMapping(value="/order/list/status",method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
			public List<Order> listOrderByStatus()
			{
			return os.listOrderByStatus();
			}
}
