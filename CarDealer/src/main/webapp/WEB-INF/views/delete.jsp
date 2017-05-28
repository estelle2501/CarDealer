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
			<div class=" col-sm-4 col-sm-offset-2">
				<div class="text-center" class="col-sm-10">
					<div>
						<h4>Are you sure you want to delete this car?</h4>
					</div>
				</div>
				<form class="form-horizontal" action="${deleteUrl}" method="post">
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">Id:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.id
									} readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="make" class="col-sm-2 control-label">Make:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.make
									} readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="model" class="col-sm-2 control-label">Model:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.model } readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="year" class="col-sm-2 control-label">Year:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.year
									} readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="fuel" class="col-sm-2 control-label">Fuel:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.fuel
									} readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="engine" class="col-sm-2 control-label">Engine:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.engine
									}
								readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="gearbox" class="col-sm-2 control-label">Gearbox:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.gearbox
									}
								readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="color" class="col-sm-2 control-label">Color:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.color
									}
								readonly>
						</div>
					</div>

					<div class="form-group">
						<label for="kilometer" class="col-sm-2 control-label">Kilometer:</label>
						<div class="col-sm-10">
							<input class="form-control" value=${car.kilometer
									}
								readonly>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button name="submit" type="submit" value="submit"
								class="btn btn-danger">Yes, delete this car</button>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="
								btn btn-default"
								onclick="location.href='${pageContext.request.contextPath}/listCars'">Cancel</button>
						</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

					</div>
				</form>
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