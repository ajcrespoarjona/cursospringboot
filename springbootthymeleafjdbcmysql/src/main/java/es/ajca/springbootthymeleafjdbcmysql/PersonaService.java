package es.ajca.springbootthymeleafjdbcmysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository repositorio;
	
	public List<Persona> buscarTodos() {
		
		return repositorio.buscarTodos();
	}

	public void insertar(Persona persona) {
		
		repositorio.insertar(persona);
	}
	
	public void borrar(Persona persona) {
		
		repositorio.borrar(persona);
	}
}
