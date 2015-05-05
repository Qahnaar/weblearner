var presentationWebSocket;
var presentationServiceLocation = "ws://localhost:8080/weblearner/presentation/";
var presentationRoom = '';

function onPresentationMessageReceived(evt) {
	var msg = JSON.parse(evt.data);

	// here get binary slide file and display it
	
	console.log(msg.currentName);
}

function sendPresentationMessage(presentationName, currentSlide, slideAction,
		webinarId) {
	var msg = '{"currentSlide":"' + currentSlide + '","slideAction":"'
			+ slideAction + '", "webinarId":"' + webinarId
			+ '", "presentationName": "' + presentationName + '"}';

	presentationWebSocket.send(msg);
}

function connectToPresentationServer() {
	presentationWebSocket = new WebSocket(presentationServiceLocation + presentationRoom);
	presentationWebSocket.onmessage = onPresentationMessageReceived;
}

$(document).ready(function() {
	presentationRoom = $("#webinar_id").text();

	connectToPresentationServer();
});