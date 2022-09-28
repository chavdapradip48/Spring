package com.amberflo.metering.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ErrorResponse {
	  
	private int statusCode;
	private Date timestamp;
	private String message;
	
	public ErrorResponse(int statusCode, Date timestamp, String message) {
		super();
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
	}	

	
}
