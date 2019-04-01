<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Edit Category</h1>
			<p>Find the required information below to edit Category:</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/category/editCategory " method="post" 
			commandName="cat" enctype="multipart/form-data">
			
			<form:hidden path ="categoryId" value="${cat.categoryId }" />
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="cateogoryName" id="name" class="form-control" value="${cat.cateogoryName}"/>
			</div>
			<div class="form-group">
				<label for="category">Category</label>
				<label class="checkbox-inline"> <form:radiobutton path="department.departmentId" id="category" 
													value="1" />Regional</label>
				<label class="checkbox-inline"> <form:radiobutton path="department.departmentId" id="category" 
													value="2" />Nature</label>
				<label class="checkbox-inline"> <form:radiobutton path="department.departmentId" id="category" 
													value="3" />Seasonal</label>									
			</div>
						
			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="description" id="description" class="form-control" value="${cat.description }"/>
			</div>
			
			
			<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/department"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form:form>

<%@include file="commonTemplates/footer.jsp" %>