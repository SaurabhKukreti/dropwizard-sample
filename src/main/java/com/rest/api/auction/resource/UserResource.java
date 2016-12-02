package com.rest.api.auction.resource;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.api.auction.dto.AuctionerResponse;
import com.rest.api.auction.dto.ErrorDTO;
import com.rest.api.auction.dto.UserDTO;
import com.rest.api.auction.entity.User;
import com.rest.api.auction.exception.AuctionerException;
import com.rest.api.auction.service.UserServiceImpl;
import com.rest.api.auction.util.ResponseUtil;
import com.rest.api.auction.util.UserObjectMapperUtil;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	private final UserServiceImpl userService;
	@Context
	HttpServletRequest request;

	public UserResource(UserServiceImpl userService) {
		this.userService = userService;
	}

	@POST
	@UnitOfWork
	@Path("/users")
	public Response createUser(UserDTO userDTO) throws URISyntaxException, AuctionerException {
		User user = null;
		try {
			user = UserObjectMapperUtil.toUser(userDTO);
			user = userService.create(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			final AuctionerException ex = new AuctionerException(400, Response.Status.BAD_REQUEST, "Bad request");
			throw ex;
		} catch (Exception e) {
			final AuctionerException ex = new AuctionerException(500, Response.Status.INTERNAL_SERVER_ERROR, "Try again");
			throw ex;
		}
		URI uri = new URI(request.getRequestURL() + "/" + user.getEmail());
		return Response.status(Response.Status.CREATED)
				   .entity(ResponseUtil.toResonse(201, "User created successfully"))
				   .header("Location", uri.toString())
				   .type(MediaType.APPLICATION_JSON)
				   .build();
	}

	@GET
	@UnitOfWork
	@Path("/users/{email:.+}")
	public UserDTO getUser(@PathParam("email") String email) throws AuctionerException {
		User user = userService.findByEmail(email)
				.orElseThrow(() -> new AuctionerException(404, Response.Status.NOT_FOUND, "User not found: " + email));
		return UserObjectMapperUtil.toUserDTO(user);
	}
}