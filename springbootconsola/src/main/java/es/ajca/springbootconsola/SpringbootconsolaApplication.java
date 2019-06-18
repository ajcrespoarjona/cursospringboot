package es.ajca.springbootconsola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootconsolaApplication implements CommandLineRunner{

	@Autowired
	Servicio miServicio;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootconsolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(miServicio.mensaje());
	}

}
