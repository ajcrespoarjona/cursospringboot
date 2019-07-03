package es.ajca.springbootservidorseguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import es.ajca.springbootservidorseguridad.filters.FiltroJWTAutenticacion;
import es.ajca.springbootservidorseguridad.filters.FiltroLogin;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// si no hacemos este paso, spring security no funcionará correctamente
		PasswordEncoder codificador = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("antonio").password(codificador.encode("miclave"))
				.roles("ADMINISTRADOR");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//es un patrón que viene de ant que es una herramienta clásica
		//es un patrón para urls
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/webapi/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new FiltroLogin("/webapi/login", authenticationManager()),
					UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new FiltroJWTAutenticacion(), UsernamePasswordAuthenticationFilter.class);

	}

}
