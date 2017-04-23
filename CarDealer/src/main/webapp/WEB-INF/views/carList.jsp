<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Dealer</title>
</head>
<body>
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
	text-align: center;
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
	<center>
		<br /> <br /> <br /> <b>Car List</b><br /> <br />



		<table border="1">
			<tr>
				<td class="heading">Id</td>
				<td class="heading">Make</td>
				<td class="heading">Model</td>
				<td class="heading">Year</td>
				<td class="heading">Fuel</td>
				<td class="heading">Engine</td>
				<td class="heading">Gearbox</td>
				<td class="heading">Color</td>
				<td class="heading">Kilometer</td>
			</tr>
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
					<td><a href="edit?id=${carList.id}">Edit</a></td>
					<td><a href="delete?id=${carList.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"><a href="${pageContext.request.contextPath}/add">Add New Car</a></td>
			</tr>
		</table>

	</center>
</body>
</html>