<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="spring.orm.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="scripts.jsp" />
<title>Doctors</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div align="center">
		<h2>Doctors List</h2>
		<table class="table mt-4">
			<thead>
				<tr>
					<th>Doctor ID</th>
					<th>Doctor Name</th>
					<th>Specialization</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody id="doctorsTableBody">
				<!-- Static records -->
				<tr>
					<td>001</td>
					<td>Dr. Smith</td>
					<td>Cardiology</td>
					<td>
						<div class="floating-actions">
							<button class="btn btn-primary">Edit</button>
							<button class="btn btn-danger">Delete</button>
						</div>
					</td>
				</tr>
				<tr>
					<td>002</td>
					<td>Dr. Johnson</td>
					<td>Pediatrics</td>
					<td>
						<div class="floating-actions">
							<button class="btn btn-primary">Edit</button>
							<button class="btn btn-danger">Delete</button>
						</div>
					</td>
				</tr>
				<tr>
					<td>003</td>
					<td>Dr. Lee</td>
					<td>Orthopedics</td>
					<td>
						<div class="floating-actions">
							<button class="btn btn-primary">Edit</button>
							<button class="btn btn-danger">Delete</button>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		<div class="form-container">
			<button type="button" class="btn btn-primary" id="show-btn-doc"
				onclick="onclickdoc()">Add Doctor</button>
			<div class="container">

				<div class="row justify-content-center">
					<div class="col-md-5">
						<div id="doctorForm" style="display: none;"
							class="shadow p-3  bg-white rounded">

							<form action="./savedoc" method="post" enctype="multipart/form-data" >
								<br>
								<h2>Add Doctor</h2>
								<div class="form-group">
									<label for="doctorName">Doctor Name</label> <input type="text"
										class="form-control" id="doctorName" name="docname">
								</div>
								<div class="form-group">
									<label for="specialization">Specialization</label> <select
										class="form-control" id="specialization" name="docspec">
										<c:forEach var="spec" items="${speclist}">
										<option value="${spec.id }">${spec.title}</option>
										</c:forEach>
										
									</select>
								</div>
								<div class="form-group">
									<label for="qual">Qualification</label> <input type="text"
										class="form-control" id="qual" name="docqual">
								</div>
								<div class="form-group">
									<label for="exp">Experience</label> <br> <input
										type="text" id="exp" name="docexp" id="exp"
										class="form-control" pattern="[0-9]+" required>
								</div>
								<div class="form-group">
									<label for="photo">Photo</label> <input type="file" id="photo"
										name="docphoto" class="form-control" accept="image/*">
								</div>

								<div class="form-group">

									<label for="daysavailable">Available Days</label> <br> <label
										for="all">ALL</label> <input type="checkbox" name="days"
										value="all" id="all"> <label for="mon">M</label> <input
										type="checkbox" name="days" value="mon" id="mon"> <label
										for="tue">T</label> <input type="checkbox" name="days"
										value="tue" id="tue"> <label for="wed">W</label> <input
										type="checkbox" name="days" value="wed" id="wed"> <label
										for="thu">H</label> <input type="checkbox" name="days"
										value="thu" id="thu"> <label for="fri">F</label> <input
										type="checkbox" name="days" value="fri" id="fri"> <label
										for="sat">S</label> <input type="checkbox" name="days"
										value="sat" id="sat"> <label for="sat">U</label> <input
										type="checkbox" name="days" value="sun" id="sun">

								</div>

								<!-- 
				<div>
					<select multiple class="form-group">
						<option value="mon">Mon</option>
						<option value="tue">Tue</option>
						<option value="wed">Wed</option>
						<option value="thu">Thu</option>
						<option value="fri">Fri</option>
						<option value="sat">Sat</option>
						<option value="sun">Sun</option>

					</select>
				</div>
-->
								<div class="form-group" class="form-control">
									<label for="timeAvailable">Select Available Time</label> <br>
									<label for="from">From</label> <input type="time" id="appt"
										name="docfrom"> <label for="to">To</label> <input
										type="time" id="appt" name="docto">
								</div>
								<div class="form-group">
									<label for="avgtime">Average Time</label> <input type="text"
										class="form-control" id="avgtime" pattern="[0-9]+"
										name="docavgtime">
								</div>
								<div class="form-group">
									<label for="fee">Fee</label> <input type="number"
										class="form-control" id="fee" name="docfee" min="0">
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<!-- 
<script type="text/javascript">
var selectElement = document.querySelector('select');
var selectedOptions = Array.from(selectElement.selectedOptions).map(option => option.value);
console.log(selectedOptions);
</script>
 -->

</html>