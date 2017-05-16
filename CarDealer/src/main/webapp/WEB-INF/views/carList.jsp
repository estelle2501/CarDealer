<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Car List</p>
	</div>

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

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="${pageContext.request.contextPath}/"><span
					aria-hidden="true">&larr;</span> Back to homepage</a></li>
		</ul>
	</nav>

	<jsp:include page="../templates/footer.jsp"></jsp:include>