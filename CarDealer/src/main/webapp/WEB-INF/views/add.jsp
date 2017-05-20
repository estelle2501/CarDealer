<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Add new car</p>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 sidenav">
				<ul class="nav nav-pills nav-stacked">
					<li class="nav-item"><a class="nav-link active"
						href="${pageContext.request.contextPath}/listCars">Car List <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="active"><a class="nav-link"
						href="${pageContext.request.contextPath}/add">Add New Car</a></li>
				</ul>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-logout"
						href="${pageContext.request.contextPath}/login?logout">Sign
							out</a></li>
				</ul>
			</div>
			<div class=" col-sm-8">
				<div class="text-center" class="col-sm-10">
					<div>
						<h4>Please fill in the following form to add a new car:</h4>
					</div>
				</div>
				<form class="form-horizontal" action="add" method="POST">
					<div class="form-group">
						<label for="make" class="col-sm-2 control-label">Make:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="make">
						</div>
					</div>

					<div class="form-group">
						<label for="model" class="col-sm-2 control-label">Model:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="model">
						</div>
					</div>

					<div class="form-group">
						<label for="year" class="col-sm-2 control-label">Year:</label>
						<div class="col-sm-10">
							<select class="form-control" name="year">
								<option>1999</option>
								<option>2000</option>
								<option>2001</option>
								<option>2002</option>
								<option>2003</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="fuel" class="col-sm-2 control-label">Fuel:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="fuel">
						</div>
					</div>

					<div class="form-group">
						<label for="engine" class="col-sm-2 control-label">Engine:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="engine">
						</div>
					</div>

					<div class="form-group">
						<label for="gearbox" class="col-sm-2 control-label">Gearbox:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="gearbox">
						</div>
					</div>

					<div class="form-group">
						<label for="color" class="col-sm-2 control-label">Color:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="color">
						</div>
					</div>

					<div class="form-group">
						<label for="kilometer" class="col-sm-2 control-label">Kilometer:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="kilometer">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button name="submit" type="submit" value="submit"
								class="btn btn-default">Save</button>
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