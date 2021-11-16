package Practice;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.Location;

public class SpecBuilderTest1 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Addplace p=new Addplace();
		
		p.setAccuracy(100);
		p.setAddress("house no 280 Germany");
		p.setName("Household Pune");
		p.setLanguage("English");
	p.setPhone_number("1234567890");
	p.setWebsite("https://rahulshettyacademy.com");
	
	
	List<String>MyList=new ArrayList<String>();
		
	MyList.add("France");
	MyList.add("UK");
	
	p.setTypes(MyList);
	
	Location l=new Location();
	l.setLat(12345);
	l.setLng(909090);
p.setLocation(l);

//create for RequestSpecBuilder

RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

//create for ResponseSpecBuilder

ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

////RequestSpecification res=given().spec(req)
//.body(p);
//
//
//
//Response response=res.when().post("/maps/api/place/add/json")
//.then().spec(resspec).extract().response();
//		
//String responseString=response.asString();
//
//System.out.println(responseString);


	
	
	
		
	}
}
