var presentationWebSocket;
var presentationServiceLocation = "ws://localhost:8080/weblearner/presentation/";
var presentationRoom = '';

function onPresentationMessageReceived(evt) {
	var msg = JSON.parse(evt.data);

	loadAndDisplaySlide(msg.webinarId, msg.presentationName, msg.slide);
}

function connectToPresentationServer() {
	presentationWebSocket = new WebSocket(presentationServiceLocation + presentationRoom);
	presentationWebSocket.onmessage = onPresentationMessageReceived;
}

$(document).ready(function() {
	presentationRoom = $("#webinar_id").text();

	connectToPresentationServer();
});