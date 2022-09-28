package com.amberflo.metering.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amberflo.metering.entity.IngestMeter;
import com.amberflo.metering.utility.CommonHttpMethodUtility;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class IngestService {
	
	@Autowired
	private CommonHttpMethodUtility commonHttpMethodUtility;
	
	public String createCustomerwiseIngestMeter(List<IngestMeter> ingestMeter, String POST_URL) throws IOException {
		String entityStr = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(ingestMeter); 
		String response = commonHttpMethodUtility.amberfloHttpPostMethod(entityStr, POST_URL);
		return response;
	}
}