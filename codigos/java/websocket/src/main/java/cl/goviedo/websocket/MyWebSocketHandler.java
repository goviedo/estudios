package cl.goviedo.websocket;


import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("WebSocket connection established.");
        // You can perform actions when a connection is established.
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Handle incoming WebSocket messages
        String receivedMessage = message.getPayload();
        System.out.println("Received message: " + receivedMessage);
        
        // Send a response
        String responseMessage = "El servidor recibio lo siguiente: "+receivedMessage;
        try {
            session.sendMessage(new TextMessage(responseMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("WebSocket connection closed.");
        // You can perform actions when a connection is closed.
    }
}