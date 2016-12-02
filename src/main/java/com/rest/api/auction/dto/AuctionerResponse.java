package com.rest.api.auction.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = AuctionerResponse.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuctionerResponse<T> {
	private final int code;
	private final String message;
	private final boolean hasError;
	private final T data;

	private AuctionerResponse(Builder<T> builder) {
		this.code = builder.code;
		this.message = builder.message;
		this.hasError = builder.hasError;
		this.data = (T) builder.data;
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Builder<T> {
		private int code;
		private String message;
		private boolean hasError;
		private T data;

		public Builder(){}
		
		public Builder<T> setCode(int code) {
			this.code = code;
			return this;
		}

		public Builder<T> setMessage(String message) {
			this.message = message;
			return this;
		}

		public Builder<T> setHasError(boolean hasError) {
			this.hasError = hasError;
			return this;
		}

		public Builder<T> setData(T data) {
			this.data = data;
			return this;
		}

		public AuctionerResponse<T> build() {
			return new AuctionerResponse<T>(this);
		}
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public boolean isHasError() {
		return hasError;
	}

	public T getData() {
		return data;
	}
	
	/*
	 * public Builder toBuilder() { return new Builder(getEmail(),
	 * getPassword()) .setPhoneNumber(getPhoneNumber())
	 * .setFirstName(getFirstName()) .setLastName(getLastName())
	 * .setBirthDate(getBirthDate()) .setGender(getGender()); }
	 * 
	 * final UserRegistration registration = new
	 * UserRegistration.Builder("email", "password") .setFirstName("Saurabh")
	 * .setLastName("K").build(); final UserRegistration newUser =
	 * registration.toBuilder().setFirstName("Sam").build();
	 */
}