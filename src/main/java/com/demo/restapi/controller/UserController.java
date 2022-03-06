package com.demo.restapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author BrahmaReddy Boyalla
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController {
	
	
	@GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity < Object > getJsonCount() {
		try {
			JSONArray jsonArray = getJsonArray();
			HashMap<String, Object> jsonObject = new HashMap<String, Object>();
			List<Integer> userIdList = new ArrayList<Integer>();
			
	        for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = new JSONObject(jsonArray.get(i).toString());
				Integer object2 = new Integer(object.getInt("userId"));
				userIdList.add(object2);
				
			}

			long disObjects = userIdList.stream().distinct().count();
			System.out.println(disObjects);
	        jsonObject.put("count", disObjects);
	        return ResponseEntity.ok().body(jsonObject);

			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
        return ResponseEntity.ok().body("");
    
	}
	
	
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity < Object > updateJson() {
		try {
			JSONArray jsonArray = getJsonArray();
	        HashMap<String, Object> jsonObject = (HashMap<String, Object>) jsonArray.toList().get(3);
	        jsonObject.put("title", "1800Flowers");
	        jsonObject.put("body", "1800Flowers");
	        return ResponseEntity.ok().body(jsonObject);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
        return ResponseEntity.ok().body("");
    }
  
	
	
		
  
}
