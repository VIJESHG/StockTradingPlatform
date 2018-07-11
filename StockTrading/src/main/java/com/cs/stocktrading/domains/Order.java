package com.cs.stocktrading.domains;

import java.sql.Timestamp;

public class Order {
	private int order_id,price,numberOfShares,trader_id;
	public int getTrader_id() {
		return trader_id;
	}
	public void setTrader_id(int trader_id) {
		this.trader_id = trader_id;
	}
	private String ticker;
	private String status;
	private String order_type;
	private String request;
	private Timestamp time_stamp;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Timestamp getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Timestamp time_stamp) {
		this.time_stamp = time_stamp;
	}
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", price=" + price + ", numberOfShares=" + numberOfShares
				+ ", trader_id=" + trader_id + ", ticker=" + ticker + ", status=" + status + ", order_type="
				+ order_type + ", request=" + request + ", time_stamp=" + time_stamp + "]";
	}
	
	public Order(int order_id, int price, int numberOfShares, int trader_id, String ticker, String status,
			String order_type, String request, Timestamp time_stamp) {
		super();
		this.order_id = order_id;
		this.price = price;
		this.numberOfShares = numberOfShares;
		this.trader_id = trader_id;
		this.ticker = ticker;
		this.status = status;
		this.order_type = order_type;
		this.request = request;
		this.time_stamp = time_stamp;
	}
	public Order() {
		super();
	}
	
}
