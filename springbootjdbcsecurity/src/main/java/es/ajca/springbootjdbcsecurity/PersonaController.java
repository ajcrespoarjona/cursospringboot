package es.ajca.springbootjdbcsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	PersonaService miservicio;

	@RequestMapping("/")
	public String root() {
		return "redirect:personas/lista";
	}

	@RequestMapping("/personas/lista")
	public String mostrarPersonas(Model modelo) {

		modelo.addAttribute("lista", miservicio.buscarTodos());
		return "personas/lista";
	}

	@RequestMapping("/personas/formularioinsertar")
	public String formularioInsertar() {

		return "personas/formularioinsertar.html";
	}

	@RequestMapping("/personas/insertar")
	public String insertar(Persona persona, Model modelo) {

		miservicio.insertar(persona);
		modelo.addAttribute("lista", miservicio.buscarTodos());

		return "personas/lista.html";
	}

	@RequestMapping("/personas/borrar")
	public String borrar(@RequestParam("nombre") String nombre, Model modelo) {

		Persona persona = new Persona(nombre);

		miservicio.borrar(persona);
		modelo.addAttribute("lista", miservicio.buscarTodos());

		return "personas/lista.html";
	}

}
