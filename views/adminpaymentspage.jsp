<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, spring.mail.orm.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
                <select class="form-control" id="testFilter" onchange="applyFilters1()">
                    <option value="main">All Doctors</option>
                   
                    <!-- Add more test options as needed -->
                </select>
            </div>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="text-center">
                <h5>Specialization Wise</h5>
                <select class="form-control" id="specFilter" onchange="applyspecFilters()">
                    <option value="main">All Specializations</option>
                   
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
                    <input type="date" class="form-control" id="startDateFilter" onchange="applyFilters3()">
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
</div>
<script>
        $(document).ready(function() {
            // Retrieve the JSON data from the "tests" model attribute
            //var tests = JSON.parse('${tests}');
            var slist1 = JSON.parse('${docs}');
           

            // Get the select element
            var select = document.getElementById("testFilter");

            // Create options and append them to the select element
            for (var i = 0; i < slist1.length; i++) {
                var option = document.createElement("option");
                
                option.value = slist1[i].doc_id;
                option.text =  slist1[i].doc_name+" "+slist1[i].doc_id  ;
                select.appendChild(option);
            }
        });
    </script>
    <script>
        $(document).ready(function() {
            // Retrieve the JSON data from the "tests" model attribute
            //var tests = JSON.parse('${tests}');
            var slist2 = JSON.parse('${specs}');
           

            // Get the select element
            var select = document.getElementById("specFilter");

            // Create options and append them to the select element
            for (var i = 0; i < slist2.length; i++) {
                var option = document.createElement("option");
                
                option.value = slist2[i].specId;
                option.text =  slist2[i].specTitle;
                select.appendChild(option);
            }
        });
    </script>
