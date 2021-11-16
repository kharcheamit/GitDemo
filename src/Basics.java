import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.Payload;
import Files.ReUsableMethods;

public class Basics {

	public static void main(String[] args) {
		
		//first requrement:-  validate if AddPlace API is working as expected
		//Rest Assured is working on 3 principles
		
		//given:All input details
		//when:-Submit API    resource and HTTP methods inculde under this
		//then:- Validate the response
		
		//AddPlace _Update place with New Address -->GetPlace to validate if new address is Present response
				//1-->Addplace  2 -->Put place API   3 Get Place --->To retrieve 
		
		
		
		//first we have to set base URI
		//setp1 giving with 1 paramter:  type query paramter its all chaining paramters.
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//manuaaly note stattic package     given belog to static package 
		//automatcailly json into string by JAVA 
		//how to generate output whnen u run what are parametr sent and which are response got as an output
		
		
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		//scope key body is validating is correct or NOT?
		
		//3 step for extracting Place id from the json body the next procedure is:
		//json path is available whihc convert json into string
		
		JsonPath js=new JsonPath(response);   //for pasrsing json
		
		String PlaceId=js.getString("place_id");   //path of json 
		System.out.println(PlaceId);
		
		
		//Update place---Now to update the address 
		
		String NewAddress="Summer Walk America";
		
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+PlaceId+"\",\r\n"
				+ "\"address\":\""+NewAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		//now we have to verify that update address is verifie do rnot?  by using getplace API
		
		//GetPlace
		
		String GetPlaceResponse=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", PlaceId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().asString();
		
		JsonPath js1=ReUsableMethods.rawToJson(GetPlaceResponse);
		String actualaddress=js1.getString("address");
		System.out.println(actualaddress);
		Assert.assertEquals(actualaddress,NewAddress);
	
		
	
		//both testing framwork
		//cucumber JUnit,TestNg
		
		
		
 	}

}
