<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE = edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">

<title>CarDealer</title>

<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container"></div>
	<h1>Car List</h1>

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Make</th>
				<th>Model</th>
				<th>Year</th>
				<th>Fuel</th>
				<th>Engine</th>
				<th>Color</th>
				<th>Fuel</th>
				<th>Kilometer</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="carList" items="${carList}">
				<tr>
					<td>${carList.id}</td>
					<td>${carList.make}</td>
					<td>${carList.model}</td>
					<td>${carList.year}</td>
					<td>${carList.fuel}</td>
					<td>${carList.engine}</td>
					<td>${carList.gearbox}</td>
					<td>${carList.color}</td>
					<td>${carList.kilometer}</td>
					<spring:url value="/edit/${carList.id}" var="editURL" />
					<td><button type="button" class="btn btn-info"
							onclick="location.href='${editURL}'">Edit</button>
					<td />
					<spring:url value="/delete/${carList.id}" var="deleteURL" />
					<td><button type="button" class="btn btn-danger"
							onclick="location.href='${deleteURL}'">Delete</button>
					<td />
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<td><a href="${pageContext.request.contextPath}/add">Add New
					Car</a></td>
		</tfoot>
	</table>
	<p>
		${message}<a href="${pageContext.request.contextPath}/">Get back
			to home page</a><br />
	</p>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>
</html>