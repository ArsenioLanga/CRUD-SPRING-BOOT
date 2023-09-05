package mz.com.convidados.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class InMemorySecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)
			throws Exception {
			builder
			.inMemoryAuthentication()
			.withUser("Arsenio").password("123").roles("USER")
			.and()
			.withUser("alexandre").password("123").roles("USER")
			.and()
			.withUser("thiago").password("123").roles("USER");
			}
}
