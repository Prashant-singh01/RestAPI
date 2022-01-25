package retestAuthorization;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class auth2 {
	public static Response Authorization()
	
	{
		Response response = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
				.when().post("https://reqres.in/api/users").then().extract().response();
		
		return response;
		
	}
	
	public static String token()
	{
		Response response = Authorization();
		String token = response.getHeader("Connection");
		return token;
		
	}
	
	public static Map<String, String> cookies()
	{
		Response response = Authorization();
		Map<String,String> cookies = response.getCookies();
		System.out.println("my cookies" +cookies);
		
		return cookies;
	}

}
