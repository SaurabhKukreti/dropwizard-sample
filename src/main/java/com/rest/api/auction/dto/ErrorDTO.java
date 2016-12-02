package com.rest.api.auction.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ErrorDTO.Builder.class)
public class ErrorDTO {
	private final int code;
	private final String message;

	private ErrorDTO(Builder builder) {
		this.code = builder.code;
		this.message = builder.message;
	}

	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Builder {
		private int code;
		private String message;

		public Builder() {
		}

		public Builder setCode(int code) {
			this.code = code;
			return this;
		}

		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}

		public ErrorDTO build() {
			return new ErrorDTO(this);
		}
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
