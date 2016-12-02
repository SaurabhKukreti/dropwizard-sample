package com.rest.api.auction.service;

import java.util.Optional;

import com.rest.api.auction.entity.User;
import com.rest.api.auction.exception.AuctionerException;

public interface UserService {
	User create(User user) throws AuctionerException;

	Optional<User> findByEmail(String email);
}
