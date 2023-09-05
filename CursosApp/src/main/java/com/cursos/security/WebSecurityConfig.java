package com.cursos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

//@Configuration
public class WebSecurityConfig{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)
			throws Exception {
			builder
			.inMemoryAuthentication()
			.withUser("Arsenio").password("123-4567-89AAA-55-OI").roles("USER")
			.and()
			.withUser("alexandre").password("123").roles("ADMIN")
			.and()
			.withUser("thiago").password("123").roles("USER");
			}
}
