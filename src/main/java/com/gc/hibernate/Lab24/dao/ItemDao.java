package com.gc.hibernate.Lab24.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gc.hibernate.Lab24.entity.Item;

@Repository
@Transactional
public class ItemDao {

	@PersistenceContext
	EntityManager eManager;

	public Item findById(int id) {
		return eManager.find(Item.class, id);
	}

	public List<Item> findAll() {
		TypedQuery<Item> namedQuery = eManager.createNamedQuery("find_all_items", Item.class);
		return namedQuery.getResultList();
	}

	public Item update(Item i) {
		return eManager.merge(i);
	}

	public void deleteById(int id) {
		Item i = findById(id);
		eManager.remove(i);
	}

}
