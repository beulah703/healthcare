<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointments</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div align="center">
		<h1>Appointment Reschedule</h1>

		<form id="rescheduleForm">
			<div>
				<label for="appointmentId">Appointment ID:</label> <input
					type="text" id="appointmentId" name="appointmentId" readonly>
			</div>

			<div>
				<label for="newDate">New Date:</label> <input type="date"
					id="newDate" name="newDate" required>
			</div>

			<div>
				<label for="newTime">New Time:</label> <input type="time"
					id="newTime" name="newTime" required>
			</div>

			<div>
				<label for="reason">Reason for Rescheduling:</label>
				<textarea id="reason" name="reason" required></textarea>
			</div>

			<button type="submit">Reschedule Appointment</button>
		</form>

		<script>
			// Retrieve the appointment ID from the query parameter
			const urlParams = new URLSearchParams(window.location.search);
			const appointmentId = urlParams.get('appointmentId');

			// Set the appointment ID in the form field
			document.getElementById('appointmentId').value = appointmentId;

			// Add event listener for form submission
			document.getElementById('rescheduleForm').addEventListener(
					'submit', function(event) {
						event.preventDefault();
						// Logic to handle form submission and reschedule the appointment
						rescheduleAppointment(appointmentId);
					});

			function rescheduleAppointment(appointmentId) {
				// Logic to handle rescheduling the appointment
				const newDate = document.getElementById('newDate').value;
				const newTime = document.getElementById('newTime').value;
				const reason = document.getElementById('reason').value;

				// Perform necessary actions with the appointment ID, new date, new time, and reason
				// For example, make an API call to update the appointment record in the database

				// Redirect to a success page or display a success message
				window.location.href = "reschedule-success.html";
			}
		</script>
		</div>
</body>
</html>
