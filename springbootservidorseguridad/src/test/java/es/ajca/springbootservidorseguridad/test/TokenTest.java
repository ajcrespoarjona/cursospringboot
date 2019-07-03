package es.ajca.springbootservidorseguridad.test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import es.ajca.springbootservidorseguridad.servicios.TokenService;


public class TokenTest {

	@Test
	public void testCrearToken() throws ParseException {
		
		TokenService servicio = new TokenService();
		DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		
		String token = servicio.creaToken("antonio1", "superclave", formateador.parse("01/03/2020"));
		
		System.out.println(token);
		
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbmlvMSIsImV4cCI6MTU4MzAxNzIwMH0.8ZLhj1LYkDXfuirSEJnRoqVC26M83QLgE8u29k3FuxE", token);
		
				
	}
	
	@Test
	public void testLeerTokenUsuario() {
		
		TokenService servicio = new TokenService();
		String usuario = servicio.leeToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbnRvbmlvMSIsImV4cCI6MTU4MzAxNzIwMH0.8ZLhj1LYkDXfuirSEJnRoqVC26M83QLgE8u29k3FuxE", "superclave");
		
		assertEquals("antonio1", usuario);
	
	}

}