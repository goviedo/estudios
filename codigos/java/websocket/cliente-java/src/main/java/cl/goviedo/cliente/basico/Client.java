package cl.goviedo.cliente.basico;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.WebSocketContainer;

public class Client {
	
	private static Logger LOG = LoggerFactory.getLogger(Client.class);

    final static CountDownLatch messageLatch = new CountDownLatch(1);

    public static void ejecutar(String[] args) {
        try {
        	
        	String argumento = args[0];
        	
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://localhost:6080/websocket";
            LOG.info("Conectando a " + uri);
            
            MyClientEndpoint m = new MyClientEndpoint(argumento);
            
            container.connectToServer(m, URI.create(uri));
            messageLatch.await(100, TimeUnit.SECONDS);
        } catch (DeploymentException | InterruptedException | IOException ex) {
        	LOG.error("Excepcion al ejecutar el servidor "+ex.getMessage());
        }
    }
}