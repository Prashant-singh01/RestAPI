package demo1API;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import Authorization.readjsonBody;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class MyAPI_project {
	
	public static void main(String[] args) throws IOException {
		
		//==================Authentication============================================
		Response response = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
				.when().post("https://reqres.in/api/users").then().extract().response();
	   
		int statuscode = response.statusCode();
		System.out.println("My status code" +statuscode);
	   
		String body = response.body().asString();
		System.out.println("My staus body" +body);
		
		
		Headers head = response.headers();
		System.out.println("My headers value" + head);
		System.out.println(response.getHeader("CF-RAY"));
		
		//getheader
		String tokenvalue=response.getHeader("Connection");
		System.out.println("My tokenvalue is" +tokenvalue);
		
		
		//getcookies
		Map<String,String> cookies = response.getCookies();
		System.out.println("my cookies" +cookies);
		
		
		//====================post request code===========================================
		
		
	/*	String bodyvalues = "{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}"; */
		
		ExtractableResponse<Response> res = RestAssured.given().log().all().contentType(ContentType.JSON)
              .headers("WSCommonConstants.COKIE_TOKEN", "cookies")
                    .headers("WSCommonConstants.KSIOPE_SESION_TOKEN", "header").body(readjsonBody.Read_jsonBody("C:\\Users\\HP\\git\\repository\\RestAPI\\demo1API\\src\\test\\resources\\Mypostrequest.json"))
                     .post("https://reqres.in/api/users")
                      .then().extract();

                 System.out.println(res.statusCode());
                 System.out.println(res.body().asString());
		
		
		
		
	   
	   
	}

	
}
