package com.gc.hibernate.Lab24.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gc.hibernate.Lab24.entity.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager eManager;

	public User findById(int id) {

		return eManager.find(User.class, id);
		
	}
	
	

}
