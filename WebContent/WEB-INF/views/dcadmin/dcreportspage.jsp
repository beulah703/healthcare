<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
<jsp:include page="scripts.jsp" />

</head>

<body>

	<!-- Retrieving model objects -->
	<%
		List<Object[]> data = (List<Object[]>) request.getAttribute("tdata");
	%>
	<div>
		<jsp:include page="nav.jsp" />
		<div class="col-md-9">
			<form id="filter" >
				<div class="row mt-4">
					<div class="col-md-6 offset-md-3">
						<h5>Between Dates</h5>
						<div class="row">
							<div class="col-md-6">
								<input type="date" class="form-control" id="from" name="from">
							</div>
							<div class="col-md-6">
								<input type="date" class="form-control" id="to" name="to">
							</div>
						</div>
					</div>
				</div>
				<div class="row mt-4">
					<div class="col-md-6 offset-md-3">
						<div class="text-center">
							<h5>Name</h5>
							<select class="form-control" id="TestName" name="TestName">
								<option value="select">select</option>
								<%
									for (int i = 0; i < data.size(); i++) {
								%>
								<option value=<%=data.get(i)[0]%>><%=data.get(i)[0]%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
				</div>
				<div class="row mt-4">
					<div class="col-md-6 offset-md-3">
						<div class="text-center">
							<h5>Category</h5>
							<select class="form-control" id="TestCategory" name="TestCategory">
								<option value="select">select</option>
								<%
									for (int i = 0; i < data.size(); i++) {
								%>
								<option value=<%=data.get(i)[1]%>><%=data.get(i)[1]%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
				</div>
				<div class="row mt-4">
					<div class="col-md-6 offset-md-3">
						<div class="text-center">
							<h5>Method</h5>
							<select class="form-control" id="TestMethod" name="TestMethod">
								<option value="select">Select</option>
								<%
									for (int i = 0; i < data.size(); i++) {
								%>
								<option value=<%=data.get(i)[2]%>><%=data.get(i)[2]%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
				</div>
				<div class="row mt-4"">
					
						<input type="button" value="Generate" onclick="filterData()">
		
				</div>
			</form>
		</div>

		<div id="content"></div>

	</div>
	<script>
		function filterData() {
			console.log("called?")
			$.ajax({
				url : "./revenue",
				type : "POST",
				data : $("#filter").serialize(),
				
			});
		}
	</script>

</body>
</html>