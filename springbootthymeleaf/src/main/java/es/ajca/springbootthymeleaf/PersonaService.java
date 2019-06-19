package es.ajca.springbootthymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {
	
	static List<Persona> lista = new ArrayList<>();
	
	static {
		Persona p1 = new Persona("pepe","perez",30);
		Persona p2 = new Persona("ana","sanchez",25);
		lista.add(p1);
		lista.add(p2);
	}
	
	public List<Persona> buscarTodos() {
		return lista;
	}

}
