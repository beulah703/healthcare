<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, spring.orm.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="scripts.jsp"/>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="nav.jsp" />

<div class="col-md-9">
    <h3 align="center">Payments View</h3>
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="text-center">
                <h5>Doctor Wise</h5>
                <select class="form-control" id="docFilter" onchange="getdocwisepay()">
                    <option value="main">All Doctors</option>
                   <c:forEach var="s" items="${docs}">
  <option value="${s.id}">${s.name}</option>
</c:forEach>
                    <!-- Add more test options as needed -->
                </select>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="text-center">
                <h5>Specialization Wise</h5>
                <select class="form-control" id="specFilter" onchange="getspecwisepay()">
                    <option value="main">All Specializations</option>
                  
                   <c:forEach var="s" items="${specs}">
  <option value="${s.id}">${s.title}</option>
</c:forEach>
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
                    <input type="date" class="form-control" id="startDateFilter" >
                </div>
                <div class="col-md-6">
                    <input type="date" class="form-control" id="endDateFilter" onchange="getdatewisepay()">
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-12">
            <table class="table table-bordered" id="patientTable">
                <thead>
                    <tr>
                        <th>Patient Id</th>
                        <th>Payment Mode</th>
                        <th>Payment Reference</th>
                        <th>Payment Amount</th>
                        <th>Payment Email</th>
                        <th>Payment Status</th>
                    </tr>
                </thead>
                <tbody id="patientTableBody">
                  
                   
                </tbody>
            </table>
        </div>
    </div>
</div>


<script>
function getspecwisepay() {
	  var spec = document.getElementById("specFilter").value;
	 console.log("sppec");
	  $.ajax({
		 
	    url: "./getspecwisepay",
	    method: "POST",
	    data: { spec:spec },
	    success: function(response) {
	    	var data = JSON.parse(response);
	    	  var tableBody = $('#patientTableBody');

	    	  // Clear any existing table rows
	    	  tableBody.empty();

	    	  // Iterate over the data and create table rows
	    	  data.forEach(function(appointment) {
	    	    var newRow = $('<tr>');
	    	    newRow.append($('<td>').text(appointment.appn_id));
	    	    //newRow.append($('<td>').text(appointment.appn_payMode));
	    	    //newRow.append($('<td>').text(appointment.paymentReference));
	    	    //newRow.append($('<td>').text(appointment.paymentAmount));

	    	    tableBody.append(newRow);
	    	  });
			
	    },
	    error: function(xhr, status, error) {
	      console.error("Error: " + error);
	    }
	  });
	}
function getdocwisepay() {
	  var doc = document.getElementById("docFilter").value;
	 console.log("sppec");
	  $.ajax({
		 
	    url: "./getdocwisepay",
	    method: "POST",
	    data: { doc:doc },
	    success: function(response) {
	    	var data = JSON.parse(response);
	    	  var tableBody = $('#patientTableBody');

	    	  // Clear any existing table rows
	    	  tableBody.empty();

	    	  // Iterate over the data and create table rows
	    	  data.forEach(function(appointment) {
	    	    var newRow = $('<tr>');
	    	    newRow.append($('<td>').text(appointment.appn_id));
	    	    //newRow.append($('<td>').text(appointment.appn_payMode));
	    	    //newRow.append($('<td>').text(appointment.paymentReference));
	    	    //newRow.append($('<td>').text(appointment.paymentAmount));

	    	    tableBody.append(newRow);
	    	  });
			
	    },
	    error: function(xhr, status, error) {
	      console.error("Error: " + error);
	    }
	  });
	}

function getspecdatewisepay() {
	  var spec = document.getElementById("specFilter").value;
	  var d1 = document.getElementById("startDateFilter").value;
	  var d2 = document.getElementById("endDateFilter").value;
	 console.log("sppec");
	  $.ajax({
		 
	    url: "./getspecdatewisepay",
	    method: "POST",
	    data: { spec:spec,
	    	dat:d1,
	    	date:d2},
	    success: function(response) {
	    	var data = JSON.parse(response);
	    	  var tableBody = $('#patientTableBody');

	    	  // Clear any existing table rows
	    	  tableBody.empty();

	    	  // Iterate over the data and create table rows
	    	  data.forEach(function(appointment) {
	    	    var newRow = $('<tr>');
	    	    newRow.append($('<td>').text(appointment.appn_id));
	    	    //newRow.append($('<td>').text(appointment.appn_payMode));
	    	    //newRow.append($('<td>').text(appointment.paymentReference));
	    	    //newRow.append($('<td>').text(appointment.paymentAmount));

	    	    tableBody.append(newRow);
	    	  });
			
	    },
	    error: function(xhr, status, error) {
	      console.error("Error: " + error);
	    }
	  });
	}
function getdatewisepay() {
	 
	  var d1 = document.getElementById("startDateFilter").value;
	  var d2 = document.getElementById("endDateFilter").value;
	 console.log("sppec");
	  $.ajax({
		 
	    url: "./getdatewisepay",
	    method: "POST",
	    data: {
	    	dat:d1,
	    	date:d2},
	    success: function(response) {
	    	console.log(response);
	    	var data = response;
	    	console.log(data);
	    	  var tableBody = $('#patientTableBody');

	    	  // Clear any existing table rows
	    	  tableBody.empty();

	    	  // Iterate over the data and create table rows
	    	  data.forEach(function(appointment) {
	    		  console.log(appointment.appn_id);
	    	    var newRow = $('<tr>');
	    	    newRow.append($('<td>').text(appointment.appn_id));
	    	    newRow.append($('<td>').text(appointment.appn_paymode));
	    	    newRow.append($('<td>').text(appointment.appn_payreference));
	    	    newRow.append($('<td>').text(appointment.appn_payamount));
	    	    newRow.append($('<td>').text(appointment.appn_email));
	    	    newRow.append($('<td>').text(appointment.appn_status));

	    	    tableBody.append(newRow);
	    	  });
			
	    },
	    error: function(xhr, status, error) {
	      console.error("Error: " + error);
	    }
	  });
	}
function getdocdatewisepay() {
	  var doc = document.getElementById("docFilter").value;
	  var d1 = document.getElementById("startDateFilter").value;
	  var d2 = document.getElementById("endDateFilter").value;
	// console.log("sppec");
	  $.ajax({
		 
	    url: "./getdocdatewisepay",
	    method: "POST",
	    data: { doc:doc,
	    	dat:d1,
	    	date:d2},
	    success: function(response) {
	    	var data = JSON.parse(response);
	    	  var tableBody = $('#patientTableBody');

	    	  // Clear any existing table rows
	    	  tableBody.empty();

	    	  // Iterate over the data and create table rows
	    	  data.forEach(function(appointment) {
	    	    var newRow = $('<tr>');
	    	    newRow.append($('<td>').text(appointment.appn_id));
	    	    //newRow.append($('<td>').text(appointment.appn_payMode));
	    	    //newRow.append($('<td>').text(appointment.paymentReference));
	    	    //newRow.append($('<td>').text(appointment.paymentAmount));

	    	    tableBody.append(newRow);
	    	  });
			
	    },
	    error: function(xhr, status, error) {
	      console.error("Error: " + error);
	    }
	  });
	}
</script>
 
</body>
</html>