<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

</head>
<body>
	<div>
	<jsp:include page="nav.jsp" />
		

						<div class="col-md-9 ">

					<div class="card-container">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Total Tests</h5>
								<p class="card-text">10</p>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Total Users</h5>
								<p class="card-text">15</p>
							</div>
						</div>
						
						<!-- Add more doctors here -->
					</div>
					<div class="container doctor">
						<table class="table">
							<thead>
								<h3 align="center">Test Bills</h3>
								<tr>
									<th>Bill ID</th>
									<th>Test Type</th>
									<th>Date</th>
						
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Doctor 1</td>
								
									<td>2023-06-01</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Doctor 2</td>
									
									<td>2023-06-02</td>

								</tr>
								<tr>
									<td>3</td>
									<td>Doctor 3</td>
									
									<td>2023-06-02</td>

								</tr>
								<tr>
									<td>4</td>
									<td>Doctor 4</td>
									
									<td>2023-06-02</td>

								</tr>
								<tr>
									<td>5</td>
									<td>Doctor 5</td>
									
									<td>2023-06-02</td>

								</tr>
								<tr>
									<td>6</td>
									<td>Doctor 6</td>
									
									<td>2023-06-02</td>

								</tr>
								<tr>
									<td>7</td>
									<td>Doctor 7</td>
									
									<td>2023-06-02</td>

								</tr>
								
								<!-- Add more rows here -->
							</tbody>
						</table>
					</div>
		</div>	
		</div>	
				<center>
		
				<form action="gettestdetails" method="get"><button >Add</button></form>
					  
					 <script src="index.js"></script>
		
		<script>
		function loadContent(page) {
			// Get the content div element
			var contentDiv = document.getElementById('content');

			// Load the content based on the selected page
			switch (page) {
				case 'dashboard':
					contentDiv.innerHTML = '<h2>Dashboard</h2><p>This is the default content of the dashboard page.</p>';
			}		break;
		}
</script>
		<script >
 
function doSubmit()
{
window.transfer("testspage.jsp");
}
 
</script>

</body>
</html>