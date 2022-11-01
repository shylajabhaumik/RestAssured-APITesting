package payload;
import org.junit.Test;

import io.restassured.path.json.JsonPath;
public class ReusuableMethod {

	public static JsonPath RawToJson(String Response) {
		JsonPath js = new JsonPath(Response);
		return js;
		
	}

}
