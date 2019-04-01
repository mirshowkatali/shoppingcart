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
				<h1>Category Page for department ${dept.departmentName}</h1>
				
			</div>

			<table class="table table-striped table-hover rounded" >
				<thead>
					<tr class="bg-primary">
						<th>Category Name</th>
						<th>Category Description</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cat}" var="dep">
						<tr>
							
							<td>${dep.cateogoryName}</td>
							<td>${dep.description}</td>
												
							<td>
							
							<a href="<spring:url value="/admin/category/viewCategory/${dep.categoryId}"/>" class="btn btn-success">View</a>
							<a href="<spring:url value="/admin/category/deleteCategory/${dep.categoryId}"/>" class="btn btn-danger">Delete</a>
							<a href="<spring:url value="/admin/category/editCategory/${dep.categoryId}"/>" class="btn btn-success">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			<a href="<spring:url value="/admin/category/addCategory" />" class="btn btn-primary">Add Category</a>

<%@ include file="commonTemplates/footer.jsp" %>