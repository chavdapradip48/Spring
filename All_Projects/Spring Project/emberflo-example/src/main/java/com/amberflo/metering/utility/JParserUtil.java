package com.amberflo.metering.utility;

import org.springframework.stereotype.Component;

import com.amberflo.metering.exception.CustomException;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JParserUtil {
	
	
	public JsonNode convertStringToJson(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getJsonFactory();
		try
		{
			JsonParser parser = factory.createJsonParser(jsonStr);	    
			JsonNode actualObj = mapper.readTree(parser);	   
			return actualObj;
		}catch(Exception e){
			throw new CustomException(e.toString());
		}
	}
}
