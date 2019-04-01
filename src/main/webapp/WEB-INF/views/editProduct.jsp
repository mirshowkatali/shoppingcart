<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Edit Product</h1>
			<p>Find the required information below to edit product:</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/product/editProduct " method="post" 
			commandName="product" enctype="multipart/form-data">
			
			<input type ="hidden" name="id" value="${product.id }" />
			<div class="form-group">
				<label for="name">Name</label> 
				<input type="text" id="name" name="name" class="form-control" value="${product.name}" }/>
			</div>
			
			<div class="form-group">
				<label>Category</label>
				<select name="category">
				<c:forEach var="list" items="${cat}">
				<option value="${list.categoryId}">${list.cateogoryName}</option>
				</c:forEach>
				</select>								
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<textarea  name="description" class="form-control">  
				${product.description }</textarea>  
			</div>
			
			<div class="form-group">
				<label for="price">Price</label> 
				<input type="text" id="price" name="price" class="form-control" value="${product.price}" />
			</div>
			
			<div class="form-group">
				<label for="discountedprice">Discounted Price</label> 
				<input type="text" id="discountedPrice" name="discountedPrice" class="form-control" value="${product.discountedPrice}" />
			</div>		
			
			
			<div class="form-group">
				<label class="control-label" for="image">Image</label>
				<img name="image" id="image" src="${product.image}"/>
			</div>
			
			<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/productInventory"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form:form>

<%@include file="commonTemplates/footer.jsp" %>