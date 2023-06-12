<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, spring.mail.orm.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<style>
a {
	color: #000000;
	text-decoration: none;
	background-color: transparent;
}

.nav a:hover {
	color: #078344;
	text-decoration: none;
	border-style: solid;
	background-color: transparent;
}

.container {
	padding: 0px;
	margin: 0px;
}

.table {
	border: 1px solid #ccc;
	margin-top: 3px;
	margin-bottom: 3px;
}

.table th, .table td {
	border: 1px solid #ccc;
	padding: 2px;
}

.table thead th {
	background-color: #f0f0f0;
}

.card-container {
	white-space: nowrap;
	width: auto;
}

.card {
	display: inline-block;
	width: 300px;
	margin-right: 10px;
	margin-top: 10px;
}
</style>
</head>
<body>
<%List<testModel> slist =(List<testModel>)request.getAttribute("tests"); %>
	<div>
		<nav
			class="navbar navbar-expand-lg navbar-lignt bg-success text-white">
			<a class="navbar-brand text-white" href="#">Hospital Management
				System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">

				</ul>
				<ul class="navbar-nav mr-right">
					<li class="nav-right dropdown">
						<div class="dropdown">
							<button
								class="btn btn-secondary dropdown-toggle bg-gradient-success"
								type="button" id="dropdownMenuButton"
								style="background: #e9ecef; color: black" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">Admin</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="/profile">My Profile</a> <a
									class="dropdown-item" href="/settings">Settings</a> <a
									class="dropdown-item" href="/logout">Logout</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</nav>


		<div class="container">
			<div class="row">

				<div class="col-md-3">
					<div class="d-flex flex-column sidebar flex-shrink-0 p-3 bg-light"
						style="width: 280px; height: 700px">
						<ul class="nav nav-pills flex-column mb-auto">
							<li class="nav-item"><a href="dcscreen" class="nav-link"
								aria-current="page">Dashboard</a></li>

							<li><a href="tests" class="nav-link ">Tests</a></li>
							<li><a href="booking" class="nav-link link-dark">Book
									Test</a></li>
							<li><a href="dcpatients" class="nav-link link-dark">Patients</a></li>

							<li><a href="#" class="nav-link link-dark">Reports</a></li>
						</ul>
						<hr>
					</div>
				</div>
				<div class="col-md-9">


					<div class="container doctor">
						<table class="table">
							<thead>
								<h3 align="center">Test Details</h3>
								<tr>
									<th>Test Id</th>
									<th>Test Name</th>
									<th>Test Category</th>
									<th>Test Price</th>
									<th>Test Method</th>
									<th>From Range</th>
									<th>To Range</th>

								</tr>
							</thead>
							<% 
					for(testModel s:slist){
					%>
							<tbody>
								
									<tr>
										<td><%=s.getTestId() %></td>
							<td><%=s.getTestName() %></td>
							<td><%=s.getTestCategoryId() %></td>
							<td>
								<button class="btn btn-primary" onclick="getspec('<%=s.getTestId() %>')">Edit</button>
								<button class="btn btn-danger" >Delete</button>
							</td>
									</tr>
								
<%} %>
								<!-- Add more rows here -->
							</tbody>
						</table>

					</div>
					<center>
						<button id="btn">Add</button>
					</center>
					<form id="testform" style="display: none;" action="savetest"
						method="post">

						<center>
							<h1>New Test Details</h1>
						</center>


						<div class="form-group">
							<label for="test_name" class="form-label">Test Name</label> <input
								type="text" name="test_name" id="test_name" class="form-control"
								required>
						</div>

						<div class="form-group">
							<label for="test_category" class="form-label">Test
								category</label> <input type="text" name="test_category"
								id="test_category" class="form-control" required>
						</div>

						<div class="form-group">
							<label for="test_price" class="form-label">Test Price</label> <input
								type="text" name="test_price" id="test_price"
								class="form-control" required>
						</div>

						<div class="form-group">
							<label for="test_method" class="form-label">Method</label> <input
								type="text" name="test_method" id="test_method"
								class="form-control" required>
						</div>

						<div class="form-group">
							<label for="test_fromrange" class="form-label">Normal
								Range From</label> <input type="text" name="test_fromrange"
								id="test_fromrange" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="test_torange" class="form-label">Normal Range
								To</label> <input type="text" name="test_torange" id="test_torange"
								class="form-control" required>
						</div>

						<button type="submit" class="btn btn-primary btn-block">Add</button>

					</form>


				</div>



			</div>
		</div>
	</div>
	</div>

	<script>
		const btn = document.getElementById('btn');

		btn.addEventListener('click', () => {
		  const form = document.getElementById('testform');

		  if (form.style.display === 'none') {
		   
		    form.style.display = 'block';
		  } else {
		  
		    form.style.display = 'none';
		  }
		});</script>

</body>
</html>