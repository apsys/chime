package com.test.chime.common.utility;

import static io.restassured.RestAssured.when;
import com.test.chime.common.abstraction.IRestClient;
import io.restassured.response.Response;

public class RestClientImpl implements IRestClient{

	@Override
	public WResponse get(String path) {
		
		Response resp =
		when().
			get(path).
		then().
			assertThat().statusCode(200).log().all().extract().response();

		return new WResponse(resp);
	}
}
