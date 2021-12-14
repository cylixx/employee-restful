package com.softland.employeeresful;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}password").roles("USER")
			.and()
			.withUser("cylixx").password("{noop}cylixx").roles("USER", "ADMIN");
	}
	
	//Another way to solve the problem:  There is no PasswordEncoder mapped for the id "null"
//	@SuppressWarnings("deprecation")
//	@Bean
//    public UserDetailsService userDetailsService() {
//		User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password").roles("USER").build());
//        manager.createUser(users.username("cylixx").password("cylixx").roles("USER", "ADMIN").build());
//        return manager;
//    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
//		http
//			.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin().and()
//			.httpBasic();
		
//		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER")
//			.and().formLogin().loginPage("/login.jsp")
//			.failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
//			.permitAll().and().logout()
//			.logoutSuccessUrl("/employee");
		
		http
			.csrf().ignoringAntMatchers("/h2-console/**").disable()
			.headers().frameOptions().disable()  //to see h2-console frame
			.and()
			.authorizeRequests()
			//.antMatchers("/employee").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/employee/**").authenticated()
			.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
			//.and().requestCache().requestCache(new NullRequestCache())
			.and().formLogin() 
			.and().httpBasic();
			
//		http
//        .authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
//        .requestCache()
//        .requestCache(new NullRequestCache())
//        .and()
//        .httpBasic();
		
	}
}
