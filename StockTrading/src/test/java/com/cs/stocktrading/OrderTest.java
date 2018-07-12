package com.cs.stocktrading;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.stocktrading.daos.CompRepo;
import com.cs.stocktrading.daos.OrderDao;
import com.cs.stocktrading.daos.SectRepo;
import com.cs.stocktrading.daos.TraderDao;
import com.cs.stocktrading.domains.Company;
import com.cs.stocktrading.domains.Order;
import com.cs.stocktrading.domains.Sector;
import com.cs.stocktrading.domains.Trader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
	private Order orderCreate;
	private Order orderDelete;
	private Trader trader;
	private Company cmp;
	private int trad_id;
	private Sector sectCreate;
	
	@Autowired
	OrderDao order;
	
	@Autowired
	TraderDao trad;
	
	@Autowired
	CompRepo cmpRepo;
	
	@Autowired 
	SectRepo sect;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setUp() throws Exception {
		sectCreate = new Sector(5, "Fin", "Finance");
		trader = new Trader(3,0,1,"Briju", "brij@gmail", "VIman Naahar");
		trad_id = 3;
		cmp = new Company(5, "Barclays", "BRC");
		orderCreate = new Order(50, 400, 5, trader.getTrad_id(), cmp.getTicker(), "Pending", "Limit", "Buy", new Timestamp(System.currentTimeMillis()));
		//oderDelete = new Order();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createTest() {
		sect.create(sectCreate);
		trad.create(trader);
		cmpRepo.create(cmp);
		int c1 = jdbcTemplate.queryForObject("select count(*) from orders", Integer.class);
		order.create(orderCreate, trader.getTrad_id());
		int c2 = jdbcTemplate.queryForObject("select count(*) from orders", Integer.class);
		assertEquals(c1, c2 - 1);
	}
}
