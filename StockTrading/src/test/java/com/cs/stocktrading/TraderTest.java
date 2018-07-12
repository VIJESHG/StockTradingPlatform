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
	private Trader tradDelete;
	private int trad_id;
	
	@Autowired
	TraderDao trad;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setUp() throws Exception {
		tradCreate = new Trader(2,0,1,"vij","abc@gmail.com","assdhffheril");
		tradDelete = new Trader(3,0,1,"Briju", "brij@gmail", "VIman Naahar, Pune");
		trad_id = 3;
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
	@Test
	public void getTraderByIdTest() {
		trad.create(tradCreate);
		int c1 = jdbcTemplate.queryForObject("select count(*) from trader where trad_id=?", new Object[] {trad_id}, Integer.class);
		assertEquals(c1,1);
	}
		
	@Test
	public void deleteTraderTest() {
		trad.create(tradDelete);
		int c1 = jdbcTemplate.queryForObject("select count(*) from trader", Integer.class);
		trad.deleteTrader(trad_id);
		int c2 = jdbcTemplate.queryForObject("select count(*) from trader", Integer.class);
		assertEquals(c2,c1);		
	}
	
	@Test
	public void findAllTest() {
		int c1 = trad.findAll().size();
		trad.create(tradCreate);
		trad.create(tradDelete);
		int c2 = trad.findAll().size();
		assertEquals(c1+2, c2);
	}
}
