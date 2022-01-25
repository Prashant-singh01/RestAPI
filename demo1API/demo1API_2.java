package demo1API;

import java.nio.charset.StandardCharsets;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.rsponse.Response;

public class demo1API_2 {
	
	
	public static void main(String[] args) {
		
		io.restassured.response.Response response = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
				.when().post("https://reqpoarres.in/api/users").then().extract().response();
		
		System.out.println(response.statusCode());
	}
	

}
