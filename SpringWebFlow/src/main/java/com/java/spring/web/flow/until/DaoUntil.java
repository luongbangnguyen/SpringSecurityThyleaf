package com.java.spring.web.flow.until;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class DaoUntil {
	
	@PersistenceContext
	private EntityManager em;
	
	public DaoUntil() {
		entity = em;
	}
	
	
	private static EntityManager entity;
	
	public static EntityManager getEntity(){
		return entity;
	}
}
