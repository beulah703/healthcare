<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Profile</title>

<jsp:include page="../admin/scripts.jsp" />
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 550px;
	margin: 0 auto;
	padding: 10px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

h3 {
	text-align: center;
	margin-bottom: 16px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

input[type="text"], input[type="tel"], textarea {
	width: 100%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 2px;
	box-sizing: border-box;
	margin-bottom: 5px;
}

textarea {
	resize: vertical;
}

button[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button[type="submit"]:hover {
	background-color: #45a049;
}
</style>

</head>
<body>

	<jsp:include page="nav.jsp" />

	<div class="container">
		<h3>Patient Profile Update Form</h3>

		<form id="profileUpdateForm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="patientIdInput">Patient ID:</label> <input type="tel"
					id="patientIdInput" required>
			</div>
			<div class="form-group">
				<label for="appointmentIdInput">Appointment ID:</label> <input
					type="tel" id="appointmentIdInput" required>
			</div>
			<div class="form-group">
				<label for="parameterInput">Parameter:</label> <input type="text"
					id="parameterInput" required>
			</div>
			<div class="form-group">
				<label for="groupInput">Blood Group:</label> <input type="text"
					id="groupInput" required>
			</div>
	
			<div class="form-group">
				<label for="referralsTextarea">Next Appointment:</label>
				<input type="date" name="nextAppDate">
			</div>
			<div class="form-group">
				<label for="reportsInput">Upload Prescriptions:</label> <input type="file"
					id="reportsInput" multiple>
			</div>
			<div class="form-group">
				<button type="submit">Update Profile</button>
			</div>
		</form>
	</div>

</body>
</html>
