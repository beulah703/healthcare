<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            color: #000;
            background: #f8f9fa;
            font-family: 'Roboto', sans-serif;
        }

        .container {
            max-width: 400px;
            margin-top: 100px;
        }

        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h4 class="mb-4">Register</h4>
    <form action="saveregister" method="post">
        <div class="form-group">
            <label for="role">Role</label>
            <input type="hidden" name="role" value="Patient">
            <input type="text" class="form-control" value="Patient" readonly>
        </div>

        <div class="form-group">
            <label for="name" class="form-label">Patient Name</label>
            <input type="text" name="name" id="name" class="form-control">
        </div>
        <div class="form-group">
            <label for="mail" class="form-label">Patient Mail</label>
            <input type="email" name="mail" id="mail" class="form-control">
        </div>
        <div class="form-group">
            <label for="pass" class="form-label">Password</label>
            <input type="password" name="pass" id="pass" class="form-control">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
