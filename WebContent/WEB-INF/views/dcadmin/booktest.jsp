<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
 <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
 
</head>
<body>
    <%@ include file="nav.jsp" %>
<div align="center">
		<div class="container">
    <div class="col-md-9">
        <center>
            <form>
                <h1>Book Test</h1>

                <div class="row mt-4">
                    <div class="col-md-6 offset-md-3">
                        <div class="text-center">
                            <h5>Categories select</h5>
                            <select class="form-control" id="category" onchange="getTest()">
                                <option value="main">All Categories</option>
                                <!-- Add more category options as needed -->
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col-md-6 offset-md-3">
                        <div class="text-center">
                            <h5>Tests select</h5>
                            <select class="form-control" id="test" onchange="updatePrice()">
                                <option value="main">All tests</option>
                                <!-- Add more test options as needed -->
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="tprice" class="form-label">Test Price</label>
                    <input type="text" name="tprice" id="tprice" class="form-control" required readonly>
                </div>
				<div>
				<label class="form-group" for="ptype" class="form-control">Select Patient Type</label><br>
					<select name="ptype" id="ptype">
						<option value="appn">APPN</option>
						<option value="outp">OUTP</option>
					</select>
				</div>
				
				<br>
				<div class="form-group">
                    <label for="pname" class="form-label">Patient Name</label>
                    <input type="text" name="pname" id="pname" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="page" class="form-label">Patient Age</label>
                    <input type="number" name="page" id="page" class="form-control" required>
                </div>

                <div class="form-group">
                    <label class="form-label">Gender</label>
                    <div>
                        <input type="radio" name="gender" id="gender" value="male" required>
                        <label for="male">Male</label>
                    </div>
                    <div>
                        <input type="radio" name="gender" id="gender" value="female" required>
                        <label for="female">Female</label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="contact" class="form-label">Contact Number</label>
                    <input type="text" name="contact" id="contact" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" name="email" id="email" class="form-control" required>
                </div>

               
            </form>
             <center>
                    <button onclick="preview()">Book</button>
                </center>
                <center>
                    <button onclick="totalbills()">Total Bill Details</button>
                </center>
        </center>
        <div class="modal fade" id="previewModal" tabindex="-1" role="dialog"
				aria-labelledby="previewModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="previewModalLabel">Preview
								Booking</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="bookingDetails">
							<!-- Dynamically populated with booking details -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"
								onclick="booktest()" data-dismiss="modal">Confirm Booking</button>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade" id="previewModal3" tabindex="-1" role="dialog"
     aria-labelledby="previewModalLabel" aria-hidden="true">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title" id="previewModalLabel">Receipt</h5>
                 <button type="button" class="close" data-dismiss="modal"
                         aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                 </button>
             </div>
             <div class="modal-body" id="bookingDetails3">
                 <!-- Dynamically populated with booking details -->
             </div>
             <div class="modal-footer">
                 <button type="button" class="btn btn-secondary"
                         data-dismiss="modal" onclick="window.print()">Print</button>
                 <button type="button" class="btn btn-primary"
                         onclick="downloadReceipt()">Download</button>
             </div>
         </div>
     </div>
</div>

			 <div class="modal fade" id="previewModal1" tabindex="-1" role="dialog"
				aria-labelledby="previewModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="previewModalLabel">Booked Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="bookingDetails1">
							<!-- Dynamically populated with booking details -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"
								onclick="payment()" data-dismiss="modal">Make Payment</button>
						</div>
					</div>
				</div>
			</div>
			 <div class="modal fade" id="previewModal2" tabindex="-1" role="dialog"
				aria-labelledby="previewModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="previewModalLabel">Invalid</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="bookingDetails2">
							<!-- Dynamically populated with booking details -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Ok</button>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	
