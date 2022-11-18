package mx.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${index.title.value}")	//Inyeccion de valor desde el application.properties a estas variables
	private String titleIndex;
	
	@Value("${index.saludo.value}")
	private String saludoIndex;

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping({ "/index", "/", "" }) // Mapeo de rutas
	public String Index(Model modelo) {
		modelo.addAttribute("titulo", titleIndex);
		modelo.addAttribute("saludo", saludoIndex);
		return "index";
	}

//	@ModelAttribute("listUsers")	//Volver accesible nuestro atributo "listUsers" a TODO EL CONTORLADOR
//	public List<Usuario> poblarLista(){
//		List<Usuario> listaUsr = Arrays.asList(
//				new Usuario("Ultra", "Lord", 50, "ultralord@correo.com"),
//				new Usuario("Temmo", "Gonzales", 25, "teemote@correo.com"),
//				new Usuario("test", "test", 35, "test@correo.com"),
//				new Usuario("Diego", "Tornado", 28, "tornado@tormenta.com")
//				); 
//		return listaUsr;
//	}


}
