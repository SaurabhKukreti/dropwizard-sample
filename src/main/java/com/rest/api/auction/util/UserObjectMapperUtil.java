package com.rest.api.auction.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

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
	
	public static User toUser(UserDTO userDTO) throws IllegalAccessException, InvocationTargetException{
		User user = new User();
		BeanUtils.copyProperties(user, userDTO);
		return user;
	}
}
