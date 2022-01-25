package Authorization;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getrequest {
	
	
	public static void main(String[] args) throws IOException {
		Response response = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
				.when().get(filereader.readvalues("url")).then().extract().response();
		
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		
		
		String fetchvalues = response.path(statuscode.checkval).toString();
		System.out.println(fetchvalues);
		
		int code = response.statusCode();
		int myexpectedcode = statuscode.statuscode;
		
		if(code==myexpectedcode)
		{
			System.out.println("my validation is successfull");
		}
		
		String expbody = statuscode.bodyvalues;
		if(expbody.equals(fetchvalues))
		{
			
			System.out.println("my expbody values are correct");
		}
		
		
		
		
		
	}

}
