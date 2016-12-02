package com.rest.api.auction.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3406204227456794218L;
	private static final String default_message = "User does not exist.";
	
	public UserNotFoundException() {
		super(default_message);
	}
}
