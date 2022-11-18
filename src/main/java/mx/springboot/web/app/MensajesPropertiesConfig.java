package mx.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:/mensajes.properties")	//Volver accesible nuestro archivo mensajes.properties dentro de Spring
})
public class MensajesPropertiesConfig {

}
