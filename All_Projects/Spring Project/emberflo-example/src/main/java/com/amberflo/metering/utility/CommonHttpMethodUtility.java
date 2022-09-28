package com.amberflo.metering.utility;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class CommonHttpMethodUtility {
	final static Logger logger = LoggerFactory.getLogger(CommonHttpMethodUtility.class);		
	String resStr = null;
	
	@Value("${amberflo.apiKey}")
	private String AMBERFLO_API_KEY;	
	
	//post method 
	public String amberfloHttpPostMethod(String entityStr, String POST_URL) throws IOException {
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, entityStr.toString());
		Response response;
		String resStr = null;
		
		Request request = new Request.Builder()
				  .url(POST_URL)
				  .post(body)
				  .addHeader("Accept", "application/json")
				  .addHeader("Content-Type", "application/json")
				  .addHeader("x-api-key", AMBERFLO_API_KEY)
				  .build();
				
		response = client.newCall(request).execute();
		resStr = response.body().string();
		logger.debug(resStr);
		
		return resStr;
	}
	
	// get method
	public String amberfloHttpGetMethod(String GET_URL) throws IOException {
		OkHttpClient client = new OkHttpClient();
		resStr = null;
		
		Request request = new Request.Builder()
		  .url(GET_URL)
		  .get()
		  .addHeader("Accept", "application/json")
		  .addHeader("Content-Type", "application/json")
		  .addHeader("x-api-key", AMBERFLO_API_KEY)
		  .build();

		Response response = client.newCall(request).execute();
		resStr = response.body().string();
		
		return resStr;
	}
		
	//update method
	public String amberfloHttpPutMethod(String entityStr, String PUT_URL, String meterId) throws IOException {
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, entityStr.toString());
		Response response;
		resStr = null;
		
		Request request = new Request.Builder()
				  .url(PUT_URL + meterId)
				  .put(body)
				  .addHeader("Accept", "application/json")
				  .addHeader("Content-Type", "application/json")
				  .addHeader("x-api-key", AMBERFLO_API_KEY)
				  .build();
		
		response = client.newCall(request).execute();
		resStr = response.body().string();
		logger.debug(resStr);
		
		return resStr;
	}
	
	// get method
	public String amberfloHttpGetMethodById(String meterId, String GET_URL) throws IOException {
		OkHttpClient client = new OkHttpClient();
		resStr = null;
		
		Request request = new Request.Builder()
		  .url(GET_URL + meterId)
		  .get()
		  .addHeader("Accept", "application/json")
		  .addHeader("Content-Type", "application/json")
		  .addHeader("x-api-key", AMBERFLO_API_KEY)
		  .build();

		Response response = client.newCall(request).execute();
		logger.debug(response.toString());
		resStr = response.body().string();
		return resStr;
	}
	
	//delete meter
	public String amberfloHttpDeleteMethod(String meterId, String DELETE_URL) throws IOException {
		OkHttpClient client = new OkHttpClient();
		resStr = null;
		
		Request request = new Request.Builder()
		  .url(DELETE_URL + meterId)
		  .delete(null)
		  .addHeader("Accept", "application/json")
		  .addHeader("x-api-key", AMBERFLO_API_KEY)
		  .build();

		Response response = client.newCall(request).execute();
		resStr = response.body().string();
		return resStr;
	}
}