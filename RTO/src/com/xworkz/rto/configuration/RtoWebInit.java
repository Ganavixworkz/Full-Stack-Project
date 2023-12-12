package com.xworkz.rto.configuration;

import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RtoWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]  {RtoConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
