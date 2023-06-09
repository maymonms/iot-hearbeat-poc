package com.techspace.rest;

import com.techspace.utils.ConfigurationProperties;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {
	private OkHttpClient client;
	public ApiClient() {
		client = new OkHttpClient().newBuilder().build();
		
	}
	
	public Response get(String url) throws Exception {
		Request request = new Request.Builder()
				  .url(url)
				  .method("GET", null)
				  .build();
		Response response = client.newCall(request).execute();
		return response;
	}

	public Response post(String url, String payload) throws Exception {
		Request request = new Request.Builder()
				  .url(url)
				  .method("POST", null)
				  .addHeader("Authorization", "Bearer "+ConfigurationProperties.properties.getProperty("btoken"))
				  .build();
		Response response = client.newCall(request).execute();
		return response;
	}

}
