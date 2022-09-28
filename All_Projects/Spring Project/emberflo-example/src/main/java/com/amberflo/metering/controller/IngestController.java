package com.amberflo.metering.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amberflo.metering.entity.IngestMeter;
import com.amberflo.metering.service.IngestService;
import com.amberflo.metering.utility.JParserUtil;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class IngestController {
	final static Logger logger = LoggerFactory.getLogger(IngestController.class);
	
	@Autowired
	private IngestService ingestService;
	@Autowired
	private JParserUtil jParserUtil;
	
	@Value("${amberflo.ingest.post_method}")
	private String INGEST_POST_URL;
	
	@PostMapping("/ingest")
	public ResponseEntity<?> createMeter(@RequestBody List<IngestMeter> ingestMeter) {
		try {
			String response = ingestService.createCustomerwiseIngestMeter(ingestMeter, INGEST_POST_URL);
			JsonNode jsonRes = jParserUtil.convertStringToJson(response);
			logger.info("Success Ingest meter ...");
	    	
			return new ResponseEntity<>(jsonRes, HttpStatus.CREATED);
	    } catch (Exception e) {
	    	logger.info("Error :", e);
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}