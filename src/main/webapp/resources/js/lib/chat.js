function connect() {
	if ('WebSocket' in window) {
		console.log('Websocket supported');
		socket = new WebSocket('ws://localhost:8080//weblearner//chatHandler');

		console.log('Connection attempted');

		socket.onopen = function() {
			console.log('Connection open!');
		}

		socket.onclose = function() {
			console.log('Disconnecting connection');
		}

		socket.onmessage = function(evt) {
			var received_msg = evt.data;
			console.log(received_msg);
			console.log('message received!');
			showMessage(received_msg);
		}

	} else {
		console.log('Websocket not supported');
	}
}

function disconnect() {
	console.log("Disconnected");
}

function sendName() {
	var message = document.getElementById('textMessage').value;
	socket.send(JSON.stringify({
		'message' : message
	}));
}

function showMessage(message) {
	var response = document.getElementById('messageTextArea');
	response.value += message;
}

$(document).ready(function() {
	connect();
});