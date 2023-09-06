package cl.goviedo.cliente.basico;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;

@ClientEndpoint
public class MyClientEndpoint {
	
	private static Logger LOG = LoggerFactory.getLogger(MyClientEndpoint.class);
	
	String argumento = "";
	
	public MyClientEndpoint(String argumento) {
		this.argumento = argumento;
	}
	
	@OnOpen
    public void onOpen(Session session) {
		LOG.info("Connected to endpoint: " + session.getBasicRemote());
        try {
            LOG.info("Enviando el siguiente mensaje al servidor: " + argumento);
            session.getBasicRemote().sendText(argumento);
        } catch (IOException ex) {
        	LOG.error("Error en el evento OnOpen");
        }
    }

    @OnMessage
    public void processMessage(String message) {
        System.out.println(message);
        Client.messageLatch.countDown();
    }

    @OnError
    public void processError(Throwable t) {
    	LOG.error("Error OnError"+t.getMessage());
    }
}
