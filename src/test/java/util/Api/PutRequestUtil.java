package util.Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestUtil {

	public static void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void putRequestMethod(Object body) {

		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		Response response = request.body(body).put();
		System.out.println("el status es: " + response.getStatusCode());
		response.prettyPrint();
	}

	public static void main(String[] args) {

		classSetup("https://reqres.in/", "/api/users/2");
		String body = "{\r\n" + "    \"name\": \"Jose Luis\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}";
		putRequestMethod(body);
	}

}
