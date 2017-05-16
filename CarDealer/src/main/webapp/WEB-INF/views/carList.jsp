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
					<spring:url value="/delete/${carList.id}" var="deleteURL" />
					<td>
						<div class="btn-group">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								Action
								<!-- <span class="caret"></span> -->
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu">
								<li><a href="${editURL}">Edit</a></li>
								<li><a href="${deleteURL}">Delete</a></li>
							</ul>
						</div>
					<td />
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class=row>
		<button type="button" class="btn btn-lg btn-block"
			onclick="location.href='${pageContext.request.contextPath}/add'">Add
			New Car</button>
	</div>

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="${pageContext.request.contextPath}/"><span
					aria-hidden="true">&larr;</span> Back to homepage</a></li>
		</ul>
	</nav>

	<jsp:include page="../templates/footer.jsp"></jsp:include>