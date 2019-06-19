package es.ajca.springbootthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	PersonaService miservicio;

	@RequestMapping("/lista")
	public String mostrarPersonas(Model modelo) {

		modelo.addAttribute("lista", miservicio.buscarTodos());

		return "personas/lista";

	}
}
