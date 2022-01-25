package retestAuthorization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class performPostrequest {
	public static void main(String[] args) {
		

		String bodyvalues = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
	
		
		ExtractableResponse<Response> res = RestAssured.given().log().all().contentType(ContentType.JSON)
         .headers("WSCommonConstants.COKIE_TOKEN", "cookies")
               .headers("WSCommonConstants.KSIOPE_SESION_TOKEN",auth2.token()).body(bodyvalues)
                .post("https://reqres.in/api/users")
                 .then().extract();

            System.out.println(res.statusCode());
            System.out.println(res.body().asString());
		
		
	}

}
