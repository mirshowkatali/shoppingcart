<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="commonTemplates/header.jsp" %>

<script>
$(document).ready(function(){

    $('.table').DataTable({
        "lengthMenu": [[5,10,-1], [5,10, "All"]]
    });
});

</script>

	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Editing values for attribute</h1>
				
			</div>

			<table class="table table-striped table-hover rounded" >
				<thead>
					<tr class="bg-primary">
						<th>Attribute Value</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attrib}" var="dep">
						<tr>
							
							<td>${dep.value}</td>
																		
							<td>
							
							
							<a href="<spring:url value="/admin/attribute/deleteAttributeValue/${dep.id}"/>" class="btn btn-danger">Delete</a>
							<a href="<spring:url value="/admin/attribute/editAttributeValue/${dep.id}"/>" class="btn btn-success">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			<a href="<spring:url value="/admin/attribute/addAttributeValue" />" class="btn btn-primary">Add Attribute Value</a>

<%@ include file="commonTemplates/footer.jsp" %>