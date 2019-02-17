package Project_pkg.Batch;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostRequest {
	
	public static void main(String[] args) 
	{
		Address[] address=new Address[2];
		address[0]=new Address();
		address[0].setHouseno(121);
		address[0].setLandmark("primary address");
		address[0].setSector(23);
		
		address[1]=new Address();
		address[1].setHouseno(1221);
		address[1].setLandmark("secondary address");
		address[1].setSector(22);
		
		
		BasicInformation basic=new BasicInformation();
		basic.setId(121);
		basic.setAuthor("Mr. deepak");
		basic.setName("Mr. Chanana");
		basic.setAddress(address);
					
	Response res=	
	 given()
	 .contentType(ContentType.JSON)
	 .body(basic)
	 .when()
	 .post("http://localhost:3000/posts");
	 
	System.out.println("response code is "+res.statusCode());
	System.out.println(res.asString());
	
	int sector=res.jsonPath().get("address[1].sector");
	System.out.println("Sector is "+sector);
	
	}

}
