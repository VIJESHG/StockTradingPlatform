package com.cs.stocktrading.domains;

public class Trader {
	private int trad_id,live_ords,status;
	private String name;
	private String email;
	private String address;
	public int getTrad_id() {
		return trad_id;
	}
	public void setTrad_id(int trad_id) {
		this.trad_id = trad_id;
	}
	public int getLive_ords() {
		return live_ords;
	}
	public void setLive_ords(int live_ords) {
		this.live_ords = live_ords;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Trader [trad_id=" + trad_id + ", live_ords=" + live_ords + ", status=" + status + ", name=" + name
				+ ", email=" + email + ", address=" + address + "]";
	}
	public Trader(int trad_id, int live_ords, int status, String name, String email, String address) {
		super();
		this.trad_id = trad_id;
		this.live_ords = live_ords;
		this.status = status;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Trader() {
		super();
	}
	
	
}
