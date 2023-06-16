<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, spring.orm.model.entity.*" %>

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
			<div class="row-md-12">
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
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<!-- Add code to populate the table with appointments -->

									<c:forEach items = "${aplist }"  var = "appointment">
										<tr>
										
										<td>${appointment.appn_id }</td>
										<td>${appointment.appn_patn_id }</td>
										<td>${appointment.doctor.getName() }</td>
										<td>${appointment.getDateFormetted()} ${appointment.getTimeFormetted()} </td>
										<td>${appointment.doctor.getSpecialization().getTitle()}</td>
										<td>${appointment.appn_status }</td>
										
										<td>
											<button onclick="location.href='./reschedule/${appointment.appn_id}'">Reschedule</button>
											<button onclick="location.href='./cancel/${appointment.appn_id}'">Cancel</button>
										</td>
									</tr>
									</c:forEach>
							
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
</body>
</html>
