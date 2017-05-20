<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Edit car</p>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 sidenav">
				<ul class="nav nav-pills nav-stacked">
					<li class="nav-item"><a class="nav-link active"
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
				<form:form method="post" action="edit" modelAttribute="car">
					<br />
					<table>
						<tr>
							<td></td>
							<td><form:hidden path="id" /></td>
						</tr>
						<tr>
						<tr>
							<td>Make :</td>
							<td><form:input path="make" /></td>
						<tr>
							<td>Model :</td>
							<td><form:input path="model" /></td>
						</tr>
						<tr>
							<td>Year :</td>
							<td><form:input path="year" /></td>
						</tr>
						<tr>
							<td>Fuel :</td>
							<td><form:input path="fuel" /></td>
						</tr>
						<tr>
							<td>Engine :</td>
							<td><form:input path="engine" /></td>
						</tr>
						<tr>
							<td>Gearbox :</td>
							<td><form:input path="gearbox" /></td>
						</tr>
						<tr>
							<td>Color :</td>
							<td><form:input path="color" /></td>
						</tr>
						<tr>
							<td>Kilometer :</td>
							<td><form:input path="kilometer" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Save" /></td>
						</tr>

					</table>
				</form:form>
			</div>
		</div>
	</div>

	<footer class="container-fluid navbar-fixed-bottom">
		<p>
			<span class="glyphicon glyphicon-copyright-mark"></span> 2017
			CarDealer
		</p>
	</footer>

	<jsp:include page="../templates/footer.jsp"></jsp:include>