<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Category</h1>
			<p>Find the required information below to add Category</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/category/addCategory " method="post" 
			commandName="cat" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="name">Name</label> <form:errors path="cateogoryName" style="color:red; "></form:errors>
				<form:input path="cateogoryName" id="cateogoryName" class="form-control" />
			</div>
			<div class="form-group">
				<label for="category">Department</label>
				<label class="checkbox-inline"> <form:radiobutton path="department.departmentId" id="category" 
													value="1" />Regional</label>
				<label class="checkbox-inline"> <form:radiobutton path="department.departmentId" id="category" 
													value="2" />Nature</label>
				<label class="checkbox-inline"> <form:radiobutton path="department.departmentId" id="category" 
													value="3" />Seasonal</label>									
			</div>
				
			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="description" id="description" class="form-control" />
			</div>
			
			
			
						<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/category"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form:form>
		

<%@include file="commonTemplates/footer.jsp" %>