package com.Covid19DataFetch2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Covid19DataFetch2.DAO.CountryDAO;
import com.Covid19DataFetch2.model.Country;

@Service
public class CountryService {
	
	@Autowired
	CountryDAO countryDAO;
	
	@Transactional
	public List<Country> getCountryData(String countryName, int days)
	{
		return countryDAO.getDataForCountry(countryName, days);
	}
	

}
