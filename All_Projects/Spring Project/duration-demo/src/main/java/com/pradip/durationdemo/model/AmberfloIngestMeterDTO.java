package com.pradip.durationdemo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AmberfloIngestMeterDTO {

	private String customerId;
	private String meterApiName;
	private Long meterValue;
	private Long meterTimeInMillis;
	private Map<String,String> dimensions;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getMeterApiName() {
		return meterApiName;
	}
	public void setMeterApiName(String meterApiName) {
		this.meterApiName = meterApiName;
	}
	public Long getMeterValue() {
		return meterValue;
	}
	public void setMeterValue(Long meterValue) {
		this.meterValue = meterValue;
	}
	public Long getMeterTimeInMillis() {
		return meterTimeInMillis;
	}
	public void setMeterTimeInMillis(Long meterTimeInMillis) {
		this.meterTimeInMillis = meterTimeInMillis;
	}
	public Map<String, String> getDimensions() {
		return dimensions;
	}
	public void setDimensions(Map<String, String> dimensions) {
		this.dimensions = dimensions;
	}
	@Override
	public String toString() {
		return "AmberfloIngestMeterDTO [customerId=" + customerId + ", meterApiName=" + meterApiName + ", meterValue="
				+ meterValue + ", meterTimeInMillis=" + meterTimeInMillis + ", dimensions=" + dimensions + "]";
	}

}