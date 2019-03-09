<%@include file="commonTemplates/header.jsp" %>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Details</h1>
			<p>Find the detailed information of your selected product</p>
		</div>
		
		<div class="conatiner" ng-app="cartApp">
			<div class="row">
				<div class="col-md-6 ">
					<img src="<c:url value="/resources/images/${product.id}.gif "/>" alt="image" style="width:400px;height:250px;">
				</div>
				<div class="col-md-6">
					<h3> ${product.name}</h3>
					<p>${product.description}</p>
					<p><strong>Manufacturer:</strong>${product.manufacturer}</p>
					<p><strong>Category:</strong>${product.category}</p>
					<p><strong>Condition:</strong>${product.condition}</p>
					<h4>${product.price}</h4>
					
					<br>
					
                    <c:set var="url" scope="page" value="/product/productList/all" />
                    <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>
					
					<p ng-controller="cartCtrl">
						<a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
						<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
						
							<form action="/ShoppingCart/rest/cart/add/" method="POST" role="form" class="form-horizontal">
  							<input type="hidden" name="id" value="${product.id}" />
 							 <div class="form-group">
   							 <div class="col-sm-10">
    						 <button type="submit" class="btn btn-default">Add to Cart</button>
    						</div>
  							</div>
							</form>
							
							<a href="<c:url value="/customer/cart/${product.id}"/>" class="btn btn-default">View Cart</a>
						</c:if>
					</p>
				</div>
			</div>
		</div>


<%@include file="commonTemplates/footer.jsp" %>