package mx.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableController {

	@GetMapping({ "/", "" })
	public String enviar(Model modelo) {
		modelo.addAttribute("titulo", "Enviar Parametros URL / @PathVariable - Movies");
		modelo.addAttribute("atributo","Soy un atributo del modelo");
		return "variables/enviar";
	}

	@GetMapping("/value/{texto}") // Soporta un solo parametro
	public String variable(@PathVariable String texto, Model modelo) {
		modelo.addAttribute("titulo", "Recibir parametros de la ruta con @PathVariable");
		modelo.addAttribute("summary", "El texto enviado es: " + texto);
		return "variables/obtener";
	}

	@GetMapping("/values/{texto}/{numero}") // Soporta 2 parametros , String e Integer
	public String variable(@PathVariable String texto, @PathVariable Integer numero, Model modelo) {
		modelo.addAttribute("titulo", "Recibir parametros de la ruta con @PathVariable");
		modelo.addAttribute("summary", "El texto recibido es: " + texto + ", y el numero es: " + numero);
		return "variables/obtener";
	}

}
