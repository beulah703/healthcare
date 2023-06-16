<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>DAS</title>

<jsp:include page="scripts.jsp" />
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div align="center">
		<div class="container">
			<div class="card-container" align="center">
				
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Todays Appointments Today</h5>
						<p id="toapp" class="card-text"></p>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Total Tests</h5>
						<p id="totest" class="card-text"></p>
					</div>
				</div>
				</div>
				
			<h3>Appointments</h3>
			<div class="row mt-4">
		<div class="col-md-12">
			<table class="table table-bordered" id="patientTable">
				<thead>
					<tr>
						<th>Appointment</th>

						<th>Doctor </th>
						<th>Date</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody id="apptable">


				</tbody>
			</table>
		</div>
	</div>
	</div>

			<h3>Diagnostic Tests</h3>
			<div class="row mt-4">
		<div class="col-md-12">
			<table class="table table-striped" id="teststable">
				<thead>
					<tr>
						<th>Test ID</th>
						<th>Test Name</th>
						<th>Date</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody  id="teststable">
				
				</tbody>
			</table>
		</div>
	</div>
	<script>

        $(document).ready(function() {
            // Retrieve the JSON data from the "tests" model attribute
        	$.ajax({
                url: "./getapptestcards", // Specify the URL of the controller method
                type: "GET", // Use POST or GET depending on your server-side implementation
               // Pass the patientId as data to the server
                success: function(response) {
                	var data = JSON.parse(response);

        	    	  // Iterate over the data and create table rows
        	    	 var toapp =document.getElementById("toapp");
        	    	 var totest =document.getElementById("totest");
        	    	 toapp.textContent = data[0];
        	    	
        	    	 
        	    	 totest.textContent=data[1];
        	    
						var tableBody = $('#apptable');
						var tableBody2 = $('#teststable');

						// Clear any existing table rows
						tableBody.empty();
						var count=0;
						for (var i = 2; i < data.length; i++) {
							var newRow = $('<tr>');
							for (var j = 0; j < 4; j++) {
						
						
						
						if(data[i].length==2){
						count=count+1;
						}
						else{
							newRow.append($('<td>').text(data[i][j]));
							tableBody.append(newRow);
						}
						
						
						}
						}
						console.log(count);
							for (var i =count; i < data.length; i++) {
								var newRow1 = $('<tr>');
							for (var k = 0; k < 2; k++) {
								
								console.log(data[i][0]);
								
								newRow1.append($('<td>').text(data[i][k]));
								
								//newRow.append($('<td>').text(data[i].status));
								tableBody2.append(newRow1);	
							
						}
						}
						
        	    },
        	    error: function(xhr, status, error) {
        	      console.error("Error: " + error);
        	    }
        	  });
        	  
        });
    </script>
</body>
</html>