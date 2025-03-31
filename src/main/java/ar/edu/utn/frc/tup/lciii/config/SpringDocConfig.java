package ar.edu.utn.frc.tup.lciii.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Value("${app.url}") private String url;
    @Value("${app.dev-name}") private String devName;
    @Value("${app.dev-email}") private String devEmail;
    //Utilidades @Bean: Esta anotacion se utiliza para indicar que un metodo en una clase de
    // configuracion de Spring debe ser tratado como un bean y gestionado por el contenedor de Spring
    @Bean
    public OpenAPI openApI(
            //Utilidades: @Value: Esta anotacion se utiliza para inyectar valores de propiedades en los
            //              campos de una clase. Permite que las propiedades  definidas en un archivo
            //              de configuracion(como aplication.properties) sean inyectadas en las variables correspondientes

        @Value("${app.name}") String appName,
        @Value("${app.desc}") String appDescription,
        @Value("&{app.version}") String appVersion){
        Info info = new Info().title(appName)
                .version(appVersion)
                .description(appDescription)
                .contact(new Contact().name(devName).email(devEmail));
        Server server = new Server().url(url).description(appDescription);
        return new OpenAPI().components(new Components()).info(info).addServersItem(server);
    }
    //Utilidades Devuelve un  moderResolver con un mapper
    @Bean
    public ModelResolver modelResolver(ObjectMapper mapper){
        return new ModelResolver(mapper);
    }
}
