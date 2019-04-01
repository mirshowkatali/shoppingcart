<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commonTemplates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Attribute Value</h1>
			<p>Find the required information below to add Attribute Value</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/attribute/addAttributeValue " method="POST" 
			commandName="attrib" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="value">Attribute Value</label> <form:errors path="value" style="color:red; "></form:errors>
				<form:input path="value" id="value" class="form-control" />
			</div>
			<div class="form-group">
				<label>Attribute</label>
				<form:select path="attributeId" class="form-control">
				<form:options items="${attributeList}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>			
						<br/><br/>
			
			<input type="submit" value="submit" class="btn btn-outline-success">
			<a href="<c:url value="/admin/attribute"/>" class="btn btn-outline-primary">Cancel</a>
		
		</form:form>
		

<%@include file="commonTemplates/footer.jsp" %>