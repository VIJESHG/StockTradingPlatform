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

import com.cs.stocktrading.daos.SectRepo;
import com.cs.stocktrading.domains.Sector;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SectorTest {

	private Sector sectCreate;
	private Sector sectDelete;
	private Sector sectGetId;
	private Sector sectUpdateBefore;
	private Sector sectUpdateAfter;
	private int sec_id;
	private int sec_id2;
	private String name;
	private String descr;
	
	@Autowired
	SectRepo sect;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String count;
	
	@Before
	public void setUp() throws Exception {
		 sectCreate = new Sector(2,"FIN","Finance");
		 sectDelete = new Sector(3,"EDU","Education");
		 sectGetId = new Sector(4,"FIL","FILM");
		 sectUpdateBefore = new Sector(6,"HEL","HEALTH");
		 sectUpdateAfter = new Sector(6,"IT","Information");
		 sec_id = 4;
		 sec_id2 = 6;
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void createSectorTest() {
		int c1 = jdbcTemplate.queryForObject("select count(*) from sector", Integer.class);
		sect.create(sectCreate);
		int c2 = jdbcTemplate.queryForObject("select count(*) from sector",  Integer.class);
		assertEquals(c1, c2 - 1);
	}
	
	@Test
	public void deleteSectorTest() {
		sect.create(sectDelete);
		int c1 = jdbcTemplate.queryForObject("select count(*) from sector", Integer.class);
		sect.delete(sec_id);
		int c2 = jdbcTemplate.queryForObject("select count(*) from sector", Integer.class);
		assertEquals(c2,c1-1);		
	}
	
	@Test
	public void getSectByIdTest() {
		sect.create(sectGetId);
		int c1 = jdbcTemplate.queryForObject("select count(*) from sector where sec_id=?", new Object[] {sec_id}, Integer.class);
		assertEquals(c1,1);
	}
	
	@Test
	public void updateSector() {
		sect.create(sectUpdateBefore);
		sect.update(sec_id2,sectUpdateAfter);
		String nameU = jdbcTemplate.queryForObject("select name from sector where sec_id=?", new Object[] {sec_id2},String.class);
		String descrU = jdbcTemplate.queryForObject("select descr from sector where sec_id=?", new Object[] {sec_id2},String.class); 
		assertEquals(sectUpdateAfter.getName(),nameU);
		assertEquals(sectUpdateAfter.getDescr(),descrU);
	}
	
	
	
}
