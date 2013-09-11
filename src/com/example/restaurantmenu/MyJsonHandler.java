package com.example.restaurantmenu;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.loopj.android.http.JsonHttpResponseHandler;

public class MyJsonHandler extends JsonHttpResponseHandler {

	private final MainActivity activity;

	public MyJsonHandler(MainActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onSuccess(JSONObject json) {
		try {
			JSONArray jsonArray = json.getJSONArray("results");
			List<MenuItem> items = new ArrayList<MenuItem>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonItem = jsonArray.getJSONObject(i);
				items.add(new MenuItem(jsonItem));
			}
			activity.onDownloadSuccess(items);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}