<script>
    var dummyData1 = [];
    var dummyData = [];
    var OriginaldummyData=[];
    var slist = JSON.parse('${tests}');
    var slist1 = JSON.parse('${docs}');
    var slist2 = JSON.parse('${specs}');
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
       
        OriginaldummyData.push(data);
    }
    for (var i = 0; i < slist1.length; i++) {
    var s1 = slist1[i];
    for (var j = 0; j < slist.length; j++) {
        var s = slist[j];
       
    var data1 = {
            
            doctor:s1.doc_id,
            docname:s1.doc_name,
            docspec: s1.spec_id,
            PatientId: s.appn_patn_id,
            PaymentMode: s.appn_paymode,
            PaymentReference: s.appn_payreference,
            PaymentAmount: s.appn_payamount,
            date: s.appn_booked_Date,
            //doctor:s.appn_doct_id
           
           
        };
       
        dummyData.push(data1);
    }
    }
    
    for (var i = 0; i < slist2.length; i++) {
    	 var s2 = slist2[i];
    	 for (var j = 0; j < slist1.length; j++) {
    		   var s1 = slist1[j];
    		   for (var k = 0; k < slist.length; k++) {
    		        var s = slist[k];
    		       
       
        var data2 = {
                
                specid:s2.specId,
                specTitle:s2.specTitle,
                doctorid:s1.doc_id,
                docname:s1.doc_name,
                docspec: s1.spec_id,
                PatientId: s.appn_patn_id,
                PaymentMode: s.appn_paymode,
                PaymentReference: s.appn_payreference,
                PaymentAmount: s.appn_payamount,
                date: s.appn_booked_Date,
                doctor:s.appn_doct_id
               
               
            };
           
            dummyData1.push(data2);
        }
    	 }
    }

    function getFilteredRecords1(startDate, endDate) {
        // Apply filtering logic here based on selectedDoctor,startDate, and endDate
        var filteredRecords = dummyData;
        console.log(filteredRecords);
        var selectedDoctor = document.getElementById("testFilter").value;
        
        // Filter based on Date Wise
         if (selectedDoctor!="main" && startDate && endDate) {
			filteredRecords = filteredRecords.filter(function (record) {
				console.log("i1") ;
				return(record.doctor == selectedDoctor && record.date >= startDate && record.date <= endDate)
				
			});
		}
         else if (startDate && endDate) {
        	 var filteredRecords = OriginaldummyData;
            filteredRecords = filteredRecords.filter(function (record) {
            	
              
                return record.date >= startDate && record.date <= endDate;
                
            });
        }
      
        return filteredRecords;
    }
    function getFilteredRecordsSpec(spec) {
        // Apply filtering logic here based on selectedDoctor, startDate, and endDate
        
       
        console.log(filteredRecords);
     
        var spec = document.getElementById("specFilter").value;
        // Filter based on Date Wise
        if (spec=="main") {
        	 var filteredRecords = OriginaldummyData;
			
				return filteredRecords;
				
		}
        else if (spec) {
        	 var filteredRecords = dummyData1;
			filteredRecords = filteredRecords.filter(function (record) {
		      console.log(record.docspec);
				return(record.specid == spec && record.specid == record.docspec && record.doctorid == record.doctor)
				
			});
		}
         
      
        return filteredRecords;
    }
    function getFilteredRecords2(startDate) {
        // Apply filtering logic here based on selectedDoctor, startDate, and endDate
        var selectedDoctor = document.getElementById("testFilter").value;
        var endDate = document.getElementById("endDateFilter").value;
        var filteredRecords = dummyData;
        console.log(filteredRecords);
        if (selectedDoctor && startDate && endDate) {
			filteredRecords = filteredRecords.filter(function (record) {
				console.log("i1") ;
				return(record.doctor == selectedDoctor && record.date >= startDate && record.date <= endDate)
				
			});
		}
        else if(selectedDoctor && startDate){
        	filteredRecords = filteredRecords.filter(function (record) {
        		console.log(record);
        		
        		return(record.doctor == selectedDoctor && record.date == startDate);
        	});
        }
        // Filter based on Date Wise
        else if (startDate) {
        	var filteredRecords = OriginaldummyData;
            filteredRecords = filteredRecords.filter(function (record) {
            	//console.log(record.date.split(" "););
            	
             
                return record.date == startDate ;
                
                
            });
        }
        return filteredRecords;
    }
    
    
   
    function getFilteredRecords(doctor) {
        // Apply filtering logic here based on selectedDoctor, startDate, and endDate
        var filteredRecords = dummyData;
        console.log(filteredRecords);
      //  console.log(filteredRecords.length);
        var startDate = document.getElementById("startDateFilter").value;
        var endDate = document.getElementById("endDateFilter").value;
        // Filter based on Doctor Wise
        if(doctor=="main"){
        	var filteredRecords = OriginaldummyData;
        	return filteredRecords;
        }
        else if (doctor && startDate && endDate) {
					filteredRecords = filteredRecords.filter(function (record) {
						console.log("i1") ;
						return(record.doctor == doctor && record.date >= startDate && record.date <= endDate)
						
					});
				}
       else if(doctor){
    	   filteredRecords = filteredRecords.filter(function (record) {
    		   console.log("i2") ;
    		   return record.doctor == doctor;
       });

     
       }
      
        return filteredRecords;
        
     
    }

    function applyFilters() {
        // Get selected values from filters
        var selectedDoctor = document.getElementById("testFilter").value;
       
      
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
    function applyspecFilters() {
        // Get selected values from filters
         var spec = document.getElementById("specFilter").value;
        
        var filteredRecords;
        // Perform filtering logic and populate the table
       
        filteredRecords = getFilteredRecordsSpec(spec);
        
       
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
    function applyFilters3() {
        // Get selected values from filters
      
        var startDate = document.getElementById("startDateFilter").value;
       
        var filteredRecords;
        // Perform filtering logic and populate the table
       
        filteredRecords = getFilteredRecords2(startDate);
        
       
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
    function applyFilters1() {
        // Get selected values from filters
        var selectedDoctor = document.getElementById("testFilter").value;
      
        var docid=selectedDoctor.split(" ");
        var sd=docid[0];
        console.log(sd);
        // Perform filtering logic and populate the table
        var filteredRecords = getFilteredRecords(sd);

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
