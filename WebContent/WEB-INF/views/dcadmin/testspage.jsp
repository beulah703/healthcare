<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*, spring.orm.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">


</head>
<style>
#table {
	max-height: 300px; /* Adjust the height as needed */
	overflow-y: scroll;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}
</style>
<body>

	<jsp:include page="nav.jsp" />



	<div class="col-md-12">
		<div id="table">
			<table class="table mt-4">
				<thead>
					<h3 align="center">Test Details</h3>
					<tr>
						<th>Test Id</th>
						<th>Test Name</th>
						<th>Test Category</th>
						<th>Test Price</th>
						<th>Test Method</th>
						<th>From Range</th>
						<th>To Range</th>
						<th>Test Status</th>

					</tr>
				</thead>
				<%
				List<testModel> slist = (List<testModel>) request.getAttribute("tests");
				%>

				<%
				for (testModel s : slist) {
				%>
				<tbody>
					<tr>
						<td><%=s.getTest_id()%></td>
						<td><%=s.getTest_name()%></td>
						<td><%=s.getTest_category()%></td>
						<td><%=s.getTest_price()%></td>
						<td><%=s.getTest_method()%></td>
						<td><%=s.getTest_fromrange()%></td>
						<td><%=s.getTest_torange()%></td>
						<td><%=s.getTest_status()%></td>

						<td>
							<button class="btn btn-primary"
								onclick="getspeci('<%=s.getTest_id()%>')">Edit</button>
							<button class="btn btn-danger"
								onclick="delspeci('<%=s.getTest_id()%>')">Delete</button>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Add more rows here -->
	</tbody>
	</table>
	<center>
		<button id="btn">Add</button>
		<div class="col-md-9">

			<form id="testform" style="display: none;" action="savetest"
				method="post">

				<center>
					<h1>New Test Details</h1>
				</center>


				<div class="form-group">
					<label for="test_name" class="form-label">Test Name</label> <input
						type="text" name="test_name" id="test_name" class="form-control"
						required>
				</div>

				<div class="form-group">
					<label for="test_category" class="form-label">Test category</label>
					<input type="text" name="test_category" id="test_category"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label for="test_price" class="form-label">Test Price</label> <input
						type="text" name="test_price" id="test_price" class="form-control"
						required>
				</div>

				<div class="form-group">
					<label for="test_method" class="form-label">Method</label> <input
						type="text" name="test_method" id="test_method"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label for="test_fromrange" class="form-label">Normal Range
						From</label> <input type="text" name="test_fromrange" id="test_fromrange"
						class="form-control" required>
				</div>
				<div class="form-group">
					<label for="test_torange" class="form-label">Normal Range
						To</label> <input type="text" name="test_torange" id="test_torange"
						class="form-control" required>
				</div>
				<div class="form-group">
					<label for="test_status" class="form-label">Test Status </label> <input
						type="text" name="test_status" id="test_status"
						class="form-control" required>
				</div>

				<button type="submit" class="btn btn-primary btn-block">Add</button>

			</form>


		</div>


	</center>



	</div>
	</div>
	</div>
	</div>

	<script>
		const btn = document.getElementById('btn');

		btn.addEventListener('click', () => {
		  const form = document.getElementById('testform');

		  if (form.style.display === 'none') {
		   
		    form.style.display = 'block';
		  } else {
		  
		    form.style.display = 'none';
		  }
		});</script>

	<button type="button" class="btn btn-primary" id="show-btn"
		onclick="showForm()">Add Specialization</button>
	<div id="specializationForm" style="display: none;">
		<form action="updatetest" method="post">
			<div class="form-group">
				<label for="idInput">ID</label> <input type="text"
					class="form-control" name="test_id" id="idInput" required>
			</div>
			<div class="form-group">
				<label for="titleInput">Title</label> <input type="text"
					class="form-control" name="test_name" id="titleInput" required>
			</div>
			<div class="form-group">
				<label for="descriptionInput">Category</label> <input type="text"
					class="form-control" name="test_category" id="descriptionInput"
					required>
			</div>
			<div class="form-group">
				<label for="descriptionInput">Price</label> <input type="text"
					class="form-control" name="test_price" id="price" required>
			</div>
			<div class="form-group">
				<label for="descriptionInput">Method</label> <input type="text"
					class="form-control" name="test_method" id="method" required>
			</div>
			<div class="form-group">
				<label for="descriptionInput">FromRange</label> <input type="text"
					class="form-control" name="test_fromrange" id="fromrange" required>
			</div>
			<div class="form-group">
				<label for="descriptionInput">ToRange</label> <input type="text"
					class="form-control" name="test_torange" id="torange" required>
			</div>
			<button type="submit" id="updatebtn" class="btn btn-primary">Add</button>
		</form>
	</div>

</body>
<script>

	$('#show-btn').click(function()
			{
		$('#idInput').val('');
		$('#titleInput').val('');
		$('#descriptionInput').val('');
		$('#price').val('');
		$('#method').val('');
		$('#fromrange').val('');
		$('#torange').val('');
		$('#status').val('');

		$('#specializationForm').toggle();
			});
	
	function delspeci(specid)
	{
		$.ajax({
			url : "./deltest",
			method:"post",
			data:{
				id:specid
			},
			  success: function(response) {
			console.log(response); // You can log the response or perform further actions as needed
        },
        error: function(xhr, status, error) {
            // Handle any error that occurred during the AJAX request
            console.log("Error: " + error);
            }
		});
	}
	function getspeci(specid)
	{
		$.ajax({
			url : "./getspec",
			method:"post",
			data:{
				id:specid
			},
			success : function(spec) {
				//spec=JSON.parse(spec);
				console.log(typeof(spec));
				$('#idInput').val(spec.test_id);
				$('#titleInput').val(spec.test_name);
				$('#descriptionInput').val(spec.test_category);
				
				$('#price').val(spec.test_price);
				$('#method').val(spec.test_method);
				$('#fromrange').val(spec.test_fromrange);
				$('#torange').val(spec.test_torange);
				$('#status').val(spec.test_status);
					
					
			
				$('#specializationForm').show();
				$('#updatebtn').text('update');
			}
		});
	}
	</script>
</html>