<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Appointment</title>
<jsp:include page="scripts.jsp" />
</head>
<body>

<jsp:include page="nav.jsp" />
<div align="center">
<h3>Available Schedule on a specific date & time</h3>
					<!-- Add your code for displaying available schedules here -->
					<form>
						<div class="form-group">
							<label for="date">Date:</label> <input type="date"
								class="form-control" id="date" name="date">
						</div>
						<div class="form-group">
							<label for="time">Time:</label> <input type="time"
								class="form-control" id="time" name="time">
						</div>
						<!-- Add more fields for data entry as needed -->
						<button type="submit" class="btn btn-primary">Check
							Availability</button>
					</form>
			
				
					<h3>Book the appointment and make the payment</h3>
					<form>
						<div class="form-group">
							<label for="name">Full Name:</label> <input type="text"
								class="form-control" id="name" name="name"
								placeholder="Enter Full Name">
						</div>
						<div class="form-group">
							<label for="email">Email:</label> <input type="email"
								class="form-control" id="email" name="email"
								placeholder="Enter Email">
						</div>
						<!-- Add more fields for data entry as needed -->
						<button type="submit" class="btn btn-primary">Book
							Appointment</button>
					</form>
			
			
			
					<h3>Appointment for self or family member</h3>
					<form>
						<div class="form-group">
							<label for="patientName">Patient Name:</label> <input type="text"
								class="form-control" id="patientName" name="patientName"
								placeholder="Enter Patient Name">
						</div>
						<div class="form-group">
							<label for="relationship">Relationship:</label> <input
								type="text" class="form-control" id="relationship"
								name="relationship" placeholder="Enter Relationship">
						</div>
						<!-- Add more fields for data entry as needed -->
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
					</div>
</body>
</html>