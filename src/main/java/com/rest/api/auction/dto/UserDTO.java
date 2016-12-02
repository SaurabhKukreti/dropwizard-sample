package com.rest.api.auction.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UserDTO.Builder.class)
public class UserDTO {
	// Required parameters
	private final String email;
	private final String password;

	// Optional parameters
	private final String firstName;
	private final String lastName;

	public UserDTO() {
		this.email = null;
		this.password = null;
		this.firstName = null;
		this.lastName = null;
	}

	private UserDTO(Builder builder) {
		this.email = builder.email;
		this.password = builder.password;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Builder {
		private String email;
		private String password;
		private String firstName;
		private String lastName;

		public Builder(){}
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDTO build() {
			return new UserDTO(this);
		}
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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