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
<script src="<c:url value="/resources/js/webinar.js" />"></script>
<script src="<c:url value="/resources/js/chat.js" />"></script>
<script
	src="<c:url value="/resources/js/presentation/lectorPresentation.js" />"></script>

<title>Web Learner | ${pageTitle}</title>
</head>
<body>
	<tag:header />
	<div class="content">
		<h2>${webinar.name}</h2>
		<h2>${webinar.lector.name}</h2>
		<div class="left_container">
			<div class="chat">
				<div class="chat_header">LiveChat</div>
				<div id="chat" class="chat_container">
					<span id="webinar_id" style="display: none">${webinar.webinarId}</span>
					<span id="nickname" style="display: none">${LOGGEDIN_USER.name}</span>
				</div>
				<div class="chat_controll">
					<form id="do-chat">
						<input type="text" id="message" class="inputted_message"
							placeholder="Message..." /> <input type="submit"
							class="btn btn-link active chat_send" value="" />
					</form>
				</div>
			</div>
			<br />
			<div class="stream">VIDEO STREAMMMM AHAHA</div>
		</div>
		<div class="presentation">
			<div id="presentationContent">
				<div class="presentation_options_header">Presentation options</div>
				<div id="presentationTable">
					<div class="presentation_available_header">Uploaded
						presentations</div>
					<div class="presentation_table"></div>
				</div>
				<div class="presentation_options">
					<a id="images" class="btn btn-sm active btn_active">Upload
						Images</a> <a id="googleDocs" class="btn btn-sm active btn_active">Use
						Google Docs</a>
				</div>
				<div class="images_container">
					<form id="uploadPresentation" method="POST"
						enctype="multipart/form-data"
						action="/weblearner/presentation/upload/${webinar.webinarId}">
						<input type="file" name="file"> <br /> <input
							type="submit" value="Upload">
					</form>
				</div>
				<div class="googleDocs_container">
					<input id="googleDocsLink" />
				</div>
			</div>
			<div class="slides">
				<div style="display: none;" id="currentSlide">1</div>
				<a id="nextSlide" class="btn btn-sm active btn_active next_slide_button">Next</a> <a
					id="prevSlide" class="btn btn-sm active btn_active previous_slide_button">Previous</a>
				<div id="slideContainer"></div>
			</div>
		</div>
	</div>
</body>