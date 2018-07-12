package com.cs.stocktrading;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.stocktrading.daos.SectRepo;
import com.cs.stocktrading.domains.Sector;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class SectorIntTesting {
	
	private Sector sectCreate;
	private Sector sectDelete;
	
	@Autowired
	SectRepo sect;
	
	@Before
	public void setUp() throws Exception {
		 sectCreate = new Sector(2,"FIN","Finance");
		 sectDelete = new Sector(3,"EDU","Education");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void sectors() {
		
		
		
		Response response = 
		   given()
		   .accept(MediaType.APPLICATION_JSON_VALUE).
		   when()
		   .get("/sectors").
		   then()
		   .statusCode(HttpStatus.SC_OK).
		   and()
		   .extract().response();
		   Sector[] jsonResponse = response.as(Sector[].class);
	}
	
}
