package com.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/v1")
@RestController
public class MyController
{

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String get()
	{
		return "cool! it works";
	}

	@GetMapping("/clear")
	public String clearPayeeCache()
	{
		String url = "http://payee-service:9091/actuator/dbProps";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		System.out.println("Calling via Discovery Client.... " + responseEntity.getBody());

		return "success";
	}
}
