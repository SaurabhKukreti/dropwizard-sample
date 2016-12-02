package com.rest.api.auction.service;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.rest.api.auction.entity.User;
import com.rest.api.auction.exception.AuctionerException;

import io.dropwizard.hibernate.AbstractDAO;

public class UserServiceImpl extends AbstractDAO<User> implements UserService {

	private final SessionFactory sessionFactory;

	public UserServiceImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public Optional<User> findByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where email = :email");
		query.setString("email", email);
		return Optional.ofNullable((User) query.uniqueResult());
	}

	public User create(User user) throws AuctionerException {
		String email = user.getEmail();
		Optional<User> _user = findByEmail(email);
		if(_user.isPresent()){
			final AuctionerException ex = new AuctionerException(400, Response.Status.BAD_REQUEST, "Bad request. User already exists: " + email);
			throw ex;
		}
		return persist(user);
	}
}