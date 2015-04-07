<!DOCTYPE html>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/lib/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/chat.js" />"></script>

<title>Web Learner | ${pageTitle}</title>
</head>
<body>
	<tag:header />
	<div class="content">
		<h2>${webinar.name}</h2>
		<h2>${webinar.lector.name}</h2>
		<div id="chat" class="chat-container">
			<span id="webinar_id" style="display: none">${webinar.id}</span> <span
				id="nickname" style="display: none">${LOGGEDIN_USER.email}</span>
		</div>
		<div class="chat_controll">
			<form id="do-chat">
				<input type="text" id="message" class="inputted_message"
					placeholder="Message..." /> <input type="submit"
					class="btn btn-link active chat_send" value="" />
			</form>
		</div>
	</div>
</body>