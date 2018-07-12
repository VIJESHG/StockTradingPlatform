package com.cs.stocktrading.domains;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

public class Transaction {
	private int order_id, price, numberOfShares,trader_id,trans_id;
	private String status;
	private String order_type;
	@Autowired
	private Timestamp time_stamp;
	@Override
	public String toString() {
		return "Transaction [order_id=" + order_id + ", price=" + price + ", numberOfShares=" + numberOfShares
				+ ", trader_id=" + trader_id + ", trans_id=" + trans_id + ", status=" + status + ", order_type="
				+ order_type + ", time_stamp=" + time_stamp + "]";
	}
	public Transaction() {
		super();
	}
	public Transaction(int order_id, int price, int numberOfShares, int trader_id, int trans_id, String status,
			String order_type, Timestamp time_stamp) {
		super();
		this.order_id = order_id;
		this.price = price;
		this.numberOfShares = numberOfShares;
		this.trader_id = trader_id;
		this.trans_id = trans_id;
		this.status = status;
		this.order_type = order_type;
		this.time_stamp = time_stamp;
	}
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
	public int getTrader_id() {
		return trader_id;
	}
	public void setTrader_id(int trader_id) {
		this.trader_id = trader_id;
	}
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
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
	public Timestamp getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Timestamp time_stamp) {
		this.time_stamp = time_stamp;
	}
}
