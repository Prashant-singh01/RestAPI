package Authorization;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.rsponse.Response;

public class BasicAuthorization {
	
	public static io.restassured.response.Response Auth() throws IOException
	{
		io.restassured.response.Response response = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
				.when().post(filereader.readvalues("url")).then().extract().response();
		
		return response;
	}
	
	public void token() throws IOException
	{
		io.restassured.response.Response Token = Auth();
		String tokenvalues = Token.getHeader("Connection");
		System.out.println("my token values is" + tokenvalues);
	}
	
	public void cookies() throws IOException
	{
		io.restassured.response.Response response = Auth();
		Map<String,String> cookies1 = response.getCookies();
		System.out.println("my cookies" +cookies1);
	}

}
