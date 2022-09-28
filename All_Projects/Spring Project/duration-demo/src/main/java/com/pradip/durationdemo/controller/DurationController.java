package com.pradip.durationdemo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.durationdemo.model.AmberfloIngestMeterDTO;
import com.pradip.durationdemo.model.AmberfloMeterDTO;
import com.pradip.durationdemo.util.AmberfloUtil;

@RestController
public class DurationController {
	
	
	@Autowired
	private AmberfloUtil amberfloUtil;

	@GetMapping("/getAll")
	public String getAllData() throws IOException {
		return amberfloUtil.getAllMeters();
	}
	
	@PostMapping("/sum/create")
	public String createSum(@RequestBody AmberfloMeterDTO amberfloMeterDTO) throws IOException {
		amberfloMeterDTO.setMeterType("sum_of_all_usage");
		System.out.println("\n\n=> Data from sum request : "+amberfloMeterDTO);
		return amberfloUtil.save(amberfloMeterDTO);
	}

	@PostMapping("/duration/create")
	public String crateDuration(@RequestBody AmberfloMeterDTO amberfloMeterDTO) throws IOException {
		amberfloMeterDTO.setMeterType("duration_snapshot");
		System.out.println("\n\n=> Data from duration request : "+amberfloMeterDTO);
		return amberfloUtil.save(amberfloMeterDTO);
	}
	
	@PostMapping("/max/create")
	public String createMax(@RequestBody AmberfloMeterDTO amberfloMeterDTO) throws IOException {
		amberfloMeterDTO.setMeterType("max_usage");
		System.out.println("\n\n=> Data from max request : "+amberfloMeterDTO);
		return amberfloUtil.save(amberfloMeterDTO);
	}
	
	@PostMapping("/ingest/start")
	public String ingestDurationStart(@RequestBody List<AmberfloIngestMeterDTO> amberfloIngestMeterDTO) throws IOException {
		for(AmberfloIngestMeterDTO amberfloIngestMeterDTO2:amberfloIngestMeterDTO) {
			amberfloIngestMeterDTO2.setMeterTimeInMillis(System.currentTimeMillis());
			amberfloIngestMeterDTO2.setMeterValue(1l);
		}
		System.out.println("\n\n=> Data from request : "+amberfloIngestMeterDTO);
		return amberfloUtil.createCustomerwiseIngestMeter(amberfloIngestMeterDTO);
	}	
	@PostMapping("/ingest/stop")
	public String ingestDurationStop(@RequestBody List<AmberfloIngestMeterDTO> amberfloIngestMeterDTO) throws IOException {
		for(AmberfloIngestMeterDTO amberfloIngestMeterDTO2:amberfloIngestMeterDTO) {
			amberfloIngestMeterDTO2.setMeterTimeInMillis(System.currentTimeMillis());
			amberfloIngestMeterDTO2.setMeterValue(-1l);
		}
		System.out.println("\n\n=> Data from request : "+amberfloIngestMeterDTO);
		return amberfloUtil.createCustomerwiseIngestMeter(amberfloIngestMeterDTO);
	}	
	@PostMapping("/ingest")
	public String ingestMeter(@RequestBody List<AmberfloIngestMeterDTO> amberfloIngestMeterDTO) throws IOException {
		for(AmberfloIngestMeterDTO amberfloIngestMeterDTO2:amberfloIngestMeterDTO) {
			amberfloIngestMeterDTO2.setMeterTimeInMillis(System.currentTimeMillis());
		}
		System.out.println("\n\n=> Data from request : "+amberfloIngestMeterDTO);
		return amberfloUtil.createCustomerwiseIngestMeter(amberfloIngestMeterDTO);
	}	
}
