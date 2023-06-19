<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="scripts.jsp" />
    <title>DAS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>
<jsp:include page="nav.jsp" />
    <div align="center">
        <div class="container">
            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="filters">
                        <label for="testSelect">Select Test:</label>
                        <select id="testSelect">
                            <option value="">All</option>
                            <option value="Blood Test">Blood Test</option>
                            <option value="X-ray">X-ray</option>
                            <option value="MRI SCAN">MRI SCAN</option>
                        </select>

                        <label for="dateInput">Select Date:</label>
                        <input type="date" id="dateInput">

                        <button onclick="applyFilters()">Apply Filters</button>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Recent Test</h5>
                            <img id="testStatusImage" src="https://www.cdc.gov/fungal/diseases/histoplasmosis/images/318301-A_WEB_FungalLandingPages_Histo_Diagnosis.jpg" style="width: 100px; height: 50px;" alt="Test Status" />
                        </div>
                        <div class="card-body">
                            <div class="test-details">
                                <p id="testName" class="card-text">Test: MRI SCAN</p>
                                <p id="testId" class="card-text">Test ID: 1</p>
                                <p id="testDate" class="card-text">Date: 16-06-2023</p>
                            </div>
                            <div class="view-link">
                                <a onclick="fun1()" href="#" id="viewLink">View Test</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            
        </div>
        <div class="container">
			<div class="card-container" align="center">
<div id="testDetailsTableContainer" style="display: none;">
  <table id="testDetailsTable" class="table table-bordered">
    <thead>
      <tr>
        <th>Test ID</th>
        <th>Test Name</th>
        <th>Method</th>
        <th>Price</th>
        <th>Report</th>
      </tr>
    </thead>
    <tbody id="testDetailsTableBody"></tbody>
  </table>
</div>
</div>
</div>
    </div>

    <style>
        .filters {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }

        .filters label {
            margin-right: 10px;
        }

        .filters select,
        .filters input[type="date"] {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .filters button {
            padding: 5px 10px;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
    
	


    <script>
   
    function loadTestDetails() {
        // Implement your logic to load test details here
        // Static data for demonstration
        var testDetails = [
            { id: 1, testName: "Blood Test", method: "Method 1", price: "$100", report: "https://www.lalpathlabs.com/SampleReports/Z289.pdf", date: "2023-06-16" },
            { id: 2, testName: "X-ray", method: "Method 2", price: "$200", report: "https://www.bir.org.uk/media/258608/mark_rodriguez_-_philips_trainee_for_excellence_-_unofficial_guide_to_radiology.pdf", date: "2023-06-15" },
            { id: 3, testName: "MRI SCAN", method: "Method 3", price: "$300", report: "https://vetoracle.com/wp-content/uploads/2019/11/MRI-and-CT-sample-report-3.pdf", date: "2023-06-14" }
        ];

        return testDetails;
    }

    function applyFilters() {
        var selectedTest = document.getElementById("testSelect").value;
        var selectedDate = document.getElementById("dateInput").value;

        var testDetails = loadTestDetails();

        var filteredTestDetails = testDetails;

        if (selectedTest) {
            filteredTestDetails = filteredTestDetails.filter(function(testDetail) {
                return testDetail.testName === selectedTest;
            });
        }

        else if (selectedDate) {
            filteredTestDetails = filteredTestDetails.filter(function(testDetail) {
                return testDetail.date === selectedDate;
            });
        }

        // Update the UI to display the filtered test details
        var testDetailsTableBody = document.getElementById("testDetailsTableBody");
        testDetailsTableBody.innerHTML = "";

        filteredTestDetails.forEach(function(testDetail) {
            var row = document.createElement("tr");
            var idColumn = document.createElement("td");
            idColumn.textContent = testDetail.id;
            var testNameColumn = document.createElement("td");
            testNameColumn.textContent = testDetail.testName;
            var methodColumn = document.createElement("td");
            methodColumn.textContent = testDetail.method;
            var priceColumn = document.createElement("td");
            priceColumn.textContent = testDetail.price;
            var reportColumn = document.createElement("td");
            var reportLink = document.createElement("a");
            reportLink.href = testDetail.report;
            reportLink.textContent = "Download PDF";
            reportColumn.appendChild(reportLink);
            row.appendChild(idColumn);
            row.appendChild(testNameColumn);
            row.appendChild(methodColumn);
            row.appendChild(priceColumn);
            row.appendChild(reportColumn);
            testDetailsTableBody.appendChild(row);
        });
        $('#testDetailsTableContainer').show();
    }





        function fun1() {
        	 var testDetails = [
 			    { id: 1, name: "MRI", method: "Magnetic Resonance Imaging", price: "$345" ,report:"https://www.lalpathlabs.com/SampleReports/Z289.pdf"},
 			    // Add more test details as needed
 			  ];

 			  // Clear any existing rows in the table
 			  $('#testDetailsTableBody').empty();

 			  // Iterate over the testDetails array and create table rows
 			  testDetails.forEach(function(detail) {
 			    var row = $('<tr>');
 			    row.append($('<td>').text(detail.id));
 			    row.append($('<td>').text(detail.name));
 			    row.append($('<td>').text(detail.method));
 			    row.append($('<td>').text(detail.price));
 			    var reportColumn = $('<td>');
 			    if (detail.report) {
 			    	
 			      var downloadLink = $('<a>').attr('href', detail.report).text('Download PDF');
 			      reportColumn.append(downloadLink);
 			    }
 			    row.append(reportColumn);
 			    row.append(reportColumn);
 			    $('#testDetailsTableBody').append(row);
 			  });

 			  // Show the table
 			  $('#testDetailsTableContainer').show();
 			}

    </script>
</body>
</html>
