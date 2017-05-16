<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class=container>
		<div class=row class=center-block>
			<div class="text-center">
			<h1>Welcome to CarDealer!</h1>
			</div>
		</div>
		<div class=row>
			<img src="/CarDealer/images/alfa.jpg" class="center-block"  />
		</div>
		<div class=row>
			<button type="button" class="btn btn-primary btn-lg btn-block"
				onclick="location.href='${pageContext.request.contextPath}/listCars'">Start
				application</button>
			<button type="button" class="btn btn-default btn-lg btn-block"
				onclick="location.href='${pageContext.request.contextPath}/login?logout'">Log
				out</button>
		</div>
	</div>

	<jsp:include page="../templates/footer.jsp"></jsp:include>