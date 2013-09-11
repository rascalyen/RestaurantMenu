package com.example.restaurantmenu;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MyRestClient {
	
	private static final String HOST = "http://im360challenge1.cloudhub.io/0.1/menuchallenge";
	
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.get(getAbsoluteUrl(url), params, responseHandler);
	  }

	  public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.post(getAbsoluteUrl(url), params, responseHandler);
	  }
	  
	  public static void put(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.put(getAbsoluteUrl(url), params, responseHandler);
	  }  
	  
	  private static String getAbsoluteUrl(String relativeUrl) {
	      return HOST + relativeUrl;
	  }

}
