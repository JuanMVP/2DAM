package com.salesianostriana.apimonumentos.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class AEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("salesianos-triana");
		super.afterPropertiesSet();
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
			response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().println("¡Alerta! Error 401"+authException.getMessage());
	}
	
	

}