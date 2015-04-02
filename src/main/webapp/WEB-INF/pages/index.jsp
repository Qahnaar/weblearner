<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/lib/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>

<title>Web Learner | ${pageTitle}</title>
</head>
<body>
	<div class="header">
		<div class="header-content">
			<div class="logo-container">
				<a href="/weblearner"><img id="logo" alt="WebLearner"
					src="<c:url value="/resources/images/logo.png"/>"> </a>
			</div>
			<div class="header-links">
				<div id="search-container">
					<input id="search" type="text"
						placeholder="Please insert webinar name..." />
				</div>
				<div id="authentication-container">
					<a href="/weblearner/login">Login/Register</a>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<h2>WebLeaner</h2>
		<h3>Find your study here</h3>
		<div class="feature-container">
			<c:forEach items="${featuredWebinars}" var="webinar">
				<div>${webinar.name} with lector $(webinar.lector.email)</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>