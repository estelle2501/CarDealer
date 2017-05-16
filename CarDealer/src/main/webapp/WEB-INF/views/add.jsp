<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Add new car</p>
	</div>
	<div class="container">
		<form class="form" action="add" method="POST">

			<div class="text-center" class="col-sm-10">
				<div>
					<h4>Please fill in the following form to add a new car:</h4>
				</div>
			</div>

			<div class="form-group">
				<label for="make" class="col-sm-2 control-label">Make:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="make">
				</div>

				<label for="model" class="col-sm-2 control-label">Model:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="model">
				</div>
				<div class="row">
					<label for="year" class="col-sm-2 control-label">Year:</label> <select
						class="form-control" name="year">
						<option>1999</option>
						<option>2000</option>
						<option>2001</option>
						<option>2002</option>
						<option>2003</option>
					</select>
					<!-- 						<div class="col-sm-8">
					<input type="text" class="form-control" name="year"> -->
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
					class="btn-lg btn btn-default">Save</button>

			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

	</div>

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="${pageContext.request.contextPath}/listCars"><span
					aria-hidden="true">&larr;</span> Cancel</a></li>
		</ul>
	</nav>

	<jsp:include page="../templates/footer.jsp"></jsp:include>