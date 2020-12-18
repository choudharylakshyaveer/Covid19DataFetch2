package com.Covid19DataFetch2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Covid19DataFetch2.model.Country;
import com.Covid19DataFetch2.model.World;
import com.Covid19DataFetch2.service.CountryService;
import com.Covid19DataFetch2.service.WorldService;

@Controller
public class CovidController {

	@Autowired
	CountryService countryService;
	
	@Autowired
	WorldService worldService;
	
	/*
	@RequestMapping(value="/getCountryHistory/{days}/{countryName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Country>> getCountryData(@PathVariable("countryName") String countryName,
								@PathVariable("days") String days)
	{
		int numberOfDays = Integer.parseInt(days);
		List<Country> countryList = countryService.getCountryData(countryName, numberOfDays);
		return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
		
	}
	http://localhost:8080/getCountryHistory?countryName=UK&days=7
	http://localhost:8080/getCountryHistory/3
	/getCountryHistory/{varname}
	*/
	
	@RequestMapping(value="/getCountryHistory", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<List<Country>> getCountryData(@RequestParam("countryName") String countryName,
			@RequestParam("days") String days)
	{
	int numberOfDays = Integer.parseInt(days);
	List<Country> countryList = countryService.getCountryData(countryName, numberOfDays);
	return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
	
	}
	
	///getWorldHistory/7
	@RequestMapping(value="/getWorldHistory/{days}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<World>> getWorldData(@PathVariable("days") String days)
	{
		int numberOfDays = Integer.parseInt(days);
		List<World> world = worldService.getWorldData(numberOfDays);
		return new ResponseEntity<List<World>>(world, HttpStatus.OK);
	}
}
