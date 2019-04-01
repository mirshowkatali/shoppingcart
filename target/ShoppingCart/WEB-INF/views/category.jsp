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
				<h1>Please select the Department </h1>
				
			</div>

			<table class="table table-striped table-hover rounded" >
				<thead>
					<tr class="bg-primary">
						<th>Department Name</th>
						
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dept}" var="dep">
						<tr>
							
							<td><a href="/ShoppingCart/admin/category/${dep.departmentId}">${dep.departmentName}</a></td>
																	
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			

<%@ include file="commonTemplates/footer.jsp" %>