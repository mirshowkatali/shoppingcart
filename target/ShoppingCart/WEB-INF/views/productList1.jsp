<%@include file="commonTemplates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<script>
$(document).ready(function(){
    var searchCondition = '${searchCondition}';

    $('.table').DataTable({
        "lengthMenu": [[5,10,-1], [5,10, "All"]],
        "oSearch": {"sSearch": searchCondition}
    });
});
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("active");
});

function save(){
var sel = document.getElementById("selectedRecord");
var sv = sel.value;
sessionStorage.setItem("color", sv);
}

function save1(){
	var sel = document.getElementById("selectedRecord1");
	var sv = sel.value;
	sessionStorage.setItem("size", sv);
	}
</script>
<style>
.row{
    margin-left:0px;
    margin-right:0px;
}

#wrapper {
    padding-left: 70px;
    transition: all .4s ease 0s;
    height: 100%
}

#sidebar-wrapper {
    margin-left: -150px;
    left: 70px;
    width: 150px;
    background: #222;
    position: fixed;
    height: 100%;
    z-index: 10000;
    transition: all .4s ease 0s;
}

.sidebar-nav {
    display: block;
    float: left;
    width: 150px;
    list-style: none;
    margin: 0;
    padding: 0;
}
#page-content-wrapper {
    padding-left: 0;
    margin-left: 0;
    width: 100%;
    height: auto;
}
#wrapper.active {
    padding-left: 150px;
}
#wrapper.active #sidebar-wrapper {
    left: 150px;
}

#page-content-wrapper {
  width: 100%;
}

#sidebar_menu li a, .sidebar-nav li a {
    color: #999;
    display: block;
    float: left;
    text-decoration: none;
    width: 150px;
    background: #252525;
    border-top: 1px solid #373737;
    border-bottom: 1px solid #1A1A1A;
    -webkit-transition: background .5s;
    -moz-transition: background .5s;
    -o-transition: background .5s;
    -ms-transition: background .5s;
    transition: background .5s;
}
.sidebar_name {
    padding-top: 25px;
    color: #fff;
    opacity: .7;
}

.sidebar-nav li {
  line-height: 40px;
  text-indent: 20px;
}

.sidebar-nav li a {
  color: #999999;
  display: block;
  text-decoration: none;
}

.sidebar-nav li a:hover {
  color: #fff;
  background: rgba(255,255,255,0.2);
  text-decoration: none;
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
  text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
  height: 65px;
  line-height: 60px;
  font-size: 18px;
}

.sidebar-nav > .sidebar-brand a {
  color: #999999;
}

.sidebar-nav > .sidebar-brand a:hover {
  color: #fff;
  background: none;
}

#main_icon
{
    float:right;
   padding-right: 65px;
   padding-top:20px;
}
.sub_icon
{
    float:right;
   padding-right: 65px;
   padding-top:10px;
}
.content-header {
  height: 65px;
  line-height: 65px;
}

.content-header h1 {
  margin: 0;
  margin-left: 20px;
  line-height: 65px;
  display: inline-block;
}

@media (max-width:767px) {
    #wrapper {
    padding-left: 70px;
    transition: all .4s ease 0s;
}
#sidebar-wrapper {
    left: 70px;
}
#wrapper.active {
    padding-left: 150px;
}
#wrapper.active #sidebar-wrapper {
    left: 150px;
    width: 150px;
    transition: all .4s ease 0s;
}
}

</style>
	<div id="wrapper" class="active">
      
      <!-- Sidebar -->
            <!-- Sidebar -->
      <div id="sidebar-wrapper">
      <ul id="sidebar_menu" class="sidebar-nav">
           <li class="sidebar-brand"><a id="menu-toggle" href="/ShoppingCart/">Department<span id="main_icon" class="glyphicon glyphicon-align-justify"></span></a></li>
      </ul>
        <ul class="sidebar-nav" id="sidebar">   
        <c:forEach items="${dept}" var="dep">  
          <li><a href="/ShoppingCart/product/category/${dep.departmentId }" >${dep.departmentName}<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
          </c:forEach>
          </ul>
      
      
      
      <!-- Sidebar -->
            <!-- Sidebar -->
      <div>      <ul id="sidebar_menu" class="sidebar-nav">
           <li class="sidebar-brand"><a id="menu-toggle" href="/ShoppingCart/">Category<span id="main_icon" class="glyphicon glyphicon-align-justify"></span></a></li>
      </ul>
        <ul class="sidebar-nav" id="sidebar">   
        <c:forEach items="${cat}" var="cat">  
          <li><a href="/ShoppingCart/product/category1/${cat.categoryId }" >${cat.cateogoryName}<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
          </c:forEach>
          </ul>
      </div> 
      </div>   
      <!-- Page content -->
      <div id="page-content-wrapper">
        <!-- Keep all page content within the page-content inset div! -->
        <div class="page-content inset">
          <div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>All Products</h1>
				<p>Checkout all products available in our shopping cart</p>
			</div>

			<table class="table table-striped table-hover rounded" >
				<thead>
					<tr class="bg-primary">
						<th>thumbNail</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Color</th>
						<th>Size</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<% List<Object> bcm=(List<Object>) session.getAttribute("attribValue");
				List<Object> bcm1=(List<Object>) session.getAttribute("attribValue1");
				
				%>
					<c:forEach items="${products}" var="product">
					
						<tr>
							<td><img src="<c:url value="/resources/images/${product.image} "/>" alt="image" style="width:128px;height:128px;"></td>
							<td>${product.name}</td>
							<td>${product.price} USD</td>
							<td> <select id="selectedRecord" name="selectedRecord" onchange="save()">

            <%
    for (int i=0; i<bcm.size(); i++){
    	Object[] row = (Object[]) bcm.get(i);	
 	 	   
    %> 						
                <option value="<%=row[2] %>"><%=row[2] %></option>

         
          
          <%
    }
          %>
		</select>
		</td>
<td> <select id="selectedRecord1" name="selectedRecord1" onchange="save1()">

            <%
    for (int i=0; i<bcm1.size(); i++){
    	Object[] row = (Object[]) bcm1.get(i);	
 	 	   
    %> 						
                <option value="<%=row[2] %>"><%=row[2] %></option>

         
          
          <%
    }
          %>
		</select>
		</td>
							<td>
							
							<a href="<spring:url value="/product/viewProduct/${product.id}"/>" class="btn btn-success">View</a>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
      </div>
      
    </div>
	
			

<%@ include file="commonTemplates/footer.jsp" %>