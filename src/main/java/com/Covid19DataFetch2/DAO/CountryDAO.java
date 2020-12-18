package com.Covid19DataFetch2.DAO;

import java.util.List;

import com.Covid19DataFetch2.model.Country;

public interface CountryDAO {

	public List<Country> getAllCountries();
	
	public List<Country> getDataForCountry(String countryName, int days);
}
