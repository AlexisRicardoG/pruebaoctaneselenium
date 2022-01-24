package util.Api;

public class ApiData {
	
	public String requestType;
	
	public String body;
	
	public int expected;

	public String path;
	
	public String URL;
	
	public ApiData() {
		super();
	}
	public ApiData(String requestType, String body) {
		super();
		this.requestType = requestType;
		this.body = body;
	}
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getExpected() {
		return expected;
	}

	public void setExpected(int expected) {
		this.expected = expected;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		return "TestData [requestType=" + requestType + ", body=" + body + ", expected=" + expected + ", path=" + path
				+ ", URL=" + URL + "]";
	}

	


	
}
