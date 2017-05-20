<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<body>

	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Login page</p>
	</div>

	<div class="container">
		<div class="text-center" class="col-sm-10">
			<div>
				<h4>Please enter your creditentials below:</h4>
			</div>
		</div>
		<form class="form-horizontal" action="${loginUrl}" method='POST'>

			<div class="form-group">
				<div class="col-sm-10">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="alert alert-info">${msg}</div>
					</c:if>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="username">User:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control"
						placeholder="Enter username" name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control"
						placeholder="Enter password" name="password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button name="submit" type="submit" value="submit"
						class="btn btn-default">Sign in</button>
				</div>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</div>
		</form>
	</div>

	<footer class="container-fluid navbar-fixed-bottom">
		<p>
			<span class="glyphicon glyphicon-copyright-mark"></span> 2017
			CarDealer
		</p>
	</footer>
	
	<jsp:include page="../templates/footer.jsp"></jsp:include>