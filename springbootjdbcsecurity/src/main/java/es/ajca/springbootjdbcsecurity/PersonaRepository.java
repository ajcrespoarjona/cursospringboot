package es.ajca.springbootjdbcsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaRepository {

	@Autowired
	private JdbcTemplate plantilla;

	public List<Persona> buscarTodos() {

		return plantilla.query("select * from Personas", new PersonaMapper());
	}

	public void borrar(Persona persona) {

		// esto es más sencillo que jdbc plano
		plantilla.update("delete from Personas where nombre=?", persona.getNombre());
	}

	public void insertar(Persona persona) {
		plantilla.update("insert into Personas(nombre,apellidos,edad) values (?,?,?)", persona.getNombre(),
				persona.getApellidos(), persona.getEdad());
		;
	}

}
