-<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide home-image"
					src="<c:url value="/resources/images/birds.gif" />"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Welcome to the Store</h1>

						<p>Browse and Buy variety of T-Shirts. Plug in and find yourself in the world of Fashion.</p>

					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="<c:url value="/resources/images/birds-2.gif" />"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Start Browsing</h1>

						<p>Lose yourself in the t-shirt...</p>

					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="<c:url value="/resources/images/buffalo.gif" />"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>End Buying</h1>

						<p>No Fashion..No Life..Know Fashion..Know Life</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->


	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<a href="<c:url value = "/product/productList?searchCondition=Regional" />" role="button">
					<img class="img-circle"
						src="<c:url value="/resources/images/caribou.gif" />"
						alt="Insturments" width="140" height="140"> </a>
					<h2>T-Shirt-1</h2>
				
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
			<a href="<c:url value = "/product/productList?searchCondition=Nature" />" role="button">
				<img class="img-circle"
					src="<c:url value="/resources/images/caribou-2.gif" />"
					alt="Records" width="140" height="140"> </a>
				<h2>T-Shirt-2</h2>
			

			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
			<a href="<c:url value = "/product/productList?searchCondition=Seasonal" />" role="button">
				<img class="img-circle"
					src="<c:url value="/resources/images/caribou-thumbnail.gif" />"
					alt="Accessories" width="140" height="140"></a>
				<h2>T-Shirt-3</h2>
				
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->
	<%@ include file="commonTemplates/footer.jsp"%>