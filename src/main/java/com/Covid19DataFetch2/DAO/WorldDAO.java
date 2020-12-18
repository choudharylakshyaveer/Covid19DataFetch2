package com.Covid19DataFetch2.DAO;

import java.util.List;

import com.Covid19DataFetch2.model.World;

public interface WorldDAO {

	public List<World> getAllWorld(int days);

}
