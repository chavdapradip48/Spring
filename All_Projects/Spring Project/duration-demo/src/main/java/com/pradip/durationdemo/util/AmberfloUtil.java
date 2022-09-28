package com.pradip.durationdemo.util;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pradip.durationdemo.model.AmberfloIngestMeterDTO;
import com.pradip.durationdemo.model.AmberfloMeterDTO;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class AmberfloUtil {
	private String APIKey="e65777d0-ed3e-11ec-90f7-3bb552ef1199";
	
	@SuppressWarnings("deprecation")
	public String save(AmberfloMeterDTO meter) throws IOException {
		
		
		OkHttpClient client = new OkHttpClient();

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(meter);
		System.out.println("This meter save : "+json.toString());
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, json);

		Request request = new Request.Builder()
				  .url("https://app.amberflo.io/meters")
				  .post(body)
				  .addHeader("Accept", "application/json")
				  .addHeader("Content-Type", "application/json")
				  .addHeader("x-api-key", APIKey)
				  .build();
		
		Response response = client.newCall(request).execute();
		String res = response.body().string();
		System.out.println(res);
		return res;
	}
	
	public String getAllMeters() throws IOException {
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
		  .url("https://app.amberflo.io/meters")
		  .get()
		  .addHeader("Accept", "application/json")
		  .addHeader("x-readme-api-explorer", "4.163.0")
		  .addHeader("x-api-key", APIKey)
		  .build();

		Response response = client.newCall(request).execute();
		String res = response.body().string();
		System.out.println(res);
		return res;
	}
	
	public String createCustomerwiseIngestMeter(List<AmberfloIngestMeterDTO> ingestMeter) throws IOException {
		OkHttpClient client = new OkHttpClient();

		String json = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(ingestMeter);
		
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, json.toString());

		Request request = new Request.Builder()
				  .url("https://app.amberflo.io/ingest")
				  .post(body)
				  .addHeader("Accept", "application/json")
				  .addHeader("Content-Type", "application/json")
				  .addHeader("x-api-key", APIKey)
				  .build();
		
		Response response = client.newCall(request).execute();
		String res = response.body().string();
		System.out.println(res);
		return res;
	}
}
