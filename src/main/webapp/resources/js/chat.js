var chatWebSocket;
var chatServiceLocation = "ws://localhost:8080/weblearner/chat/";
var $nickName;
var $message;
var $chatWindow;
var chatRoom = '';

function onChatMessageReceived(evt) {
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

function sendChatMessage() {
	var msg = '{"message":"' + $message.val() + '", "sender":"'
			+ $nickName.text() + '", "received":""}';
	chatWebSocket.send(msg);
	$message.val('').focus();
}

function sendChatEnterMessage() {
	var msg = '{"message":"' + $nickName.text() + ' has logged in", "sender":"'
			+ $nickName.text() + '", "received":""}';
	chatWebSocket.send(msg);
}

function connectToChatServer() {
	chatWebSocket = new WebSocket(chatServiceLocation + chatRoom);
	window.setTimeout(function() {
		chatWebSocket.onmessage = onChatMessageReceived;
		sendChatEnterMessage();
	}, 1000);
}

function leaveChatRoom() {
	chatWebSocket.close();
}

$(document).ready(function() {
	$nickName = $('#nickname');
	$message = $('#message');
	$chatWindow = $("#chat");
	chatRoom = $("#webinar_id").text();

	$('#do-chat').submit(function(evt) {
		evt.preventDefault();
		sendChatMessage();
	});

	$('#leave-room').click(function() {
		leaveChatRoom();
	});

	connectToChatServer();
});