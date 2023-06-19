<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="nav.jsp" %>

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
								onclick="booktestt()" data-dismiss="modal">Confirm Booking</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	


    <script>
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
        function booktestt() {
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
            document.getElementById("contact").value = "";
            document.getElementById("ptype").selectedIndex = 0;
            document.getElementById("pname").value = "";
            document.getElementById("page").value = "";
            document.getElementById("email").value = "";
            document.getElementById("gender").value = "";
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
                	console.log(success);
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

function totalbills(){
	   $.ajax({
           url: "./totalbills",
           type: "GET",
          data:{
        	  contact:contact2
          }
           success: function(response) {
           	
               console.log(response);
           },
           error: function(xhr, status, error) {
               console.log("Error: " + error);
           }
       });
}


</script>
</body>
</html>
