package com.cs.stocktrading.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("trader").password("{noop}trader").roles("TRADER");
		auth.inMemoryAuthentication().
		withUser("admin").password("{noop}admin").roles("ADMIN");
	}

	protected void configure(HttpSecurity http) throws Exception{
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()				
				.antMatchers("order/**").hasRole("TRADER")
				.antMatchers("order/list/**").hasAnyRole("TRADER","ADMIN")
				.antMatchers("trader/**").hasRole("ADMIN")
				.antMatchers("company/**").hasAnyRole("ADMIN")
				.antMatchers("sector/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.httpBasic()
				.and()
				.csrf().disable()
				.headers().frameOptions().disable();
	}
}
