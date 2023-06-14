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
    
</head>
<body>
    	<jsp:include page="nav.jsp" />
 

      
                <div class="col-md-9">
                    

            <center>        

                   <form action="generateBill" method="post">
                       
                            <h1>Book Test</h1>
                      


                        <div class="form-group">
                            <label for="test_category" class="form-label">Test Category</label>
                            <select name="test_category" id="test_category" class="form-control" required>
                                <option value="">Select Category</option>
                                <option value="Diabetes">Diabetes</option>
                                <option value="Blood Pressure">BP</option>
                                <option value="Cholesterol">Cholesterol</option>
                                <!-- Add more options here -->
                            </select>
                        </div>
                        <div class="form-group">

                            <label for="test_category" class="form-label">Test Booked</label>
                            <select name="test_name" id="test_name" name="test_name"class="form-control" required>
                                <option value="">Select test</option>
                                <option value="Diabetes">test1</option>
                                <option value="Blood Pressure">test2</option>
                                <option value="Cholesterol">test3</option>
                                <!-- Add more options here -->
                            </select>

  
            <div class="form-group">
                <label for="patient_name" class="form-label"> Patient Name</label>
                <input type="text" name="pname" id="pname" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="patient_age" class="form-label">Patient Age</label>
                <input type="number" name="page" id="page" class="form-control" required>
            </div>
            <div class="form-group">
    <label for="patient_gender" class="form-label">Gender</label>
    <div>
        <input type="radio" name="gender" id="male" value="male" required>
        <label for="male">Male</label>
    </div>
    <div>
        <input type="radio" name="gender" id="female" value="female" required>
        <label for="female">Female</label>
    </div>
<div class="form-group">
                <label for="patient_contact" class="form-label"> Contact Number</label>
                <input type="text" name="contact" id="contact" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="patient_contact" class="form-label"> Email</label>
                <input type="email" name="email" id="email" class="form-control" required>
            </div>
<center><button type="submit">Generate Bill</button></center>
                        </div>

                      
                       
                    </form>
                      </center>
                </div>
               
            </div>
        </div>
 <script>
            $(document).ready(function() {
                $('#test_category').change(function() {
                    var category = $(this).val();
                    if (category) {
                        $.ajax({
                            url: 'fetchtests', // Replace with your server-side endpoint to fetch test details based on category
                            type: 'POST',
                            data: { category: category },
                            dataType: 'json',
                            success: function(response) {
                            	 $('#test_name').empty();
                                 $('#test_name').append('<option value="">Select Test</option>');
                                 $.each(response, function(index, testName) {
                                     $('#test_name').append('<option value="' + testName + '">' + testName + '</option>');
                                 });
                             },
                            error: function(xhr, status, error) {
                                console.log(error);
                            }
                        });
                    } else {
                        $('#test_name').empty();
                        $('#test_name').append('<option value="">Select Test</option>');
                    }
                });
            });
        </script>
      
    </body>
</html>
