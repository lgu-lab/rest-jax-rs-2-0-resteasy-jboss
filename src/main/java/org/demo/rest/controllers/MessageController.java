package org.demo.rest.controllers;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageController {

	private static final Logger LOGGER = Logger.getLogger(HelloController.class.getName());

	public MessageController() {
		super();
		LOGGER.info("Message : constructor");
	}

	@GET
	@Produces("text/plain")
	@Path("/")
	public Response get() {
		LOGGER.info("Message : get()");

		String result = "My message ";

		return Response.status(200).entity(result).build();

	}

	@GET
	@Produces("text/plain")
	@Path("/{param}")
	public Response get(@PathParam("param") String param) {

		LOGGER.info("Message : get(param)");
		String result = "My message with param : " + param;

		return Response.status(200).entity(result).build();

	}

}
