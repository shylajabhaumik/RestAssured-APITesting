package payload;


public class JSON_payload {
	
	public static String maps_payload_PostRequestMsg() {
		
		String Post_payload = "{\n"
				+ "  \"location\": {\n"
				+ "    \"lat\": -38.383494,\n"
				+ "    \"lng\": 33.427362\n"
				+ "  },\n"
				+ "  \"accuracy\": 50,\n"
				+ "  \"name\": \"Frontline house\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\n"
				+ "  \"types\": [\n"
				+ "    \"shoe park\",\n"
				+ "    \"shop\"\n"
				+ "  ],\n"
				+ "  \"website\": \"http://google.com\",\n"
				+ "  \"language\": \"French-IN\"\n"
				+ "}\n"
				+ "";
		
		return Post_payload;
	}
	
	public static String maps_payload_PutRequestMsg(String place_id) {
		
		String Put_payload = "{\n"
				+ "\"place_id\":\""+place_id+"\",\n"
				+ "\"address\":\"70 Summer walk, USA\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}";
		
		return Put_payload;
	}

	public static String library_payload_responseMsg() {
		
		String response = "{\n"
				+ "\"dashboard\": {\n"
				+ "\"purchaseAmount\": 910,\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n"
				+ "},\n"
				+ "\"courses\": [\n"
				+ "{\n"
				+ "\"title\": \"Selenium Python\",\n"
				+ "\"price\": 50,\n"
				+ "\"copies\": 6\n"
				+ "},\n"
				+ "{\n"
				+ "\"title\": \"Cypress\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "},\n"
				+ "{\n"
				+ "\"title\": \"RPA\",\n"
				+ "\"price\": 45,\n"
				+ "\"copies\": 10\n"
				+ "}\n"
				+ "]\n"
				+ "}";
		return response;
		
	}
	
	public static String registration_request_payload(String username, String job) {
		
		/*String registration = "{\n"
				+ "    \"email\": \""+email+"\",\n"
				+ "    \"password\": \""+password+"\"\n"
				+ "}";
		
		return registration;*/
		
		String registration = "{\n"
				+ "    \"name\": \""+username+"\",\n"
				+ "    \"job\": \""+job+"\"\n"
				+ "}";
		return registration;

	}
}
