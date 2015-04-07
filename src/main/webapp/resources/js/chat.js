var wsocket;
var serviceLocation = "ws://localhost:8080/weblearner/chat/";
var $nickName;
var $message;
var $chatWindow;
var room = '';

function onMessageReceived(evt) {
	var msg = JSON.parse(evt.data);

	var message_core = '<div class="message"><div>';
	if (msg.sender === $nickName.text()) {
		message_core = '<div class="message"><div class="identifier">'
	}
	var message_received = '<div class="chat_timestamp">' + msg.received
			+ '</div>';
	var message_sender = '<div class="chat_sender">' + msg.sender + '</div>';
	var message_text = '<div class="chat_message">' + msg.message + '</div>';

	var $messageLine = $(message_core + message_received + message_sender
			+ '</div>' + message_text + '</div>');

	$chatWindow.append($messageLine);
	$chatWindow.scrollTop($chatWindow[0].scrollHeight);
}

function sendMessage() {
	var msg = '{"message":"' + $message.val() + '", "sender":"'
			+ $nickName.text() + '", "received":""}';
	wsocket.send(msg);
	$message.val('').focus();
}

function sendEnterMessage() {
	var msg = '{"message":"' + $nickName.text() + ' has logged in", "sender":"'
			+ $nickName.text() + '", "received":""}';
	wsocket.send(msg);
}

function connectToChatserver() {
	wsocket = new WebSocket(serviceLocation + room);
	wsocket.onmessage = onMessageReceived;
	// sendEnterMessage();
}

function leaveRoom() {
	wsocket.close();
}

$(document).ready(function() {
	$nickName = $('#nickname');
	$message = $('#message');
	$chatWindow = $("#chat");
	room = $("#webinar_id").text();

	$('#do-chat').submit(function(evt) {
		evt.preventDefault();
		sendMessage()
	});

	$('#leave-room').click(function() {
		leaveRoom();
	});

	connectToChatserver();
});