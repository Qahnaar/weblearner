<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/lib/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/chat.js" />"></script>

<title>Web Learner | Test</title>
</head>
<body>
	<video controls>
		<source src="/weblearner/loadVideoFile" type="video/mp4">
	</video>
	<form>
		<input id="textMessage" type="text" /> <input onClick="sendName();"
			value="Send Message" type="button" />
	</form>
	<br />
	<textarea id="messageTextArea" rows="10" cols="50"></textarea>
</body>
</html>