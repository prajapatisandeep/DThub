package Project_pkg.Batch;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class tweetPost {
	
	
	public static void main(String[] args) 
	{
	
		String consumer_key="DOZxNvAouBWwiTOTxD9Z97Dos";
		String Consumer_Secret="tz3pQEwF82QJJXisniabpr7ro9BZyKBUlROTcvtjKYTtcHIv4v";
	    String Access_token="1062358020099690498-0DHXIoXCIzWYgZca0qYLAquSBaUMHm";
	    String token_secret="4oegCDT0lCveBGK5nbDq8W3s91EhLNvur8mvM2uGNfdx9";
	    
	    RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
	    
	    Response res=
	    given()
	    .contentType(ContentType.JSON)
	    .auth()
	    .oauth(consumer_key, Consumer_Secret, Access_token, token_secret)
	    .queryParam("status","this is my tweet DC")
	    .when()
	    .post("/update.json");
	    
	    System.out.println("status code is "+res.statusCode());
	    System.out.println(res.asString());
	    

	}

}
