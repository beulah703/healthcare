<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, spring.orm.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<jsp:include page="scripts.jsp" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="nav.jsp" />


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
                        <th>Payment Mode</th>
                        <th>Payment Reference</th>
                        <th>Payment Amount</th>
                    </tr>
                </thead>
                <tbody id="patientTableBody">
                    <!-- Table rows will be populated dynamically -->
                </tbody>
            </table>
        </div>
    </div>


       
<script>
    
    var dummyData=[];
    var slist = JSON.parse('${tests}');
    
    for (var i = 0; i < slist.length; i++) {
        var s = slist[i];
       
     
        var data = {
            PatientId: s.appn_patn_id,
            PaymentMode: s.appn_paymode,
            PaymentReference: s.appn_payreference,
            PaymentAmount: s.appn_payamount,
            date: s.appn_booked_Date,
            doctor:s.appn_doct_id
           
        };
       
        dummyData.push(data);
    }
    
    function getFilteredRecords1(startDate, endDate) {
        // Apply filtering logic here based on selectedDoctor,startDate, and endDate
        var filteredRecords = dummyData;
        console.log(filteredRecords);
       
        
        // Filter based on Date Wise
         if ( startDate && endDate!="") {
			filteredRecords = filteredRecords.filter(function (record) {
				console.log("i1") ;
				return(record.date >= startDate && record.date <= endDate)
				
			});
		}
         else if (startDate) {
        	 var filteredRecords = dummyData;
            filteredRecords = filteredRecords.filter(function (record) {
            	
              
                return record.date == startDate;
                
            });
        }
      
        return filteredRecords;
    }
   

    function applyFilters() {
        // Get selected values from filters
     
       
      
        var startDate = document.getElementById("startDateFilter").value;
        var endDate = document.getElementById("endDateFilter").value;
        var filteredRecords;
        // Perform filtering logic and populate the table
       
        filteredRecords = getFilteredRecords1(startDate, endDate);
        
       
        // Clear previous table rows
        document.getElementById("patientTableBody").innerHTML = "";

        // Populate the table with filtered records
        for (var i = 0; i < filteredRecords.length; i++) {
            var record = filteredRecords[i];

            // Create a new table row
            var row = document.createElement("tr");

            // Create table cells and populate them with record data
            var patientIdCell = document.createElement("td");
            patientIdCell.innerHTML = record.PatientId;
            row.appendChild(patientIdCell);

            var paymentModeCell = document.createElement("td");
            paymentModeCell.innerHTML = record.PaymentMode;
            row.appendChild(paymentModeCell);

            var paymentReferenceCell = document.createElement("td");
            paymentReferenceCell.innerHTML = record.PaymentReference;
            row.appendChild(paymentReferenceCell);

            var paymentAmountCell = document.createElement("td");
            paymentAmountCell.innerHTML = record.PaymentAmount;
            row.appendChild(paymentAmountCell);

            // Add the row to the table body
            document.getElementById("patientTableBody").appendChild(row);
        }

        // Show the table if there are filtered records, hide it otherwise
        document.getElementById("patientTable").style.display = filteredRecords.length > 0 ? "table" : "none";
    }
   
</script>
 
</body>
</html>