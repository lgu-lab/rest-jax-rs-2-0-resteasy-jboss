package org.demo.rest;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.demo.rest.controllers.BookController;
import org.demo.rest.controllers.HelloController;
import org.demo.rest.controllers.MessageController;

@ApplicationPath(value = "/api")
public class ApplicationConfig extends Application {

	private static final Logger LOGGER = Logger.getLogger(ApplicationConfig.class.getName());
	
	private final Set<Class<?>> restClasses = new HashSet<>();
	
	private final Set<Object> restSingletons = new HashSet<>();
	
	
	public ApplicationConfig() {
		super();
		LOGGER.info("ApplicationConfig : constructor");
		
		//--- Controllers (Singleton)
		restSingletons.add(new HelloController());
		
		//--- Controllers (Not Singleton)
		restClasses.add(MessageController.class);
		restClasses.add(BookController.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		LOGGER.info("ApplicationConfig : getClasses() : size = " + restClasses.size() );
		return restClasses;
	}

	@Override
	public Set<Object> getSingletons() {
		LOGGER.info("ApplicationConfig : getSingletons() : size = " + restSingletons.size() );
		return restSingletons;
	}

	@Override
	public Map<String, Object> getProperties() {
		LOGGER.info("ApplicationConfig : getProperties()");
		return super.getProperties();
	}

	
}
