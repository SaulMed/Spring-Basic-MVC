package mx.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/users")
public class UsuarioController {
	
	@RequestMapping(value = "/perfil")
	public String Usuarios(Model modelo) {
		
		// Instancia del modelo (clase POJO)
		Usuario user = new Usuario(); 
		
		// Llenado de user
		user.setNombre("Saul"); 
		user.setApellidos("Medina");
		user.setEdad(25);
		user.setEmail("saul@gmail.com");
		
		// Carga de atributos al modelo
		modelo.addAttribute("usuario", user); 
		modelo.addAttribute("resumen", "Resumen Perfil: ".concat(user.getNombre() + " " + user.getApellidos()));
		
		// Retornar template
		return "perfil"; 
	}

	@GetMapping("/lista")
	public String Listar(Model modelo) {
		// Creacion de Lista
//		VERSION 1 , usando ArrayList<>();
//		List<Usuario> listaUsr = new ArrayList<>();


		// Poblar Lista directamente (Sin necesidad de compartir la lista a otras vistas)
//		VERSION 1, usando ArrayList<>();
//		listaUsr.add(new Usuario("Ultra", "Lord", 50, "ultralord@correo.com"));
//		listaUsr.add(new Usuario("Temmo", "Gonzales", 25, "teemote@correo.com"));
//		listaUsr.add(new Usuario("Fernanda", "Jazmin", 15, "girasol@correo.com"));

		// Cargar data al modelo
		modelo.addAttribute("titulo", "Listado de Usuarios");
//		modelo.addAttribute("usuariosLista", listaUsr);

		// Template a retornar
		return "listar";
	}
	
	@ModelAttribute("listUsers")	//Volver accesible nuestro atributo "listUsers" a TODO EL CONTROLADOR
	public List<Usuario> poblarLista(){
		List<Usuario> listaUsr = Arrays.asList(
				new Usuario("Ultra", "Lord", 50, "ultralord@correo.com"),
				new Usuario("Temmo", "Gonzales", 25, "teemote@correo.com"),
				new Usuario("test", "test", 35, "test@correo.com"),
				new Usuario("Diego", "Tornado", 28, "tornado@tormenta.com")
				); 
		return listaUsr;
	}

}
