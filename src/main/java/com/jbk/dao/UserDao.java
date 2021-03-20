package com.jbk.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.pojo.User;

@Repository
public class UserDao {
	@Autowired
	SessionFactory factory;

	public boolean checkLoginCredentials(User user) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userEmail", user.getUserEmail()));
		criteria.add(Restrictions.eq("userPassword", user.getUserPassword()));
		User user1 = (User) criteria.uniqueResult();

		if (user1 != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> getUserlist() {
		Session session = factory.openSession();
		List<User> userlist = session.createCriteria(User.class).list();
		return userlist;
	}

	public boolean deleteUser(int id) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("Delete from User where userId=:userId");
		query.setParameter("userId", 6);
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else
			return false;
	}

	public User getDatabyId(int id) {
		System.out.println("getdata by id" + id);
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", id));
		User user = (User) criteria.uniqueResult();
		if (user != null) {
			return user;
		}
		return null;
	}

	public boolean updateUser(User user) {
		System.out.println("update method in dao");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"update User set userName=:name, userEmail=:Email,userPassword=:password,userContact=:contact where userId=:id");

		query.setParameter("name", user.getUserName());
		query.setParameter("Email", user.getUserEmail());
		query.setParameter("password", user.getUserPassword());
		query.setParameter("contact", user.getUserContact());
		query.setParameter("id", user.getUserId());
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean addUser(User user) {

		
		/*
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createSQLQuery(
       "insert into User(userName,userEmail,userPassword,userContact) values(:name,:Email :password,:contact) ");
	
		query.setParameter("name", user.getUserName());
		query.setParameter("Email", user.getUserEmail());
		query.setParameter("password", user.getUserPassword());
		query.setParameter("contact", user.getUserContact());
		query.setParameter("id", user.getUserId());
	
		int i = query.executeUpdate();//
		tx.commit();
		if (i > 0) {
			return true;
		}else{
		
			return false;
		}	
	}
	*/
	
	boolean result=false;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		
		
		User user1 = new User();
		user1.setUserName(user.getUserName());
	   user1.setUserEmail(user.getUserEmail());
	   user1.setUserPassword(user.getUserPassword());
	   user1.setUserContact(user.getUserContact());
		session.save(user);
		tx.commit();
		System.out.println("Data inserted Successfully..!!");

		return true;
	

}
