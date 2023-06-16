<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DAS</title>
<jsp:include page="scripts.jsp" />
</head>
<body>

	<jsp:include page="nav.jsp" />
	<div align="center">
		<div class="container">
			<h1 >My Profile</h1>
			<div class="row">
				<div class="col-md-6">
					<h4>Add Family Members</h4>
					<form>
						<div class="form-group">
							<label for="name">Name:</label> <input type="text"
								class="form-control" id="name" name="name">
						</div>
						<div class="form-group">
							<label for="relation">Relation:</label> <input type="text"
								class="form-control" id="relation" name="relation">
						</div>
						<button type="submit" class="btn btn-primary">Add Member</button>
					</form>
				</div>

			</div>
			<h2 class="mt-4">Family Members</h2>
			<table class="table mt-4">
				<thead>
					<tr>
						<th>Name</th>
						<th>Relation</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Family Member 1</td>
						<td>Relation 1</td>
						<td>
							<button type="button" class="btn btn-danger">Delete</button>
						</td>
					</tr>
					<tr>
						<td>Family Member 2</td>
						<td>Relation 2</td>
						<td>
							<button type="button" class="btn btn-danger">Delete</button>
						</td>
					</tr>
					<!-- Add more rows for family members -->
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>