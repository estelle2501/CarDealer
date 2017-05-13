<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="../templates/header.jsp"></jsp:include>
</head>

<body>
	<!-- 	<h1>Welcome to CarDealer!</h1> -->
	<div class=container>Welcome to CarDealer!</div>
	<p>
		${message}<br /> <a
			href="${pageContext.request.contextPath}/listCars">Start
			application</a><br />
	</p>
	<p>
		${message}<br /> <a
			href="${pageContext.request.contextPath}/login?logout">Log out</a><br />
	</p>

	<jsp:include page="../templates/footer.jsp"></jsp:include>

</body>
</html>