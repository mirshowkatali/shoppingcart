<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Product</h1>
			<p>Find the required information below to add product</p>
		</div>
		
		<form action="${pageContext.request.contextPath}/admin/product/addProduct " method="post" >
			<div class="form-group">
				<label for="name">Name</label> 
				<input type="text" id="name" name="name" class="form-control" />
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
				</textarea>  
			</div>
			
			<div class="form-group">
				<label for="price">Price</label> 
				<input type="text" id="price" name="price" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="discountedprice">Discounted Price</label> 
				<input type="text" id="discountedPrice" name="discountedPrice" class="form-control" />
			</div>		
			
			
			<div class="form-group">
				<label class="control-label" for="image">Upload Image</label>
				<input name="image" id="image" type="file" class="form:input-large" />
			</div>
			<div class="form-group">
				<label class="control-label" for="image">Upload Image 2</label>
				<input name="image_2" id="image_2" type="file" class="form:input-large" />
			</div>
			<div class="form-group">
				<label class="control-label" for="image">Upload Thumbnail</label>
				<input name="thumbnail" id="thumbnail" type="file" class="form:input-large" />
			</div>
			<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/productInventory"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form>
		

<%@include file="commonTemplates/footer.jsp" %>