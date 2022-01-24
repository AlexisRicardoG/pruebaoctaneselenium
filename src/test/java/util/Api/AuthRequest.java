package util.Api;

import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthRequest {

	public static void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	@Test
	public static void AutorizationUserRequest(String credentials, Object body) {

		RequestSpecification request = RestAssured.given();

		byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());

		String encodedCredentialsString = new String(encodedCredentials);

		request.header("Authorization", "Basic " + encodedCredentialsString);

		request.header("Content-type", "application/json");

		Response response = request.body(body).get();
		System.out.println("Response status code is: " + response.getStatusCode());
		response.prettyPrint();

	}
	
	public static void main(String[] args) {

		classSetup("https://postman-echo.com", "/basic-auth");
		String credentials = "postman:password";
		String body = "";
		AutorizationUserRequest(credentials,body);

		ApiData testData = new ApiData();
		

	}

}
