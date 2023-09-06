package cl.goviedo.cliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.goviedo.cliente.basico.Client;

@SpringBootApplication
public class ClienteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client.ejecutar(args);
	}

}
