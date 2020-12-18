package com.Covid19DataFetch2.scheduler;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.Covid19DataFetch2.model.Country;
import com.Covid19DataFetch2.model.World;

@Component
@EnableTransactionManagement
@Transactional
public class Scheduler {

	@Autowired(required = true)
	RestTemplate restTemplate;

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
		// sf.close();
	}


	@PersistenceContext
	private EntityManager entityManager;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// @Scheduled(fixedRate = 4000)
	//@Scheduled(cron = "0 32 8 * * *")
	@Bean
	//@Lazy
	public void scheduledCountryApi() // -> This method showing error
	{
		ResponseEntity<Country[]> responseEntity = restTemplate
				.getForEntity("https://coronavirus-19-api.herokuapp.com/countries", Country[].class);

		Session session = null;

		List<Country> list = Arrays.asList(responseEntity.getBody());
		for (int i = 0; i < list.size(); i++) 
		{
			list.get(i).setCreateDate(new Date());
			try {
				session = this.sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
				session = sessionFactory.openSession();
			}
			SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = objSDF.format(new Date());
			System.out.println(formattedDate);
			String query = "SELECT p FROM Country p where createDate='"+ formattedDate + "' AND country='"+ list.get(i).getCountry() +"'";
			Query d = entityManager.createQuery(query);
			int a = d.getResultList().size();
			if(d.getResultList().size()==0)
			{
				session.save(list.get(i));
			}
			
		}

		// session.beginTransaction();

		if (!session.getTransaction().isActive()) {
			session.getTransaction().commit();
		}
		session.flush();
		session.clear();
		// session.close();

		System.out.println(list);
	}

	//@Scheduled(fixedRate = 4000)
	//@Scheduled(cron = "0 30 8 * * *)
	@Bean
	//@Lazy
	public void scheduledWorldApi() 
	{
		World result = restTemplate.getForObject("https://coronavirus-19-api.herokuapp.com/all", World.class);

		Session session = null;

		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = objSDF.format(new Date());
		
		System.out.println(formattedDate);
		String query = "SELECT p FROM World p where createDate='"+ formattedDate + "'";
		Query d = entityManager.createQuery(query);
		int a = d.getResultList().size();
		
		if(a==0)
		{
			session.save(result);
		}
		if (!session.getTransaction().isActive()) {
			session.getTransaction().commit();
		}
		session.flush();
		session.clear();
	}
	
	
	
	/*
	//@Scheduled(cron = "0 29 11 * * *")
	@Bean
	//@Lazy
	public void scheduleBothApi()
	{
		World result = restTemplate.getForObject("https://coronavirus-19-api.herokuapp.com/all", World.class);
		ResponseEntity<Country[]> responseEntity = restTemplate.getForEntity("https://coronavirus-19-api.herokuapp.com/countries", Country[].class);

		Session session = null;

		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		
		List<Country> list = Arrays.asList(responseEntity.getBody());
		for (int i = 0; i < list.size(); i++) {
			try {
				session = this.sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
				session = sessionFactory.openSession();
			}
			session.save(list.get(i));
		}
		

		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

		session.save(result);

		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().commit();
		}
		session.flush();
		session.clear();
	}
*/
}