</div>
</div>

    <script>
    function downloadReceipt() {
        // Get the content of the modal body
        var receiptContent = document.getElementById('bookingDetails3').innerHTML;

        // Create a temporary <a> element and set the download attribute
        var link = document.createElement('a');
        link.href = 'data:text/html;charset=utf-8,' + encodeURIComponent(receiptContent);
        link.download = 'receipt.html';

        // Programmatically trigger the download
        link.click();
    }

    var tests;
        $(document).ready(function() {
            var categories = JSON.parse('${cats}');
            var categorySelect = document.getElementById("category");
            var list=[];
            for (var i = 0; i < categories.length; i++) {
              list.push(categories[i].test_category);
              
            }
           
            const set = new Set(list);
            const uniqueList = Array.from(set);
            for (var i = 0; i < uniqueList.length; i++) {
                var option = document.createElement("option");
                option.value = uniqueList[i];
                option.text = uniqueList[i];
                categorySelect.appendChild(option);
            }
        });

        function getTest() {
            var category = document.getElementById("category").value;

            $.ajax({
                url: "./gettestbycat",
                type: "POST",
                data: { cat: category },
                success: function(response) {
                	
                    loadTests(response);
                },
                error: function(xhr, status, error) {
                    console.log("Error: " + error);
                }
            });
        }
        var contact2;
        function booktest() {
        	console.log("loog");
            var category = document.getElementById("category").value;
            var testSelect = document.getElementById("test").value;
            var priceField = document.getElementById("tprice").value;
            var contact= document.getElementById("contact").value;
            var type= document.getElementById("ptype").value;
            var name= document.getElementById("pname").value;
            contact2=contact;
            console.log(category);
            console.log(testSelect);
            console.log(priceField);
            console.log(contact);
            console.log("in booktest");
            document.getElementById("category").selectedIndex = 0;
            document.getElementById("test").selectedIndex = 0;
            document.getElementById("tprice").value = "";
           
            
           
            $.ajax({
                url: "./bookdctest",
                type: "POST",
                data: { 
                	cat: category,
                	test:testSelect,
                	price:priceField,
                	contact:contact,
                	type:type,
                	name:name
                	},
                success: function(response) {
                	console.log(response);
                     // Close the modal
                    // $('#previewModal').modal('hide');
                },
                error: function(xhr, status, error) {
                    console.log("Error: " + error);
                  
                    
                }
            });
        }

        function loadTests(tests) {
        	console.log(tests);
            var testSelect = document.getElementById("test");
            testSelect.innerHTML = "";

            for (var i = 0; i < tests.length; i++) {
                var option = document.createElement("option");
                option.value = tests[i].test_id;
                option.text = tests[i].test_name;
                testSelect.appendChild(option);
            }
          
        }
      


        function updatePrice() {
            var testSelect = document.getElementById("test").value;
            var priceField = document.getElementById("tprice");
console.log(testSelect);
            $.ajax({
                url: "./gettestprice",
                type: "POST",
                data: { test:testSelect },
                success: function(response) {
                	var data = JSON.parse(response);
                	console.log(data);
                	priceField.value = data;
                    
                },
                error: function(xhr, status, error) {
                    console.log("Error: " + error);
                }
            });
        }
    </script>
