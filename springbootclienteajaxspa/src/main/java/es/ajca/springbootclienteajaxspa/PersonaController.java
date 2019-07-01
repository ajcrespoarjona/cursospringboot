package es.ajca.springbootclienteajaxspa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@RequestMapping("/lista")
	public String mostrarPersonas(Model modelo) {
		
		return "personas/lista";
	}	

}
