package com.example.restaurantmenu;

import org.json.JSONException;

public class MyRestClientUsage {
	
	public void getMenuItems(String s, MainActivity activity) throws JSONException {
		
		MyRestClient.get(s, null, new MyJsonHandler(activity));
	}

}
