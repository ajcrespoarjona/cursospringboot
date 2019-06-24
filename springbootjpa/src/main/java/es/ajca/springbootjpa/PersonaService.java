package es.ajca.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository repositorio;
	
	public Iterable<Persona> buscarTodos() {
		
		return repositorio.findAll();
	}

	public void insertar(Persona persona) {
		
		repositorio.save(persona);
	}
	
	public void borrar(Persona persona) {
		
		repositorio.delete(persona);
	}
}
