package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {

	public static void main(String[] args) {
		
		RestTemplate rt= new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity reqData=new HttpEntity(headers);
		
		ResponseEntity<String> response=
				rt.exchange("http://localhost:8080/emp/104", 
						HttpMethod.GET, reqData, String.class);
		
		System.out.println(response.getBody());
	}

}
