<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>HTTP Status 403 - Access is denied</p>
	</div>
	<c:choose>
		<c:when test="${empty username}">
			<div class="alert alert-danger">
				<h2>You do not have permission to access this page!</h2>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger">
				<h2>As a ${username} you do not have permission to access this
					page!</h2>
			</div>
		</c:otherwise>
	</c:choose>

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="${pageContext.request.contextPath}/listCars"><span
					aria-hidden="true">&larr;</span> Back to Car List</a></li>
		</ul>
	</nav>

	<jsp:include page="../templates/footer.jsp"></jsp:include>