package com.example.restaurantmenu;

import org.json.JSONException;
import org.json.JSONObject;

public class MenuItem {
	
	private String menuItemName;
	private String menuItemPrice;
	
	
	MenuItem(JSONObject itemJSON) throws JSONException {
		this.menuItemName = itemJSON.getString("menuItemName");
		this.menuItemPrice = itemJSON.getString("menuItemPrice");
	}


	public String getMenuItemName() {
		return menuItemName;
	}


	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}


	public String getMenuItemPrice() {
		return menuItemPrice;
	}


	public void setMenuItemPrice(String menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}
	
	

}
