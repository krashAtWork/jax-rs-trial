package com.rest;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.service.serviceImpl;
import com.service.serviceInf;
import com.userDto.UserDto;

@Path("/product")

public class Trial1 {
	UserDto user;
	serviceInf userServe;
	java.util.List<String> results;

	@POST
	@Path("/add")
	public Response addUser(@FormParam("username") String username)
	// @FormParam("name") String name,
	// @FormParam("price") float price)
	{
		if (username.isEmpty()) {
			System.out.println("username is empty");
		}
		user = new UserDto();
		user.setUsername(username);
		userServe = new serviceImpl();
		// boolean saved =userServe.addUser(user);

		try {
			results = userServe.addUser(user);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("duplicate user");
		}
		return Response.status(200).entity("Username added successfuly! <br> +Username: " + username + results).build();

	}
}