package com.cs.stocktrading;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.stocktrading.daos.TraderDao;
import com.cs.stocktrading.domains.Trader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TraderTest {
	
	private Trader tradCreate;	
	
	@Autowired
	TraderDao trad;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setUp() throws Exception {
		tradCreate = new Trader(2,0,1,"vij","abc@gmail.com","assdhffheril"); 
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void createTraderTest() {
		int c1 = jdbcTemplate.queryForObject("select count(*) from trader", Integer.class);
		trad.create(tradCreate);
		int c2 = jdbcTemplate.queryForObject("select count(*) from trader", Integer.class);
		assertEquals(c1, c2 - 1);
	}
	
		
}
