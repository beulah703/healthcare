<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*, spring.orm.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<title>Home</title>
<%-- <jsp:include page="scripts.jsp" /> --%>


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
	<%
		List<testModel> slist = (List<testModel>) request.getAttribute("tests");
	%>

	<div align="center">
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
							<th>Actions</th>


						</tr>
					</thead>


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


							<td>
								<button class="btn btn-primary"
									onclick="gettest('<%=s.getTest_id()%>')">Edit</button>
								<button class="btn btn-danger"
									onclick="deltest('<%=s.getTest_id()%>')">Delete</button>
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
			<button type="button" class="btn btn-primary" id="show-btn"
				onclick="onclickspec()">Add Test</button>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6">
						<div class="shadow p-3 mb-5 bg-white rounded"
							id="specializationForm" style="display: none;">
							<center>
								<h1>New Test Details</h1>
							</center>

							<form action="./savetest" , method="post" id="edit-spec-form">




								<input id="test_id" name="test_id" type="text" hidden>

								<div class="form-group">
									<label for="test_name" class="form-label">Test Name</label> <input
										type="text" name="test_name" id="test_name"
										class="form-control" required>
								</div>

								<div class="form-group">
									<label for="test_category" class="form-label">Test
										category</label> <input type="text" name="test_category"
										id="test_category" class="form-control" required>
								</div>

								<div class="form-group">
									<label for="test_price" class="form-label">Test Price</label> <input
										type="text" name="test_price" id="test_price"
										class="form-control" required>
								</div>

								<div class="form-group">
									<label for="test_method" class="form-label">Method</label> <input
										type="text" name="test_method" id="test_method"
										class="form-control" required>
								</div>

								<div class="form-group">
									<label for="test_fromrange" class="form-label">Normal
										Range From</label> <input type="text" name="test_fromrange"
										id="test_fromrange" class="form-control" required>
								</div>
								<div class="form-group">
									<label for="test_torange" class="form-label">Normal
										Range To</label> <input type="text" name="test_torange"
										id="test_torange" class="form-control" required>
								</div>


								<button id="add-spec-btn" type="submit" class="btn btn-primary">Add</button>

							</form>


						</div>
		</center>



	</div>

	<!--<script>
		const btn = document.getElementById('btn');

		btn.addEventListener('click', () => {
		  const form = document.getElementById('testform');

		  if (form.style.display === 'none') {
		   
		    form.style.display = 'block';
		  } else {
		  
		    form.style.display = 'none';
		  }
		});</script>-->


	<!--	<button type="button" class="btn btn-primary" id="show-btn"
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
	</div>  -->

</body>
<script>
	function onclickspec() {

		$('#id').val('');
		$('#test_name').val('');
		$('#test_category').val('');
		$('#test_price').val('');
		$('#test_method').val('');
		$('#test_torange').val('');
		$('#test_fromrange').val('');
		$('#add-spec-btn').text('Add');
		$('#specializationForm').toggle();
	}

	function gettest(specid) {
		$.ajax({
			url : "./gettest",
			method : "post",
			data : {
				id : specid
			},
			success : function(spec) {
				//spec=JSON.parse(spec);
				console.log(typeof (spec));
				console.log(spec);
				const form = $('#edit-spec-form');

				console.log("go" + spec.test_id);

				$('#test_id').val(spec.test_id);
				$('#test_name').val(spec.test_name);
				$('#test_category').val(spec.test_category);

				$('#test_price').val(spec.test_price);
				$('#test_method').val(spec.test_method);
				$('#test_fromrange').val(spec.test_fromrange);
				$('#test_torange').val(spec.test_torange);

				form.attr('action', './updatetest');
				form.show();

				$('#specializationForm').show();
				$('#add-spec-btn').text('update');
			}
		});

	}

	function deltest(specid) {
		$.confirm({
			title : 'Confirm!',
			content : 'Are you Sure to delete!',
			buttons : {
				confirm : function() {
					$.ajax({
						url : "./deltest",
						method : "post",
						data : {
							test_id : specid
						},
						success : function(data) {
							$.alert({
								title : 'Deleted!',
								content : 'The item has been deleted.',
								buttons : {
									confirm : {
										text : 'OK',
										action : function() {
											// Refresh the page
											location.reload();
										}
									}
								}
							});
						}
					});

				},
				cancel : function() {
					$.alert('Canceled!');
				},
			}
		});
	}
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.css">
<script>
	</html>