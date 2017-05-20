<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Car List</p>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 sidenav">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a class="nav-link active"
						href="${pageContext.request.contextPath}/listCars">Car List <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/add">Add New Car</a></li>
				</ul>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-logout"
						href="${pageContext.request.contextPath}/login?logout">Sign
							out</a></li>
				</ul>
			</div>
			<div class=" col-sm-8">
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
											Action <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu">
											<li><a href="${editURL}">Edit</a></li>
											<li><a href="${deleteURL}">Delete</a></li>
										</ul>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<footer class="container-fluid navbar-bottom">
	<p>
		<span class="glyphicon glyphicon-copyright-mark"></span> 2017
		CarDealer
	</p>
</footer>

	<jsp:include page="../templates/footer.jsp"></jsp:include>