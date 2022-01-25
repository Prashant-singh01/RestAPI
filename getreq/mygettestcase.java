package getreq;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import Authorization.filereader;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import retestAuthorization.auth2;

public class mygettestcase {
	
	public static void main(String[] args) throws IOException {
		
		Response response = RestAssured.given()
				.config(RestAssured.config()
				.encoderConfig(EncoderConfig.encoderConfig()
				.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
				.contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
				.when().get(filereader.readvalues("url")).then().extract().response();
		
	

	            System.out.println(response.statusCode());
	            System.out.println(response.body().asString());
	            
	            String fetchvalues = response.path("page").toString();
	            System.out.println(fetchvalues);
	            
	            int code = response.statusCode();
	            int myexpectedcode = 200;
	            
	            if(code==myexpectedcode)
	            {
	            	System.out.println("my validation is succesddful");
	            	
	            }
	            
	            String expbody = "1";
	            if(expbody.equals(fetchvalues))
	            {
	            	System.out.println("my body value are correct");
	            }
	            
	            
	
}
}