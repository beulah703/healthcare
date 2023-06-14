<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<div class="container" align="center">
	<div class="row-md-12" >
		<div class="col-md-9">
			<h3 align="center">Booked Appointments</h3>
			<div class="row">
				<div class="col-md-2">
					<h5>From Date:</h5>
					<input type="date" class="form-control" id="fromDateFilter">
				</div>
				<div class="col-md-2">
					<h5>To Date:</h5>
					<input type="date" class="form-control" id="toDateFilter">
				</div>
				<div class="col-md-2">
					<h5>Specialization:</h5>
					<select class="form-control" id="specializationFilter">
						<option value="">All Specializations</option>
						<option value="specialization1">Specialization 1</option>
						<option value="specialization2">Specialization 2</option>
						<!-- Add more specialization options as needed -->
					</select>
				</div>
				<div class="col-md-2">
					<h5>Status:</h5>
					<select class="form-control" id="statusFilter">
						<option value="">All</option>
						<option value="active">Active</option>
						<option value="inactive">Inactive</option>
					</select>
				</div>
				<div class="col-md-2">
					<h5>Doctor:</h5>
						<select class="form-control" id="doctorFilter">
						<option value="">All Doctors</option>
						<option value="doctor1">Doctor 1</option>
						<option value="doctor2">Doctor 2</option>
						<!-- Add more doctor options as needed -->
					</select>
				</div>
			</div>
			</div>
			<div>
			<div class="row mt-12">
				<div class="col-md-12">
					<h3>All Appointments</h3>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Appointment ID</th>
								<th>Patient Name</th>
								<th>Doctor</th>
								<th>Date</th>
								<th>Specialization</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<!-- Add code to populate the table with appointments -->
							<tr>
								<td>1</td>
								<td>John Doe</td>
								<td>Doctor 1</td>
								<td>2023-06-10</td>
								<td>Specialization 1</td>
								<td>Active</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Jane Smith</td>
								<td>Doctor 2</td>
								<td>2023-06-11</td>
								<td>Specialization 2</td>
								<td>Inactive</td>
							</tr>
							<!-- Add more rows for each appointment -->
						</tbody>
					</table>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
</div>

			<%--<div class="row mt-4">
				
				<div class="col-md-6">
					<h3>Suspend Appointments & Refund the payment</h3>
					<!-- Add your code for suspending appointments and refunding payments here -->
					<form>
						<div class="form-group">
							<label for="appointmentId">Appointment ID:</label> <input
								type="text" class="form-control" id="appointmentId"
								name="appointmentId" placeholder="Enter Appointment ID">
						</div>
						<div class="form-group">
							<label for="reason">Reason for Suspension:</label> <input
								type="text" class="form-control" id="reason" name="reason"
								placeholder="Enter Reason for Suspension">
						</div>
						<div class="form-group">
							<label for="refundAmount">Refund Amount:</label> <input
								type="text" class="form-control" id="refundAmount"
								name="refundAmount" placeholder="Enter Refund Amount">
						</div>
						<button type="submit" class="btn btn-primary">Suspend and
							Refund</button>
					</form>
				</div>
			</div> 
			--%>
</body>
</html>
