package com.mymovies.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.dto.CastDTO;
import com.mymovies.service.ICastService;

@Controller
public class CastController implements ICastController {
	
	@Autowired
	private ICastService castService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CastController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<CastDTO> getAPI_Cast(@PathVariable String movie_id) {

		LOGGER.info("@Get Cast, id: " + movie_id);

		ArrayList<CastDTO> listOfCast = null;

		try {
			listOfCast = castService.getAPI_Cast(movie_id);
		} catch (Exception e) {
			LOGGER.error("ERROR: " + e);
		}

		return listOfCast;

	}

}
