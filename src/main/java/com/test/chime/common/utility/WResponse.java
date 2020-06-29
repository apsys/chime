package com.test.chime.common.utility;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class WResponse {

	Response response = null;
	String pathToProgramming = "$.[0].type";
	String pathToProgrammingAll = "$.[*].type";

	public WResponse(Response rest) {
		this.response = rest;
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public String getResponse() {
		if(this.response != null) {
			return response.asString();
		}
		return null;
	}

	public String getType() {
		return JsonPath.read(getResponse(), pathToProgramming);
	}

	public JSONArray getRecords() {
		JSONArray records = (JSONArray) JsonPath.read(getResponse(), pathToProgrammingAll);
		return records;
	}

	public int getSize() {
		return getRecords().size();	
	}

	public boolean verifyAll() {
		JSONArray records = getRecords();
		boolean found = false;
		for (int i = 0; i < records.size(); i++) 
			if (records.get(i).equals("programming"))
				found = true;
		return found;
	}
}
