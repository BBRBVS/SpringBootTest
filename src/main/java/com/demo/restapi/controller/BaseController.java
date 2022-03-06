package com.demo.restapi.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class BaseController {

	public JSONArray getJsonArray() {
		JSONArray jsonArray = null;
		try {
			List<String> infos = new ArrayList<String>();
			RestTemplate restTemplate = new RestTemplate();
	    	String baseUrl = "http://jsonplaceholder.typicode.com/posts";
	    	URI uri = new URI(baseUrl);
			
	    	HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/x-www-form-urlencoded");
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		     
		    HttpEntity <String> entity = new HttpEntity<String>(headers);
			HttpEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			if(responseEntity != null) {
				jsonArray = new JSONArray(responseEntity.getBody());	
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jsonArray;

	}
	
}
