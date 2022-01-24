package util.Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTestMethods {

	public static void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static String actionApiSelection(ApiData data) {

		switch (data.getRequestType().toLowerCase()) {

		case "post":
			RequestSpecification postRequest = RestAssured.given();
			postRequest.header("Accept", "application/json").header("content-type", "application/json");
			Response postResponse = postRequest.body(data.getBody()).post();
			System.out.println("el status es: " + postResponse.getStatusCode());
			postResponse.prettyPrint();
			return postResponse.asString();
		case "get":
			RequestSpecification getRequest = RestAssured.given();
			getRequest.header("Content-type", "application/json");
			Response getResponse = getRequest.body(data.body).get();
			System.out.println("el status es: " + getResponse.getStatusCode());
			getResponse.prettyPrint();
			return getResponse.asString();
		case "put":
			RequestSpecification putRequest = RestAssured.given();
			putRequest.header("content-type", "application/json");
			Response putResponse = putRequest.body(data.getBody()).put();
			System.out.println("el status es: " + putResponse.getStatusCode());
			putResponse.prettyPrint();
			return putResponse.asString();
		case "delete":
			RequestSpecification deleteRequest = RestAssured.given();
			deleteRequest.header("content-type", "application/json");
			Response deleteResponse = deleteRequest.body(data.getBody()).delete();
			System.out.println("el status es: " + deleteResponse.getStatusCode());
			deleteResponse.prettyPrint();
			return deleteResponse.asString();

		default:
			return "error desconocido";
		}

	}

	public static void main(String[] args) {

		classSetup("https://reqres.in/", "/api/users?page=2");
		String requestType = "get";
		String body = "";
		ApiData data = new ApiData(requestType, body);

		actionApiSelection(data);

	}

}
