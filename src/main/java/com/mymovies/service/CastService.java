package com.mymovies.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.CastDTO;
import com.mymovies.dto.CreditDTO;

@Service
public class CastService implements ICastService {

	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(CastService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ArrayList<CastDTO> getAPI_Cast(String movie_id) {

		CreditDTO credits = null;
		
		try {
			credits = restTemplate.getForObject(BASE_URL+movie_id+"/credits"+API_KEY+Language, CreditDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Cast: " + e);
		}

		return credits.getCast();

	}

}
