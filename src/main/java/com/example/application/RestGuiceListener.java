package com.example.application;

import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletContext;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import com.google.inject.Module;
import com.example.module.GuiceModule;

public class RestGuiceListener extends GuiceResteasyBootstrapServletContextListener{
	
	@Override
	protected List<Module> getModules(ServletContext context) {
		return Arrays.asList(new GuiceModule());
	}

}