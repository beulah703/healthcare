<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

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

.table th,
.table td {
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
	<div>
		<nav class="navbar navbar-expand-lg navbar-lignt bg-success text-white">
			<a class="navbar-brand text-white" href="admin.html">Hospital Management System</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
				</ul>
				<ul class="navbar-nav mr-right">
					<li class="nav-right dropdown">
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle bg-gradient-success " type="button" id="dropdownMenuButton" style="background: #e9ecef; color: black" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">DC Admin</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="/profile">My Profile</a>
								<a class="dropdown-item" href="/settings">Settings</a>
								<a class="dropdown-item" href="/logout">Logout</a>
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
							<li class="nav-item"><a href="admin.html" class="nav-link"
								aria-current="page">Dashboard</a></li>
								
							<li><a href="Tests" class="nav-link " >Tests</a></li>
							<li><a href="booking" class="nav-link link-dark">Book Test</a></li>
							<li><a href="dcpatients" class="nav-link link-dark">Patients</a></li>
							
							<li><a href="DCReports" class="nav-link link-dark">Reports</a></li>
							

						</ul>
						<hr>
					</div>
				</div>

				<div class="col-md-9">
					<h3 align="center">Patients View</h3>
					<div class="row mt-4">
						<div class="col-md-6 offset-md-3">
							<div class="text-center">
								<h5>Test Wise</h5>
								<select class="form-control" id="doctorFilter" onchange="applyFilters()">
									<option value="">All Tests</option>
									<option value="Test 1">Test 1</option>
									<option value="Test 2">Test 2</option>
									<!-- Add more test options as needed -->
								</select>
							</div>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-md-6 offset-md-3">
							<h5>Between Dates</h5>
							<div class="row">
								<div class="col-md-6">
									<input type="date" class="form-control" id="startDateFilter" onchange="applyFilters()">
								</div>
								<div class="col-md-6">
									<input type="date" class="form-control" id="endDateFilter" onchange="applyFilters()">
								</div>
							</div>
						</div>
					</div>
					<div class="row mt-4">
						<div class="col-md-12">
							<table class="table table-bordered" id="patientTable" style="display: none;">
									<thead>
										<tr>
											<th>Report_Id</th>
											<th>Patient_id</th>
											<th>Test_id</th>
											<th>Test Name</th>
											<th>Payment Bills</th>
										</tr>
									</thead>
									<tbody id="patientTableBody">
										<!-- Table rows will be populated dynamically -->
									</tbody>
								</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script>
			// Dummy data for demonstration
			var dummyData = [
				{ serialNumber: 1, patientName: "John Doe", testName: "Test 1", date: "2023-06-01" },
				{ serialNumber: 2, patientName: "Jane Smith", testName: "Test 2", date: "2023-06-02" },
				{ serialNumber: 3, patientName: "David Johnson", testName: "Test 1", date: "2023-06-03" },
				{ serialNumber: 4, patientName: "Sarah Davis", testName: "Test 3", date: "2023-06-04" },
				{ serialNumber: 5, patientName: "Michael Brown", testName: "Test 2", date: "2023-06-05" },
			];

			function getFilteredRecords(doctor, startDate, endDate) {
				// Apply filtering logic here based on selectedDoctor, startDate, and endDate
				var filteredRecords = dummyData;

				// Filter based on Test Wise
				if (doctor) {
					filteredRecords = filteredRecords.filter(function (record) {
						return record.testName === doctor;
					});
				}

				// Filter based on Date Wise
				if (startDate && endDate) {
					filteredRecords = filteredRecords.filter(function (record) {
						return record.date >= startDate && record.date <= endDate;
					});
				}

				return filteredRecords;
			}

			function applyFilters() {
				// Get selected values from filters
				var selectedDoctor = document.getElementById("doctorFilter").value;
				var startDate = document.getElementById("startDateFilter").value;
				var endDate = document.getElementById("endDateFilter").value;

				// Perform filtering logic and populate the table
				var filteredRecords = getFilteredRecords(selectedDoctor, startDate, endDate);

				// Clear previous table rows
				document.getElementById("patientTableBody").innerHTML = "";

				// Populate the table with filtered records
				for (var i = 0; i < filteredRecords.length; i++) {
					var record = filteredRecords[i];

					// Create a new table row
					var row = document.createElement("tr");

					// Create table cells and populate them with record data
					var serialNumberCell = document.createElement("td");
					serialNumberCell.innerHTML = record.serialNumber;
					row.appendChild(serialNumberCell);

					var patientNameCell = document.createElement("td");
					patientNameCell.innerHTML = record.patientName;
					row.appendChild(patientNameCell);

					var testNameCell = document.createElement("td");
					testNameCell.innerHTML = record.testName;
					row.appendChild(testNameCell);

					var dateCell = document.createElement("td");
					dateCell.innerHTML = record.date;
					row.appendChild(dateCell);

					// Add the row to the table body
					document.getElementById("patientTableBody").appendChild(row);
				}

				// Show the table if there are filtered records, hide it otherwise
				document.getElementById("patientTable").style.display = filteredRecords.length > 0 ? "table" : "none";
			}
		</script>
	</body>
</html>