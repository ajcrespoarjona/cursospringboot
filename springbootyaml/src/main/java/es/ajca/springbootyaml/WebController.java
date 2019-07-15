package es.ajca.springbootyaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebController {
	
	@Autowired
	ConfiguradorProperties propiedades;
	
	@RequestMapping("/misdatos")
	public String mostrarDatos(Model modelo) {
		
		modelo.addAttribute("twitter", propiedades.getTwitter());
		modelo.addAttribute("web", propiedades.getWeb());
		
		return "web/datos";
		
	}

}
