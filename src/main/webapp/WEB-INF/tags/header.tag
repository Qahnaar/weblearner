<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header">
	<div class="header-content">
		<div class="logo-container">
		<c:set var="home" value="${homeLink}"/>
		<c:if test="${empty home}">
			<c:set var="home" value="/weblearner"/>
		</c:if>
			<a href="${home}"><img id="logo" alt="WebLearner"
				src="<c:url value="/resources/img/logo.svg"/>"></a>
		</div>
		<div class="header-links">
			<div id="search-container">
				<input id="search" type="text"
					placeholder="Please insert webinar name..." />
			</div>
			<div id="authentication-container">
				<c:choose>
					<c:when test="${not empty LOGGEDIN_USER}">
					Hi, ${LOGGEDIN_USER.email}
					</c:when>
					<c:otherwise>
						<a class="btn btn-default btn-success btn-sm active"
							href="/weblearner/login">Login/Register</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>
