package de.tekup.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "RESTAPI to check client Eligiblity for Bank credit",
				description = "GEt inof of client and return the status of eligiblity",
				contact = @Contact(name = "H.Rojbani", email = "hmida.rojbani@tek-up.tn")))
public class RestLoanEligCApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLoanEligCApplication.class, args);
	}

}
