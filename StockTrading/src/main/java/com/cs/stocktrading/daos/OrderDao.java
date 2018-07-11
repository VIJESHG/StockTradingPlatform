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

import com.cs.stocktrading.domains.Order;
import com.cs.stocktrading.enums.OrderType;
import com.cs.stocktrading.enums.Status;

@Repository
public class OrderDao{
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public int create(final Order order, final int id) {
		order.setTrader_id(id);
		order.setStatus("PENDING");
		final String sql ="insert into orders(ticker,time_stamp,status,"
				+ "request,order_type,price,num_of_shares,trader_id) values(?,?,?,?,?,?,?,?)";
		jdbctemplate.update(sql,order.getTicker(),new Timestamp(System.currentTimeMillis()),"PENDING",
				order.getRequest(),order.getOrder_type(),order.getPrice(),order.getNumberOfShares(),id);
		final String query="select MAX(order_id) from orders";
		int orderId = jdbctemplate.queryForObject(
                		query, Integer.class);
		return orderId;
		
	}
}

//class OrderMapper implements RowMapper<Order>
//{
//
//@Override
//public Order mapRow(ResultSet rs, int arg1) throws SQLException {
//// TODO Auto-generated method stub
//Order order = new Order();
//order.setOrder_id(rs.getInt("order_id"));
//order.setNumberOfShares(rs.getInt("num_of_shares"));
//order.setOrder_id(rs.getInt("order_id"));
//order.setOrder_type(rs.getString("order_type"));
//order.setPrice(rs.getInt("price"));
//order.setRequest(rs.getString("request"));
//order.setStatus(rs.getString("status"));
//order.setTicker(rs.getString("ticker"));
//order.setTime_stamp(rs.getTimestamp("time_stamp"));
//return order;
//}
//
//}
