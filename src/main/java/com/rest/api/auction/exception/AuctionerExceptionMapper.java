package com.rest.api.auction.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.rest.api.auction.dto.AuctionerResponse;
import com.rest.api.auction.dto.ErrorDTO;

public class AuctionerExceptionMapper implements ExceptionMapper<AuctionerException> {
	public Response toResponse(AuctionerException ex) {
		AuctionerResponse<ErrorDTO> response = new AuctionerResponse.Builder<ErrorDTO>()
																	.setCode(ex.getCode())
																	.setHasError(true)
																	.setMessage(ex.getMessage()).build();
		return Response.status(ex.getStatus())
					   .entity(response)
					   .type(MediaType.APPLICATION_JSON)
					   .build();
	}
}