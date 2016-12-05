package com.rest.api.auction.util;

import com.rest.api.auction.dto.UserDTO;
import com.rest.api.auction.entity.User;

public final class UserObjectMapperUtil {

	public static UserDTO toUserDTO(User user) {
		UserDTO userDTO = new UserDTO.Builder()
									 .setEmail(user.getEmail())
									 .setFirstName(user.getFirstName())
									 .setLastName(user.getLastName())
									 .build();
		return userDTO;
	}
}
