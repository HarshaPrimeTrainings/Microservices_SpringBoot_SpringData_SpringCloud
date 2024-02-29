package com.training.userservicewithhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public String saveUser(UserDetails user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return "User Saved";
	}

	public List<UserDetails> getAllUsers(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<UserDetails> ul = session.createQuery("FROM UserDetails").list();
		session.close();
		return ul;
	}
	
	
	public UserDetails getUsrById(Integer uid) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserDetails user = session.load(UserDetails.class, uid);
		return user;
	}
	
	public String deleteuser(Integer uid) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserDetails user = session.load(UserDetails.class, uid);
		session.delete(user);
		transaction.commit();
		session.close();
		return "User Deleted";
	}
	
	
}
