package es.ajca.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaController {

	@RequestMapping("/hola")
	public String hola() {
		
		//esta es la vista de retorno que necesitamos
		return "mensaje";
		
	}
}
