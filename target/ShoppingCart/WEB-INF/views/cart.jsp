<%@include file="commonTemplates/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>

var color= sessionStorage.getItem("color");
var size= sessionStorage.getItem("size");
</script>
<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>
					
					<p>All the selected products in your shopping cart</p>
				</div>
			</div>
		</section>
		<%
    String str = "<script>document.writeln(color)</script>";
    String str1 = "<script>document.writeln(size)</script>";
   %>
		<section class="conatiner" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
			<div>
				<a class="btn btn-danger pull-left" ng-click="clearCart()">Clear Cart</a>
				<a href="<spring:url value="/order/${cartId}"/>" class="btn btn-success pull-right">Checkout</a>
			</div>
			
			<br/><br/>
			<table class="table table-hover">
					<tr class="bg-primary">
						<th>Product</th>
						<th>Color</th>
						<th>Size</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.name}}</td>
						<td><%=str %></td>
						<td><%=str1 %></td>
						<td>{{item.product.price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a class="label label-danger" ng-click="removeFromCart(item.product.id)">
							<span class="glyphicon glyphicon-remove"></span>Remove</a></td>
						
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th><span><span><span><span>$</span>{{calGrandTotal()}}</th>
						<th></th>
					</tr>
			</table>
			<a href="<spring:url value="/product/productList/all"/>" class="btn btn-success">Continue Shopping</a>
			
			</div>
		</section>


<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@ include file="commonTemplates/footer.jsp" %>