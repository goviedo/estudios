package cl.goviedo.websocket.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import cl.goviedo.websocket.pojo.HolaMundo;
import cl.goviedo.websocket.pojo.Saludo;

@Controller
public class GreetingController {
	
	@MessageMapping("/saludar")
	@SendTo("/cola/saludo")
	public Saludo saludar(HolaMundo hola) throws InterruptedException {
		Thread.sleep(2000);
		return new Saludo("El servidor websocket saluda a "+hola.getNombre());
	}

}
