package com.rest.api.auction.exception;

import javax.ws.rs.core.Response;

public class AuctionerException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2262812408478748939L;

	private int code;
	private Response.Status status;

	public AuctionerException() {
		this(500, Response.Status.INTERNAL_SERVER_ERROR);
	}

	public AuctionerException(int code, Response.Status status) {
		this(code, status, "Error while processing the request", null);
	}

	public AuctionerException(int code, Response.Status status, String message) {
		this(code, status, message, null);
	}

	public AuctionerException(int code, Response.Status status, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
		this.status = status;
	}

	public int getCode() {
		return code;
	}
	
	public Response.Status getStatus(){
		return status;
	}
}