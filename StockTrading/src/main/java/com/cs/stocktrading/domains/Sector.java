package com.cs.stocktrading.domains;

public class Sector {
	private int sec_id;
	private String name;
	private String descr;
	public Sector(int sec_id, String name, String descr) {
		super();
		this.sec_id = sec_id;
		this.name = name;
		this.descr = descr;
	}
	public Sector() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public String toString() {
		return "Sector [sec_id=" + sec_id + ", name=" + name + ", descr=" + descr + "]";
	}
	
}
