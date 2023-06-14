<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HMS</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<div>
		<jsp:include page="nav.jsp" />
		<div align="center">
			<div class="card-container" align="center">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Total Doctors</h5>
						<p class="card-text">10</p>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Todays Appointments Today</h5>
						<p class="card-text">15</p>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Total Specializations</h5>
						<p class="card-text">11</p>
					</div>
				</div>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Total Payments</h5>
						<p class="card-text">$ 1500</p>
					</div>
				</div>
				<!-- Add more doctors here -->
			</div>

			<div class="container ">
				<div align="center">
					<div class="col-md-6">
						<div class="tables">
							<div class="container">
								<table class="table">
									<thead>
										<h3 align="center">Appointments</h3>
										<tr>
											<th>Appointment ID</th>
											<th>Doctor Name</th>
											<th>Patient Name</th>
											<th>Booked Date</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Doctor 1</td>
											<td>Patient 1</td>
											<td>2023-06-01</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Doctor 2</td>
											<td>Patient 2</td>
											<td>2023-06-02</td>

										</tr>
										<tr>
											<td>3</td>
											<td>Doctor 3</td>
											<td>Patient 2</td>
											<td>2023-06-02</td>

										</tr>
										<tr>
											<td>4</td>
											<td>Doctor 4</td>
											<td>Patient 2</td>
											<td>2023-06-02</td>

										</tr>
										<tr>
											<td>5</td>
											<td>Doctor 5</td>
											<td>Patient 2</td>
											<td>2023-06-02</td>

										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="tables">
							<div class="container">
								<table class="table">
									<thead>
										<h3 align="center">Payments</h3>
										<tr>
											<th>Payment Reference</th>
											<th>Payment Mode</th>
											<th>Pay Amount</th>
											<th>Doctor Name</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>REF001</td>
											<td>Cash</td>
											<td>$150.00</td>
											<td>Doctor 1</td>
										</tr>
										<tr>
											<td>REF002</td>
											<td>Card</td>
											<td>$120.00</td>
											<td>Doctor 2</td>
										</tr>
										<tr>
											<td>REF002</td>
											<td>Card</td>
											<td>$120.00</td>
											<td>Doctor 2</td>
										</tr>
										<tr>
											<td>REF002</td>
											<td>Card</td>
											<td>$120.00</td>
											<td>Doctor 2</td>
										</tr>
										<tr>
											<td>REF002</td>
											<td>Card</td>
											<td>$120.00</td>
											<td>Doctor 2</td>
										</tr>
										<!-- Add more rows here -->
									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>