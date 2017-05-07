<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Car Dealer</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: left;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
	<br />
	<br />
	<br />
	<b>Edit the car </b>
	<br />
	<br />
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
				<tr>

					<td colspan="2"><a
						href="${pageContext.request.contextPath}/listCars">Cancel</a></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
