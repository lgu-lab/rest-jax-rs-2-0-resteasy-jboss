package org.demo.rest.controllers;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloController {

	private static final Logger LOGGER = Logger.getLogger(HelloController.class.getName());

	public HelloController() {
		super();
		LOGGER.info("Hello : constructor");
	}

	@GET
	@Path("/")
	// @Produces : HTML by default ( Content-Type : text/html;charset=UTF-8 )
	@Produces("text/plain")
//	@Produces("application/json")
//	@Produces("application/xml")
	public Response printMessage() {

		LOGGER.info("Hello (no name)" );
		String result = "Hello ";

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/{name}")
	// @Produces : HTML by default ( Content-Type : text/html;charset=UTF-8 )
	@Produces("text/plain")
//	@Produces("application/json")
//	@Produces("application/xml")
	public Response printMessage(@PathParam("name") String name) {

		LOGGER.info("Hello : @GET : name = " + name);
		String result = "Hello " + name;

		return Response.status(200).entity(result).build();

	}

}
