const StompJs = require('@stomp/stompjs');

const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/websocket/gs-guide-websocket'
});

//const stompClient = StompJs.client('ws://localhost:8080/gs-guide-websocket');

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/cola/saludo', (greeting) => {
        showGreeting(JSON.parse(greeting.body).content);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error('Error with websocket', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers['message']);
    console.error('Additional details: ' + frame.body);
};

function setConnected(connected) {
    if (connected) {
        console.log('Contectado al websocket');
    }
    else {
        console.log('No se ha conectado');
    }
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.publish({
        destination: "/app/saludar",
        body: JSON.stringify({'name': 'Gran Maestro Gonzalo Oviedo'})
    });
}

function showGreeting(message) {
    console.log(message);
}

function comenzar() {
    connect();
    sendName();
    disconnect();
};

comenzar();
