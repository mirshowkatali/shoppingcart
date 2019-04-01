<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Attribute</h1>
			<p>Find the required information below to add Attribute</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/attribute/addAttribute " method="POST" 
			commandName="attrib" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="name">Name</label> <form:errors path="name" style="color:red; "></form:errors>
				<form:input path="name" id="name" class="form-control" />
			</div>
						
						<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/attribute"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form:form>
		

<%@include file="commonTemplates/footer.jsp" %>