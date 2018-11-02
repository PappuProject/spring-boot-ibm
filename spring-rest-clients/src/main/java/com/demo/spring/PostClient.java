package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		Emp e = new Emp(303, "Arun", "Chennai", 78000);

		HttpEntity reqData = new HttpEntity(e, headers);

		ResponseEntity<String> response = rt.exchange(
				"http://localhost:8080/emp/save", 
				HttpMethod.POST, 
				reqData,
				String.class);
		
		System.out.println(response.getBody());

	}

}
