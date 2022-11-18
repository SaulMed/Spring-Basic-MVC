package mx.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@Value("${params.titulo.requestParam.value}")	//Acceder a data dentro de mensajes.properties
	private String titleRequestParam;
	
	@Value("${params.titulo.httpServletRequest.value}")
	private String titleHttpServletRequest;

	@GetMapping({ "/", "" })
	public String enviar(Model modelo) {
		
		modelo.addAttribute("titulo", titleRequestParam);
		
		return "params/enviar";
	}

	@GetMapping({ "/obtener" })
	public String game(Model modelo, @RequestParam(required = false, defaultValue = "Pepsiman") String titleGame,
			@RequestParam(required = false, defaultValue = "Adventure") String category,
			@RequestParam(required = false, defaultValue = "150") Integer price) {
		
		modelo.addAttribute("titulo", titleRequestParam);
		modelo.addAttribute("summary", "El juego '" + titleGame + "' entra en la categoria de '" + category
				+ "' y su precio es de '$" + price + "' pesos.");
		
		return "params/obtener";
	}

	@GetMapping("/obtener-servlet")
	public String game(Model modelo, HttpServletRequest request) {
		String titleGame = request.getParameter("titleGame");
		String category = request.getParameter("category");
		Integer price = null;
		
		try {
			price = Integer.parseInt(request.getParameter("price"));
		}catch(NumberFormatException e) {
			price = 0;
		}
		
		modelo.addAttribute("titulo", titleHttpServletRequest);
		modelo.addAttribute("summary", "El juego '" + titleGame + "' entra en la categoria de '" + category
				+ "' y su precio es de '$" + price + "' pesos.");
		return "params/obtener";
	}

}
