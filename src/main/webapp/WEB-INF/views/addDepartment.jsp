<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Department</h1>
			<p>Find the required information below to add Department</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/department/addDepartment " method="post" 
			commandName="dept" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Name</label> <form:errors path="departmentName" style="color:red; "></form:errors>
				<form:input path="departmentName" id="deptName" class="form-control" />
			</div>
			
				
			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="description" id="description" class="form-control" />
			</div>
			
			
			
						<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/department"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form:form>
		

<%@include file="commonTemplates/footer.jsp" %>