<script>
function preview() {
	var testSelect = document.getElementById("test");
	var selectedOptionText = testSelect.options[testSelect.selectedIndex].textContent;

    var priceField = $('#tprice').val();
    

	var bookingDetails = '<h3><strong>Test Confirm</strong></h3>';
	
	
    bookingDetails += '<p><strong>Test:</strong> ' + selectedOptionText + '</p>';
    bookingDetails += '<p><strong>Price:</strong> ' + priceField + '</p>';
 

    $('#bookingDetails').html(bookingDetails);
    $('#previewModal').modal('show');
}
var pdata;
function totalbills(){
	
	 var contact= document.getElementById("contact").value;
	
	 if(contact==""){
		  var bookingDetails = '<h3><strong>Enter Contact Number</strong></h3>';
		  $('#bookingDetails2').html(bookingDetails);
          $('#previewModal2').modal('show');
	 }
	//console.log(contact);
	else{
	   $.ajax({
           url: "./totalbills",
           type: "GET",
          data:{
        	  contact:contact
          },
           success: function(response) {
           	
                pdata=JSON.parse(response);           
               var bookingDetails = '<h3><strong>Total Bill - $' + pdata[pdata.length-1]+'</strong></h3>';
           	for(var i=0;i<pdata.length-1;i++){
           	
           	//console.log(data2);
          
               bookingDetails += '<p><strong>Test - Method - Price </strong> ' + pdata[i][0]+ '</p>';
              
           	}

               $('#bookingDetails1').html(bookingDetails);
               $('#previewModal1').modal('show');
           },
           error: function(xhr, status, error) {
               console.log("Error: " + error);
           }
       });
	}
}
function payment(){
	
	var billid=pdata[pdata.length-2];
	var amount=pdata[pdata.length-1];
	  var contact= document.getElementById("contact").value;
     
      var name= document.getElementById("pname").value;
      var email= document.getElementById("email").value;
      var gender= document.getElementById("gender").value;
	
	   $.ajax({
          url: "./testpayment",
          type: "POST",
         data:{
       	  billid:billid,
       	  amount:amount,
       	 currency:"$"
       	
       	 
       	  
         },
        
          success: function(response) {
        	  console.log("in pay");
        	  if (response.status == 'created') {
                  var options = {
                    "key": "rzp_test_j9AU4Na98kCuvD",
                    "amount": response.amount,
                    "currency": "INR",
                    "name": "RaphaHospital",
                    "description": "Test Transaction",
                    "image": "https://static.vecteezy.com/system/resources/thumbnails/006/817/240/small/creative-abstract-modern-clinic-hospital-logo-design-colorful-gradient-clinic-logo-design-free-vector.jpg",
                    "order_id": response.id,
                    "handler": function(response) {
                    	
                     payment_id=response.razorpay_payment_id.toString();
                      console.log(response.razorpay_payment_id);
                      console.log(response.razorpay_order_id);
                      console.log(response.razorpay_signature);
                     
                    },
                    "prefill": {
                      "name": "",
                      "email": "",
                      "contact": ""
                    },
                    "notes": {
                      "address": "Razorpay Corporate Office"
                    },
                    "theme": {
                      "color": "#3399cc"
                    }
                  };

                  var rzp1 = new Razorpay(options);
                  rzp1.on('payment.failed', function(response) {
                    console.log(response.error.code);
                    console.log(response.error.description);
                    console.log(response.error.source);
                    console.log(response.error.step);
                    console.log(response.error.reason);
                    console.log(response.error.metadata.order_id);
                    console.log(response.error.metadata.payment_id);
                    alert("Failed");
                    
                    window.location.href = "home";           
                    });

                  rzp1.open();
                }
        	 storedb();
        	
              },
              error: function(xhr, status, error) {
                // Handle the error response here
                console.log(xhr.responseText);
              }
            });
	  
	   var bookingDetails = '<h3><strong> Rapha Diagnostic Center </strong></h3>';    
       bookingDetails += '<h4><strong>Total Bill - $' + pdata[pdata.length-1]+'</strong></h4>';
    	for(var i=0;i<pdata.length-1;i++){
   
        bookingDetails += '<p><strong>Test - Method - Price </strong> ' + pdata[i][0]+ '</p>';
       
    	}
    	bookingDetails +='<p>Bill Id :>'+ticketNumber+'</p>';
    	 bookingDetails +='<p>Contact :>'+contact+'</p>';
    	 bookingDetails +='<p>Name :>'+name+'</p>';
    	 bookingDetails +='<p>Email :>'+email+'</p>';
    	 bookingDetails +='<p>Gender :>'+gender+'</p>';
    	  $('#bookingDetails3').html(bookingDetails);
         $('#previewModal3').modal('show');
    	 
          }
function storedb(){
    var contact= document.getElementById("contact").value;
  
	$.ajax({
        url: "./storedb",
        type: "POST",
        data:{
        	contact:contact,
        	
        },
        success: function(response) {
           	console.log(response);
        },
        error: function(xhr, status, error) {
            // Handle the error response here
            console.log(xhr.responseText);
          }
        });
      }

</script>
</body>
</html>