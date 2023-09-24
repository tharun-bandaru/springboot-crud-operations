package com.tcs.crud.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception{

		http.authorizeHttpRequests()
		.antMatchers("/deleteEmployee")
		.hasAnyAuthority("ROLE_ADMIN")

		.antMatchers("/addEmployee","/editEmployee","/deleteEmployee")
		.authenticated()

		.antMatchers("/index","/listEmployees")
		.permitAll()


		.and()
		.formLogin();

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/logoutUser");
		return	http.build();
	}

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() {
	 * 
	 * UserDetails user1=User.withUsername("tharun") .password("tharun123")
	 * .authorities("admin") .build();
	 * 
	 * UserDetails user2=User.withUsername("sai") .password("sai123")
	 * .authorities("user") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user1,user2);
	 * 
	 * }
	 */

	@Bean
	public UserDetailsManager userDetailsService(DataSource datasource) {

		return new JdbcUserDetailsManager(datasource);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}
}
