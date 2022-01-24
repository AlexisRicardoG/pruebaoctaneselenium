package util.Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestUtil {

	public static void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static void postRequestMethod(Object body) {

		RequestSpecification request = RestAssured.given();

		request.header("Accept", "application/json").header("content-type", "application/json");

		Response response = request.body(body).post();
		System.out.println("el status es: " + response.getStatusCode());
		response.prettyPrint();
		

	}
	public static void main(String[] args) {

		classSetup("https://reqres.in/", "/api/users");
		String body = "{\r\n"
				+ "    \"name\": \"Roberto\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		postRequestMethod(body);

		ApiData testData = new ApiData();

	}
}
