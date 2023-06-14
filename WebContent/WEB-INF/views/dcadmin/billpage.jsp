<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
								aria-haspopup="true" aria-expanded="false">DC Admin</button>
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
							<li class="nav-item"><a href="" class="nav-link"
								aria-current="page">Dashboard</a></li>
							<li><a href="gettestdetails"  class="nav-link " >Tests</a></li>
							<li><a href="booking" class="nav-link link-dark">Book Test</a></li>
							<li><a href="dcpatients" class="nav-link link-dark">Patients</a></li>
							
							<li><a href="DCReports" class="nav-link link-dark">Reports</a></li>
						</ul>
						<hr>
					</div>
				</div>
				<div class="col-md-9 ">

					<div class="card-container">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Total Tests</h5>
								<p class="card-text">10</p>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Total Users</h5>
								<p class="card-text">15</p>
							</div>
						</div>
						
						<!-- Add more doctors here -->
					</div>
					<div class="container doctor">
						<table class="table">
							<thead>
								<h3 align="center">Bill Reports</h3>
								<tr>
								<th>Bill Id</th>
									<th>Test</th>
									<th>Patient Name</th>
									<th>Age</th>
									<th>Gender</th>
									<th>Email</th>
									<th>Mobile Number</th>
						
								</tr>
							</thead>
							<tbody>
							
								<tr>
								
									<td></td>
									<td>diabetes</td>
								
									<td>Joe</td>
									<td>23</td>
									<td>Male</td>
									<td>joe77@gmail.com</td>
									<td>632899901</td>
									
								</tr>
								
								<tr>
									<td></td>
									<td>diabetes</td>
								
									<td>Joe</td>
									<td>23</td>
									<td>Male</td>
									<td>joe77@gmail.com</td>
									<td>632899901</td>
								</tr>
								<tr>
									<td></td>
									<td>diabetes</td>
								
									<td>Joe</td>
									<td>23</td>
									<td>Male</td>
									<td>joe77@gmail.com</td>
									<td>632899901</td>

								</tr>
								<tr>
									<td></td>
									<td>diabetes</td>
								
									<td>Joe</td>
									<td>23</td>
									<td>Male</td>
									<td>joe77@gmail.com</td>
									<td>632899901</td>
								</tr>
								<tr>
									<td></td>
									<td>diabetes</td>
								
									<td>Joe</td>
									<td>23</td>
									<td>Male</td>
									<td>joe77@gmail.com</td>
									<td>632899901</td>
								</tr>
								
								
								<!-- Add more rows here -->
							</tbody>
						</table>
					</div>
					
				<center>
		
				<form action="gettestdetails" method="get"><button >Add</button></form>
					  
					 <script src="index.js"></script>
		
		<script>
		function loadContent(page) {
			// Get the content div element
			var contentDiv = document.getElementById('content');

			// Load the content based on the selected page
			switch (page) {
				case 'dashboard':
					contentDiv.innerHTML = '<h2>Dashboard</h2><p>This is the default content of the dashboard page.</p>';
			}		break;
		}
</script>
		<script >
 
function doSubmit()
{
window.transfer("testspage.jsp");
}
 
</script>
</div>
</body>
</html>