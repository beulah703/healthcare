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
            <a class="navbar-brand text-white" href="#">Hospital Management System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                </ul>
                <ul class="navbar-nav mr-right">
                    <li class="nav-right dropdown">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle bg-gradient-success" type="button" id="dropdownMenuButton"
                                style="background: #e9ecef; color: black" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin</button>
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
                    <div class="d-flex flex-column sidebar flex-shrink-0 p-3 bg-light" style="width: 280px; height: 700px">
                        <ul class="nav nav-pills flex-column mb-auto">
                            <li><a href="tests" class="nav-link " >Tests</a></li>
							<li><a href="booking" class="nav-link link-dark">Book Test</a></li>
							<li><a href="dcpatients" class="nav-link link-dark">Patients</a></li>
							
							<li><a href="DCReports" class="nav-link link-dark">Reports</a></li>
                        </ul>
                        <hr>
                    </div>
                </div>
                <div class="col-md-9">
                    

                  

                   <form action="generateBill" method="post">
                        <center>
                            <h1>Book Test</h1>
                        </center>


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