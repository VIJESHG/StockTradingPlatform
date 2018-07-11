package com.cs.stocktrading;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.cs.stocktrading.daos.CompRepo;
import com.cs.stocktrading.daos.SectRepo;
import com.cs.stocktrading.domains.Company;
import com.cs.stocktrading.domains.Sector;

public class SectorTest {
	private Sector sectCreate;
	private int sectDelete;	
	
	@Autowired
	SectRepo sect;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String count;
	
	@Before
	public void setUp() throws Exception {
		 sectCreate = new Sector(2,"FIN","Finance");
		 sectDelete = 2;
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void createSectorTest() {
		int c1 = jdbcTemplate.queryForObject("select count(*) from sector", new Object[] {count}, Integer.class);
		sect.create(sectCreate);
		int c2 = jdbcTemplate.queryForObject("select count(*) from sector", new Object[] {count}, Integer.class);
		assertEquals(c1, c2 - 1);
	}
	
	@Test
	public void deleteSectorTest() {
		sect.create(sectCreate);
		int c1 = jdbcTemplate.queryForObject("slect count(*) from sector", new Object[] {count}, Integer.class);
		sect.delete(sectDelete);
		int c2 = jdbcTemplate.queryForObject("select count(*) from sector", new Object[] {count}, Integer.class);
		assertEquals(c2,c1-1);		
	}
	
	@Test
	private void getSectByTickerTest() {
		sect.create(sectCreate);
		int c1 = jdbcTemplate.queryForObject("slect count(*) from sector where ticker='FIN'", new Object[] {count}, Integer.class);
		assertEquals(c1,1);
	}

}
