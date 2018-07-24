package com.qa.apitest;

import static com.jayway.restassured.RestAssured.*;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.qa.testbase.TestBase;
import com.qa.util.JsonReaderUtility;


public class GetAPITest extends TestBase {
	
	TestBase testBaseObject;
	String apiUrl;

	@BeforeMethod
	public void setUp() {
		testBaseObject = new TestBase();
		apiUrl = pro.getProperty("uri");
		
	}

	@Test(priority = 1)
	public void getAPiTest_TCC01() {

		Response responseJSON = when().get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=673c5650a20311041c26d61291b186ae");

		int statusCode = responseJSON.getStatusCode();

		Assert.assertEquals(statusCode,
				TestBase.RESPONSE_STATUS_CODE_200,
				"Status code not Matched");
	}

	
	
	@Test(priority = 2)
	public void verifyJsonResponse_TCC03() {

	   Response jsonResponse=    given().
	    		                 parameter(pro.getProperty("Key1"), pro.getProperty("value1")).
	    		                 parameter(pro.getProperty("Key2"), pro.getProperty("value2")).
	    		                 when().get(apiUrl);
	    		                 
      		String responseJSON= jsonResponse.asString();
      		 System.out.println("ResponseJson>>"+responseJSON);
      		 
      		//Validate the JSON path parameter
      		
      		JSONObject jsonObject= new JSONObject(responseJSON);
      		
      		System.out.println("JsonObject>>"+jsonObject);
      	String longitude=	JsonReaderUtility.getValueByJPath(jsonObject, "/coord/lat");
      		Assert.assertEquals(longitude, "51.51");
      		
      		String id = JsonReaderUtility
    				.getValueByJPath(jsonObject, "/weather[0]/id");
      		String main = JsonReaderUtility
    				.getValueByJPath(jsonObject, "/weather[0]/main");
      		String description = JsonReaderUtility
    				.getValueByJPath(jsonObject, "/weather[0]/description");
      		String icon = JsonReaderUtility
    				.getValueByJPath(jsonObject, "/weather[0]/icon");
      		 
      		System.out.println(id);
      		System.out.println(main);
      		System.out.println(description);
      		System.out.println(icon);
		
	}
	
	
	@Test(priority = 3)
	public void verifyJsonResponse_TCC04() {

	  String weatherInforamtion= given().
	    		                 parameter(pro.getProperty("Key1"), pro.getProperty("value1")).
	    		                 parameter(pro.getProperty("Key2"), pro.getProperty("value2")).
	    		                 when().get(apiUrl).
	    		                 then().contentType(ContentType.JSON).
	    		                 extract().path("weather[0].description");

	Assert.assertEquals(weatherInforamtion, "light rain");
	
	}
}