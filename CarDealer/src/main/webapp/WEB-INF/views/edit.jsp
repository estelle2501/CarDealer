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
			<div class=" col-sm-4 col-sm-offset-2">
				<div class="text-center" class="col-sm-10">
					<div>
						<h4>Please edit the following form:</h4>
					</div>
				</div>
				<form class="form-horizontal" action="${editUrl}" method="post">
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">Id:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value=${car.id } readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="make" class="col-sm-2 control-label">Make:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" name="make"
								maxlength="10" value=${car.make } required>
						</div>
					</div>

					<div class="form-group">
						<label for="model" class="col-sm-2 control-label">Model:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control required" name="model"
								maxlength="20" value=${car.model } required>
						</div>
					</div>

					<div class="form-group">
						<label for="year" class="col-sm-2 control-label">Year:</label>
						<div class="col-sm-10">
							<select class="form-control" name="year" value=${car.year }>
								<option>1999</option>
								<option>2000</option>
								<option>2001</option>
								<option>2002</option>
								<option>2003</option>
								<option>2004</option>
								<option>2005</option>
								<option>2006</option>
								<option>2007</option>
								<option>2008</option>
								<option>2009</option>
								<option>2010</option>
								<option>2011</option>
								<option>2012</option>
								<option>2013</option>
								<option>2014</option>
								<option>2015</option>
								<option>2016</option>
								<option>2017</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="fuel" class="col-sm-2 control-label">Fuel:</label>
						<div class="col-sm-10">
							<select class="form-control" name="fuel" value=${car.fuel }>
								<option>gas</option>
								<option>diesel</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="engine" class="col-sm-2 control-label">Engine:</label>
						<div class="col-sm-10">
							<input type=number class="form-control" name="engine" max="3.5"
								step=".1" placeholder="0.0" value=${car.engine }>
						</div>
					</div>

					<div class="form-group">
						<label for="gearbox" class="col-sm-2 control-label">Gearbox:</label>
						<div class="col-sm-10">
							<select class="form-control" name="gearbox" value=${car.gearbox }>
								<option>manual</option>
								<option>automat</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="color" class="col-sm-2 control-label">Color:</label>
						<div class="col-sm-10">
							<select class="form-control" name="color" value=${car.color }>
								<option>black</option>
								<option>blue</option>
								<option>grey</option>
								<option>green</option>
								<option>red</option>
								<option>silver</option>
								<option>white</option>
								<option>yellow</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="kilometer" class="col-sm-2 control-label">Kilometer:</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" name="kilometer"
								min="0" max="999999" value=${car.kilometer }>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button name="submit" type="submit" value="submit"
								class="btn btn-warning">Yes, apply changes to the car</button>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="
								btn btn-default"
								onclick="location.href='${pageContext.request.contextPath}/carList'">Cancel</button>
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