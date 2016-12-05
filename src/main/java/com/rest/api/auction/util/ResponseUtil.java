package com.rest.api.auction.util;

import com.rest.api.auction.dto.AuctionerResponse;

public final class ResponseUtil {

	public static <T> AuctionerResponse<T> toResonse(int code, String message, T data){
		AuctionerResponse<T> response = new AuctionerResponse.Builder<T>()
				.setCode(code)
				.setHasError(false)
				.setData(data)
				.setMessage(message).build();
		return response;
	}
	
}
