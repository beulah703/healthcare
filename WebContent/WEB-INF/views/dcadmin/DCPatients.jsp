<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">


</head>

<body>
	<jsp:include page="nav.jsp" />
	


				<div class="col-md-9">
					<h3 align="center">Patients View</h3>
					<div class="row mt-4">
						<div class="col-md-6 offset-md-3">
							<div class="text-center">
								<h5>Test Wise</h5>
								<select class="form-control" id="testFilter" onchange="applyFilters()">
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
											<th>Patient Id</th>
											<th>Patient Name</th>
											<th>Test Name</th>
											<th>Test category</th>
											<th>Method</th>
											<th>Patient value</th>
											<th>Price</th>
											<th>Date</th>
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
				{ PatientId: 1, patientName: "John Doe", testName: "Test 1",Testcatgory:"C1", Method:"Radio Scan", Patientvalue: "10",Price:"200", date: "2023-06-01" },
				{ PatientId: 2, patientName: "Jane Smith", testName: "Test 2",Testcatgory: "C1", Method: "Radio Scan",Patientvalue: "10", Price:"200", date: "2023-06-02" },
				{ PatientId: 3, patientName: "David Johnson", testName: "Test 1",Testcatgory: "C1", Method: "Radio Scan",Patientvalue: "10",Price:"200", date: "2023-06-03" },
				{ PatientId: 4, patientName: "Sarah Davis", testName: "Test 3", Testcatgory: "C1", Method: "Radio Scan",Patientvalue: "10",Price:"200", date:"2023-06-04" },
				{ PatientId: 5, patientName: "Michael Brown", testName: "Test 2", Testcatgory: "C1", Method:"Radio Scan", Patientvalue:"10", Price:"200", date:"2023-06-05" },
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
				var selectedDoctor = document.getElementById("testFilter").value;
				var startDate = document.getElementById("startDateFilter").value;
				var endDate = document.getElementById("endDateFilter").value;

				// Perform filtering logic and populate the table
				var filteredRecords = getFilteredRecords(selectedDoctor, startDate, endDate);

				// Clear previous table rows
				document.getElementById("patientTableBody").innerHTML = "";
				
				console.log("Hello");

				// Populate the table with filtered records
				for (var i = 0; i < filteredRecords.length; i++) {
					var record = filteredRecords[i];

					// Create a new table row
					var row = document.createElement("tr");

					// Create table cells and populate them with record data
					var serialNumberCell = document.createElement("td");
					serialNumberCell.innerHTML = record.PatientId;
					row.appendChild(serialNumberCell);

					var patientNameCell = document.createElement("td");
					patientNameCell.innerHTML = record.patientName;
					row.appendChild(patientNameCell);

					var testNameCell = document.createElement("td");
					testNameCell.innerHTML = record.testName;
					row.appendChild(testNameCell);

					var testCategory = document.createElement("td");
					testCategory.innerHTML = record.Testcatgory;
					row.appendChild(testCategory);
					
					var testMethod = document.createElement("td");
					testMethod.innerHTML = record.Method;
					row.appendChild(testMethod);
					
					var testPatientvalue = document.createElement("td");
					testPatientvalue.innerHTML = record.Patientvalue;
					row.appendChild(testPatientvalue);
					
					
					var testPrice= document.createElement("td");
					testPrice.innerHTML = record.Price;
					row.appendChild(testPrice);
					
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