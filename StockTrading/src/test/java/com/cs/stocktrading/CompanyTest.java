package com.cs.stocktrading;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.cs.stocktrading.daos.CompRepo;
import com.cs.stocktrading.domains.Company;

public class CompanyTest {

	private Company cmpCreate;
	private Company cmpDelete;	
	@Autowired
	CompRepo cmp;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String count;
	
	@Before
	public void setUp() throws Exception {
		 cmpCreate = new Company(1, "Credit Suisse", "CS");
		 cmpDelete = new Company(1, "Barcleys", "BAR");
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Transactional(readOnly=true)
	@Test
	public void createCompanyTest() {
		int c1 = jdbcTemplate.queryForObject("select count(*) from company", new Object[] {count}, Integer.class);
		cmp.create(cmpCreate);
		int c2 = jdbcTemplate.queryForObject("select count(*) from company", new Object[] {count}, Integer.class);
		assertEquals(c1, c2 - 1);
	}
}
