package util.Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestUtil {

	public static void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void getRequestMethod(Object body) {

		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json");
		Response response = request.body(body).get();
		System.out.println("el status es: " + response.getStatusCode());
		response.prettyPrint();

	}

	public static void main(String[] args) {

		classSetup("https://reqres.in/", "/api/unknown");
		String body = "";
		getRequestMethod(body);

		ApiData testData = new ApiData();
		

	}
}
