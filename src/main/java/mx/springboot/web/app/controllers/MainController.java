package mx.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		//Redirecciona a la otra ruta (Cambia la URL) , se pierde la data al reiniciar la request a otra pagina
//		return "redirect:/app";	
		//forward carga la pagina y trabaja con rutas propias de controladores (No cambia la URL). no pierde la data , no reinicia el request
		return "forward:/app";		
	}
}
