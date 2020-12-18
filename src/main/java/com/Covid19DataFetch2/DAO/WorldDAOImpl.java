package com.Covid19DataFetch2.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Covid19DataFetch2.model.Country;
import com.Covid19DataFetch2.model.World;

@Repository
public class WorldDAOImpl implements WorldDAO {
	@Autowired
	SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<World> getAllWorld(int days) {
		Session session = this.sessionFactory.getCurrentSession();
		List<World> worldList = entityManager.createQuery("SELECT p FROM World p ORDER BY createDate DESC", World.class)
				.setMaxResults(days).getResultList();
		return worldList;
	}

}
