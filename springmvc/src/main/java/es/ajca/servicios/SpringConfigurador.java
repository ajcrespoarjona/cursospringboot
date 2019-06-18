package es.ajca.servicios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("es.ajca.servicios")
@ComponentScan("es.ajca.controllers")
public class SpringConfigurador {
	
	@Bean
	public ViewResolver viewResolver() {
		
		//esto nos configura un resolutor de vistas para ficheros jsp
		//que es uno de los resolutores más clasicos
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setExposeContextBeansAsAttributes(true);
		viewResolver.setPrefix("/WEB-INF/vistas/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	

}
