package ar.edu.utn.frc.tup.lciii;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		MercadoPagoConfig.setAccessToken("APP_USR-2445262569976889-042313-3355287e6a6e9a307d7bf36b9835ebd7-500676264"); // O de producción

	}

}
