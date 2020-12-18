package com.Covid19DataFetch2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Covid19DataFetch2.DAO.WorldDAO;
import com.Covid19DataFetch2.model.World;

@Service
public class WorldService {

	@Autowired
	WorldDAO worldDAO;
	
	@Transactional
	public List<World> getWorldData(int days)
	{
		return worldDAO.getAllWorld(days);
	}
}
