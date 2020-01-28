package org.demo.rest.controllers;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.demo.rest.entities.Book;

@Path("/book")
public class BookController {

	private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

	public BookController() {
		super();
		LOGGER.info("BookController : constructor");
	}

	@GET
	@Path("/{id}")
	// @Produces : HTML by default ( Content-Type : text/html;charset=UTF-8 )
//	@Produces("text/plain") //  "text/plain" ==> Book .toString
	@Produces("application/json")
//	@Produces("application/xml")
	public Response printMessage(@PathParam("id") Integer id) {

		LOGGER.info("BookController : @GET : id = " + id);

		Book book = new Book();
		book.setId(id);
		book.setTitle("Germinal");
		book.setAuthor("Zola");

		return Response.status(200).entity(book).build();
	}

}
