<jsp:include page="../templates/header.jsp"></jsp:include>

<body>
	<div class="jumbotron text-center">
		<h1>CarDealer</h1>
		<p>Welcome!</p>
	</div>

	<div class=container>
		<div class=row>
			<img src="/CarDealer/images/alfa.jpg" class="center-block" />
		</div>
		<div class=imgButton>
			<button type="button" class="btn-lg btn-default"
				onclick="location.href='${pageContext.request.contextPath}/login'">Sign
				in</button>
		</div>

	</div>
	
	<footer class="container-fluid navbar-fixed-bottom">
		<p>
			<span class="glyphicon glyphicon-copyright-mark"></span> 2017
			CarDealer
		</p>
	</footer>
	
	<jsp:include page="../templates/footer.jsp"></jsp:include>