<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<h1>HTTP Status 403 - Access is denied</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h2>
				Username : ${username} <br /> You do not have permission to access
				this page!
			</h2>
		</c:otherwise>
	</c:choose>

	Click
	<a href="${pageContext.request.contextPath}/listCars">here</a> to go
	back.

	<jsp:include page="../templates/footer.jsp"></jsp:include>