<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script>


	function dashboard() {
		console.log("click");
		$.ajax({
			url : "/AppointmentForm/admin/dashboard",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
	
	function getpatientprofile()
	{
		$.ajax({
			url : "/AppointmentForm/admin/getpatient",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
	function bookedapp()
	{
		$.ajax({
			url : "/AppointmentForm/admin/dashboard",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
	function doctor() {
		console.log("hello");
		$.ajax({
			url : "../admin/doctors",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
	function specialization() {
		console.log("click");
		$.ajax({
			url : "/AppointmentForm/admin/specialization",
			success : function(result) {
				$("#disp").html(result);
			}
		});

	}
	
	function getbookedapp() 
	{
		$.ajax({
			url : "/AppointmentForm/admin/getbookapp",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
	function getnewapp() 
	{
		$.ajax({
			url : "/AppointmentForm/admin/getnewbookapp",
			success : function(result) {
				$("#disp").html(result);
			}
		});
		
	}
	
	function getpayments() 
	{
		$.ajax({
			url : "/AppointmentForm/admin/getpaymets",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
	
	function getreports() 
	{
		$.ajax({
			url : "/AppointmentForm/admin/getreports",
			success : function(result) {
				$("#disp").html(result);
			}
		});
	}
</script>
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

.nav-link dropdown-toggle {
	color: #078344;
	text-decoration: none;
	border-style: solid;
	background-color: transparent;
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

		<nav
			class="navbar navbar-expand-lg navbar-lignt bg-success text-white">
			<a class="navbar-brand text-white" href="./">Hospital Management
				System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<ul class="nav nav-pills flex-row mb-auto">
							<li class="nav-item"><a href="./" 
								class="nav-link" aria-current="page">Dashboard</a></li>
								<li><a href="gettestdetails" class="nav-link">Tests</a></li>
								<li><a href="booking" class="nav-link">Book Test</a></li>
							<li><a href="dcpatients" class="nav-link" >Patients</a></li>
							<li><a href="DCReports" class="nav-link">Reports</a></li>

							
						</ul>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">

				</ul>
				<ul class="navbar-nav mr-right">
					<li class="nav-right dropdown">
						<div class="dropdown">
							<button 
								class="btn btn-secondary dropdown-toggle bg-gradient-success "
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
</body>
</html>