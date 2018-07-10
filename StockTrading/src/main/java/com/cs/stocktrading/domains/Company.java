package com.cs.stocktrading.domains;

public class Company {
	private int sec_id;
	private String name;
	private String ticker;
	public int getSec_id() {
		return sec_id;
	}
	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Company(int sec_id, String name, String ticker) {
		super();
		this.sec_id = sec_id;
		this.name = name;
		this.ticker = ticker;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [sec_id=" + sec_id + ", name=" + name + ", ticker=" + ticker + "]";
	}
	
}
