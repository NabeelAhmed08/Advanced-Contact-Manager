<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet"  type= "text/css" href="webjars/bootstrap/css/bootstrap.min.css"/>
<title>Contacts</title>
</head>
<body>
<header><nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="#">Contact App</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="/contact-app">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action ="searchbyname">
      <input class="form-control mr-sm-2" type="search" name="name" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav></header>
  <h1> ${msg} </h1>
All Contacts displayed here
<div class ="container" >
<table class = "table table-striped">
	<thead class="thead-dark">
		<tr>
		<th>S.No</th>
		
			<th>Name</th>
			<th>Phone Number</th>
			<th>Delete</th>
		</tr>
		</thead>
		<% int i = 1; %> 
		<c:forEach items="${model.contact}" var = "e">
			<tr>
				 <td><%= i %> <% i++; %></td> 
				<td>${e.name}</td>
				<td>${e.pno}</td>
				<td><a type ="button" class ="btn btn-warning" href="deleteById?id=${e.id}" >Delete</a></td>
			</tr>
		</c:forEach>	
</table>
</div>
<script src="webjars/bootstrap/js/bootstrap.min.js" ></script>
   <script src="webjars/jquery/jquery.min.js" ></script>
</body>
</html>