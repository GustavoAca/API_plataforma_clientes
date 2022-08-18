package com.bemprotege.backend.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/**
		 * O objeto auth registra e cria uma nova instância do objeto userDetailsService
		 * da interface UserDetailsService implementada na Classe UserDetailsServiceImpl
		 * para recuperar os dados dos usuários gravados no Banco de dados.
		 */

		auth.userDetailsService(userDetailsService);

		auth.inMemoryAuthentication().withUser("EliomarGustavo").password(passwordEncoder().encode("umadesp02"))
				.authorities("ROLE_USER");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
				http.authorizeRequests()
				.antMatchers("/usuarios/logar").permitAll()
				.antMatchers("/usuarios/cadastrar")
				.permitAll().and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated()
				.and().httpBasic().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.headers().frameOptions().disable().and()
				.csrf().ignoringAntMatchers("/h2-console/**").and()
				.cors().disable();
	}
}
