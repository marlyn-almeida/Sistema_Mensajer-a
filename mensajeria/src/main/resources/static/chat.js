var stompClient = null;
var username = null;

function setConnected(connected) {
    if (connected) {
        console.log("Conectado a WebSocket");
    } else {
        console.log("Desconectado de WebSocket");
    }
}

function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        stompClient.subscribe('/topic/messages', function (messageOutput) {
            showMessage(messageOutput.body, 'received');
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
}

function sendMessage() {
    var message = document.getElementById('message').value;
    if (message) {
        stompClient.send("/app/send", {}, JSON.stringify({
            sender: localStorage.getItem('username'),
            content: message
        }));
        document.getElementById('message').value = '';  // Limpiar el campo de mensaje
        showMessage(message, 'sent');
    }
}

function showMessage(message, type) {
    var messagesDiv = document.getElementById('messages');
    var newMessage = document.createElement('div');
    newMessage.classList.add('message', type);

    var messageContent = `
        <span>${localStorage.getItem('username')}</span>
        <p>${message}</p>
    `;

    newMessage.innerHTML = messageContent;
    messagesDiv.appendChild(newMessage);
    messagesDiv.scrollTop = messagesDiv.scrollHeight;  // Desplazar hacia abajo al último mensaje
}

document.addEventListener('DOMContentLoaded', function () {
    username = localStorage.getItem('username');
    document.getElementById('user-name-display').innerText = username;
    connect();
});
