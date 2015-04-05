<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/lib/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/resources/js/lib/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/homepage.js" />"></script>

<title>Web Learner | ${pageTitle}</title>
</head>
<body>
	<div class="header">
		<div class="header-content">
			<div class="logo-container">
				<a href="/weblearner"><img id="logo" alt="WebLearner"
					src="<c:url value="/resources/img/logo.png"/>"></a>
			</div>
			<div class="header-links">
				<div id="search-container">
					<input id="search" type="text"
						placeholder="Please insert webinar name..." />
				</div>
				<div id="authentication-container">
					<a class="btn btn-default btn-success btn-sm active"
						href="/weblearner/user/login">Login/Register</a>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<h2>WebLeaner</h2>
		<h3>Find your study here</h3>

		<div id="featured-container">
			<div id="control-panel">
				<a id="prev" href=""> <img alt="Prev"
					src="<c:url value="/resources/img/left-arrow.png"/>">
				</a>
				<div class="center-block featured-label">Featured Webinars</div>
				<c:if test="${fn:length(featuredWebinars) gt 3}">
					<a id="next" href=""> <img alt="Next"
						src="<c:url value="/resources/img/right-arrow.png"/>">
					</a>
				</c:if>
			</div>
			<div class="featured-outer-container">
				<c:choose>
					<c:when test="${fn:length(featuredWebinars) eq 0}">
					</c:when>
					<c:otherwise>
						<div class="featured-inner-container">
							<c:forEach items="${featuredWebinars}" var="webinar">
								<div class="featured-element">
									<span>${webinar.name}</span> <br /> presented by <br /> <span>${webinar.lector.name}</span>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>