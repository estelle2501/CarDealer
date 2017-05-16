<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Edit car</p>
	</div>
	<div>
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

	<nav aria-label="...">
		<ul class="pager">
			<li class="previous"><a
				href="${pageContext.request.contextPath}/listCars"><span
					aria-hidden="true">&larr;</span> Cancel</a></li>
		</ul>
	</nav>

	<jsp:include page="../templates/footer.jsp"></jsp:include>