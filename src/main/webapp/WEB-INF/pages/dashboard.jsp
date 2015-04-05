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
<script src="<c:url value="/resources/js/dashboard.js" />"></script>
<title>Web Learner | ${pageTitle}</title>
</head>
<body>
	<tag:header />
	<div class="content">
		<h2>WebLeaner</h2>
		<h3>Find your study here</h3>

		<div id="featured-container">
			<div id="control-panel">
				<a id="prev" href=""> <img alt="Prev"
					src="<c:url value="/resources/img/left-arrow.svg"/>">
				</a>
				<div class="center-block featured-label">Featured Webinars</div>
				<c:if test="${fn:length(featuredWebinars) gt 3}">
					<a id="next" href=""> <img alt="Next"
						src="<c:url value="/resources/img/right-arrow.svg"/>">
					</a>
				</c:if>
			</div>
			<div class="featured-outer-container">
				<c:choose>
					<c:when test="${fn:length(featuredWebinars) eq 0}">
						<div>Sry, nothing here</div>
					</c:when>
					<c:otherwise>
						<div class="featured-inner-container">
							<c:forEach items="${featuredWebinars}" var="webinar">
								<div class="featured-element">
									<span> <a href="/weblearner/webinars/${webinar.id}">${webinar.name}</a>
									</span> <br /> presented by <br /> <span>${webinar.lector.name}</span>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>