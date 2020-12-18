package com.Covid19DataFetch2.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Covid19DataFetch2.model.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Country> getAllCountries() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countriesList = session.createQuery("from Country").list();
		return countriesList;
	}

	@Override
	public List<Country> getDataForCountry(String countryName, int days) {

		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = entityManager
				.createQuery("SELECT p FROM Country p where country='" + countryName + "' ORDER BY createDate DESC", Country.class)
				.setMaxResults(days).getResultList();
		// SELECT p FROM Country p ORDER BY p.seatNumber

		return countryList;

	}

}
