package es.ajca.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webapi")
public class PersonaRestController {

	@Autowired
	PersonaRepository repositorio;

	@GetMapping("/personas")
	public Iterable<Persona> buscarTodos() {

		return repositorio.findAll();
	}
}
