<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Delete car</p>
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
				<form class="form" action="delete" method="POST">

					<div class="text-center" class="col-sm-10">
						<div>
							<h4>Are you sure you want to delete this car?</h4>
						</div>
					</div>

					<div class="form-group">
						<label for="make" class="col-sm-2 control-label">Make:</label>
						<div class="col-sm-10">
							<input type="text" class="form-output" name="make">
						</div>

						<label for="model" class="col-sm-2 control-label">Model:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="model">
						</div>
						<div class="row">
							<label for="year" class="col-sm-2 control-label">Year:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="year">
							</div>

							<label for="fuel" class="col-sm-2 control-label">Fuel:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="fuel">
							</div>

							<label for="engine" class="col-sm-2 control-label">Engine:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="engine">
							</div>

							<label for="gearbox" class="col-sm-2 control-label">Gearbox:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="gearbox">
							</div>

							<label for="color" class="col-sm-2 control-label">Color:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="color">
							</div>

							<label for="kilometer" class="col-sm-2 control-label">Kilometer:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="kilometer">
							</div>

							<button name="submit" type="submit" value="submit"
								class="btn-lg btn btn-default">Yes, delete this car</button>

						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

				<form:form method="post" action="delete" modelAttribute="car">
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
							<td><input type="submit" value="Yes, delete this car" /></td>
						</tr>
						<tr>

							<td colspan="2"><a
								href="${pageContext.request.contextPath}/listCars">No, do
									not delete this car</a></td>
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