package com.cs.stocktrading.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.cs.stocktrading.domains.Order;
import com.cs.stocktrading.enums.OrderType;
import com.cs.stocktrading.enums.Status;

@Repository
public class OrderDao {


	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	@Transactional(readOnly=true)
	public String cancelOrder(int order_id)
	{
		Order o= jdbctemplate.queryForObject("select * from Orders where order_id=?",new Object[] {order_id}
		,new OrderMapper());
		if(o.getStatus().equals("COMPLETED") || o.getStatus().equals("CANCELLED"))
		{
			return "Order cannot be cancelled.";
		}
		else
		{
			String sql = "UPDATE Orders SET status=?,time_stamp=? WHERE order_id=?";
			jdbctemplate.update(sql,"CANCELLED",new Timestamp(System.currentTimeMillis()),o.getOrder_id());
			   
			Order o1= jdbctemplate.queryForObject("select * from Orders where order_id=?",new Object[] {order_id}
			,new OrderMapper());
			String insertTransaction="insert into transaction(order_id,trader_id,"
					+ "time_stamp,status,price,num_of_shares,order_type) values(?,?,?,?,?,?,?)";
			jdbctemplate.update(insertTransaction,order_id,o1.getTrader_id(),
					new Timestamp(System.currentTimeMillis()),"CANCEL",o1.getPrice(),
					o1.getNumberOfShares(),o1.getOrder_type());
			
			 String sql1="Update Trader Set live_ords=live_ords-1";
			 jdbctemplate.update(sql1);
			return "Order Cancelled successfully";
		}
	}
	
	@Transactional(readOnly=true)
	public Order updateOrder(int order_id,Order o2)
	{
		Order o= jdbctemplate.queryForObject("select * from Orders where order_id=?",new Object[] {order_id}
		,new OrderMapper());
		
		if(o.getStatus().equals("COMPLETED") || o.getStatus().equals("CANCELLED"))
		{
			System.out.println("Order cannot be updated.");
			return o;
		}
		
		else
		{
			String sql = "UPDATE Orders SET price=?,num_of_shares=?,order_type=?,time_stamp=? WHERE order_id=?";
			jdbctemplate.update(sql,o2.getPrice(),o2.getNumberOfShares(),o2.getOrder_type(),new Timestamp(System.currentTimeMillis()),order_id);
			Order o1= jdbctemplate.queryForObject("select * from Orders where order_id=?",new Object[] {order_id}
			,new OrderMapper());
			System.out.println("Order Updated successfully");
			
			String insertTransaction="insert into transaction(order_id,trader_id,"
					+ "time_stamp,status,price,num_of_shares,order_type) values(?,?,?,?,?,?,?)";
			jdbctemplate.update(insertTransaction,order_id,o1.getTrader_id(),
					new Timestamp(System.currentTimeMillis()),"UPDATE",o1.getPrice(),
					o1.getNumberOfShares(),o1.getOrder_type());
			return o1;
		}
	}
	
	
	public int create(final Order order, final int id) {
		order.setTrader_id(id);
		order.setStatus("PENDING");
		final String insertOrder ="insert into orders(ticker,time_stamp,status,"
		+ "request,order_type,price,num_of_shares,trader_id) values(?,?,?,?,?,?,?,?)";
		jdbctemplate.update(insertOrder,order.getTicker(),new Timestamp(System.currentTimeMillis()),"PENDING",
		order.getRequest(),order.getOrder_type(),order.getPrice(),order.getNumberOfShares(),id);
		
		final String query="select MAX(order_id) from orders";
		int orderId = jdbctemplate.queryForObject(
		               	query, Integer.class);
		
		final String insertTransaction="insert into transaction(order_id,trader_id,"
				+ "time_stamp,status,price,num_of_shares,order_type) values(?,?,?,?,?,?,?)";
		jdbctemplate.update(insertTransaction,orderId,order.getTrader_id(),
				new Timestamp(System.currentTimeMillis()),"CREATE",order.getPrice(),
				order.getNumberOfShares(),order.getOrder_type());
		String sql1="Update Trader Set live_ords=live_ords+1";
		jdbctemplate.update(sql1);
		
		return orderId;

		}
	
	public List<Order> listOrderByTrader(@PathVariable int trader_id)
	{
	String sql="Select * from Orders where trader_id=?";
	return jdbctemplate.query(sql,new OrderMapper(),trader_id);

	}
	
	public List<Order> getOrderByStatus(String status){
		final String query="select * from orders where status=?";
		return jdbctemplate.query(query,new Object[] {status},new OrderMapper());
		
	}
	
	public List<Order> getOrderByTicker(String ticker){
		final String query="select * from orders where ticker=?";
		return jdbctemplate.query(query,new Object[] {ticker},new OrderMapper());
		
	}
	
	public List<Order> getOrderByQuantity(int from,int to){
		final String query="select * from orders where num_of_shares BETWEEN ? AND ?";
		return jdbctemplate.query(query,new Object[] {from,to},new OrderMapper());
	}
	public List<Order> getOrderByTime(int from,int to){
		final String query="select * from orders where time_stamp BETWEEN ? AND ?";
		return jdbctemplate.query(query,new Object[] {from,to},new OrderMapper());
	}
	public List<Order> sortByTicker(String sort){
		final String query="select * from orders ORDER BY ticker "+sort;
		return jdbctemplate.query(query,new OrderMapper());
	}
	public List<Order> sortByPrice(String sort){
		final String query="select * from orders ORDER BY price "+sort;
		return jdbctemplate.query(query,new OrderMapper());
	}
	public List<Order> listOrderByOrderSide()
	{
	String sql="Select * from Orders group by request";
	return jdbctemplate.query(sql,new OrderMapper());

	}

	public List<Order> listOrderByOrderSideBuySell(String request1)
	{
	String sql="Select * from Orders where request=?";
	return jdbctemplate.query(sql,new OrderMapper(),request1);

	}

	public List<Order> listOrderByOrderType()
	{
	String sql="Select * from Orders group by order_type";
	return jdbctemplate.query(sql,new OrderMapper());

	}

	public List<Order> listOrderByOrderTypeMarketLimit(String order_type)
	{
	String sql="Select * from Orders where order_type=?";
	return jdbctemplate.query(sql,new OrderMapper(),order_type);

	}

	public List<Order> listOrderByStatus()
	{
	String sql="Select * from Orders group by status";
	return jdbctemplate.query(sql,new OrderMapper());

	}
}

class OrderMapper implements RowMapper<Order>
{

	@Autowired
	Order o;
	
	@Override
	public Order mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setTrader_id(rs.getInt("trader_id"));
		order.setNumberOfShares(rs.getInt("num_of_shares"));
		order.setOrder_id(rs.getInt("order_id"));
		order.setOrder_type(rs.getString("order_type"));
		order.setPrice(rs.getInt("price"));
		order.setRequest(rs.getString("request"));
		order.setStatus(rs.getString("status"));
		order.setTicker(rs.getString("ticker"));
		order.setTime_stamp(rs.getTimestamp("time_stamp"));
		
		return order;
		
	}
	
}
