package com.service;

import javax.persistence.Query;
import java.util.List;

// jarFiles
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.userDto.UserDto;;

public class serviceImpl implements serviceInf {

	@Override
	public List<String> addUser(UserDto user) {
		
		Configuration cfg = new Configuration();// opening and creating
												// configuration instance
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// user.setUsername(user.username);
		Transaction tx = session.beginTransaction();
		 session.save(user);	
		
		 String hql = "select u.username from UserDto u";
			Query query = session.createQuery(hql);
			List<String> results = query.getResultList();
			System.out.println(results);
			for (String res : results) {
				System.out.println(res);
			}


		tx.commit();
		session.close();
		factory.close();
		return results;
		
	}/*

	@Override
	public List<String> addUser(UserDto user) {

		*//************************************************//*
		Configuration cfg = new Configuration();// opening and creating
												// configuration instance
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		*//************************************************//*

		*//***********************************************//*
		// user.setUsername(user.username);
		Transaction tx = session.beginTransaction();
		session.save(user);
		*//***********************************************//*

		*//**********************************************//*
		String hql = "select u.username from UserDto u";
		Query query = session.createQuery(hql);
		List<String> results = query.getResultList();
		System.out.println(results);
		for (String res : results) {
			System.out.println(res);

		}
		*//**********************************************//*

		tx.commit();
		session.close();
		factory.close();
		return results;

	}

*/}
