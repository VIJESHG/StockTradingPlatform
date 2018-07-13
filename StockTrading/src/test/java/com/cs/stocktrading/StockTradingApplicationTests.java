package com.cs.stocktrading;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.test.context.junit4.SpringRunner;
 
import io.restassured.RestAssured;
 
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

 
//import static com.jayway.restassured.RestAssured.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockTradingApplicationTests {
@LocalServerPort 
private int serverPort;
@Before
public void init() {
RestAssured.port = serverPort;
}
@Test
public void checkTraders() {
given().auth().basic("admin", "admin")
        .when().get("/trader")
        .then().statusCode(200);

given().auth().basic("admin", "admin")
.when().get("/trader/1")
.then().statusCode(200);

}

@Test
public void checkCompany() {
	given().auth().basic("admin", "admin")
    .when().get("/company")
    .then().statusCode(200);

	
	given().auth().basic("admin", "admin")
    .when().get("/company/AP")
    .then().statusCode(200);

}

@Test 
public void checkOrder() {
	
	given().auth().basic("admin", "admin")
    .when().get("/admin/order/1")
    .then().statusCode(200);
	
//	given().auth().basic("trader", "trader")
  //  .when().get("/order/cancel/1")
    //.then().statusCode(200);

	
	given().auth().basic("trader", "trader")
    .when().get("/order/list/sort/price/asc")
    .then().statusCode(200);

	
}

}