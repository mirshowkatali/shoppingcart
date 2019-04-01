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
				<h1>Department Page</h1>
				
			</div>

			<table class="table table-striped table-hover rounded" >
				<thead>
					<tr class="bg-primary">
						<th>Department Name</th>
						<th>Department Description</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dept}" var="dep">
						<tr>
							
							<td>${dep.departmentName}</td>
							<td>${dep.description}</td>
												
							<td>
							
							<a href="<spring:url value="/admin/department/viewDepartment/${dep.departmentId}"/>" class="btn btn-success">View</a>
							<a href="<spring:url value="/admin/department/deleteDepartment/${dep.departmentId}"/>" class="btn btn-danger">Delete</a>
							<a href="<spring:url value="/admin/department/editDepartment/${dep.departmentId}"/>" class="btn btn-success">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			<a href="<spring:url value="/admin/department/addDepartment" />" class="btn btn-primary">Add Department</a>

<%@ include file="commonTemplates/footer.jsp" %>