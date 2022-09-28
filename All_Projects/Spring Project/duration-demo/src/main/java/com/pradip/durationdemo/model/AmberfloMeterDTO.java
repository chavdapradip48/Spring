package com.pradip.durationdemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AmberfloMeterDTO {

	private String id;
	private String label;
	private String meterApiName;
	private String meterType;
	private String description;
	private LockingStatus lockingStatus;
	private List<String> dimensions;
	private String eventIdDimension;
	
	public String getEventIdDimension() {
		return eventIdDimension;
	}

	public void setEventIdDimension(String eventIdDimension) {
		this.eventIdDimension = eventIdDimension;
	}

	public enum MeterType {
		sum_of_all_usage,
		max_usage,
		running_total,
		event_duration,
		unique_count
	}
	
	public enum LockingStatus {
		open,
		close_to_changes,
		close_to_deletion,
		deprecated
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMeterApiName() {
		return meterApiName;
	}

	public void setMeterApiName(String meterApiName) {
		this.meterApiName = meterApiName;
	}

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LockingStatus getLockingStatus() {
		return lockingStatus;
	}

	public void setLockingStatus(LockingStatus lockingStatus) {
		this.lockingStatus = lockingStatus;
	}

	public List<String> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<String> dimensions) {
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "AmberfloMeterDTO [id=" + id + ", label=" + label + ", meterApiName=" + meterApiName + ", meterType="
				+ meterType + ", description=" + description + ", lockingStatus=" + lockingStatus + ", dimensions="
				+ dimensions + ", eventIdDimension=" + eventIdDimension + "]";
	}



}	