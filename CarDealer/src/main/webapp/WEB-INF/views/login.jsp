<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<body>

	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Login page</p>
	</div>

	<div class="container">
		
		<form class="form" action="${loginUrl}" method='POST'>

			<div class="text-center" class="col-sm-10">
				<div>
					<h4>Please enter your creditentials below:</h4>
				</div>
			</div>

			<div class="form-group">
				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="alert alert-info">${msg}</div>
				</c:if>
			</div>
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">User:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username">
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-sm-10">
						<button name="submit" type="submit" value="submit"
							class="btn btn-default">Sign in</button>
					</div>
				</div>
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>

	<jsp:include page="../templates/footer.jsp"></jsp:include>