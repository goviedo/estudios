package cl.goviedo.websocket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
	
	private static Logger LOG = LoggerFactory.getLogger(MyWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
       LOG.info("WebSocket connection established.");
        // You can perform actions when a connection is established.
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Handle incoming WebSocket messages
        String receivedMessage = message.getPayload();
        LOG.info("Received message: " + receivedMessage);
        
        // Send a response. LA RESPUESTA DEL SERVIDOR AL CLIENTE
        try {
            session.sendMessage(new TextMessage(receivedMessage));
        } catch (Exception e) {
        	LOG.error("handleTextMessage method error: "+e.getMessage());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
    	LOG.info("WebSocket connection closed.");
        // You can perform actions when a connection is closed.
    }
}