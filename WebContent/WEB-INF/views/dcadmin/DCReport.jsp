<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DCReport</title>
<jsp:include page="scripts.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />

	<center>
		</br>
		</br>
		<form method="post">
			<label>Email</label> <input type="email:" id="email"> <input
				type="button" value="Enter" onclick="Reportpage()">
		</form>
		</br>
		</br>
		</br>
		<div id="upload"></div>
	</center>

</body>
<script>
	function Reportpage() {

		$(document).ready(function() {
			$.ajax({
				url : "./uploaddata",
				type : "GET",
				success : function(response) {
					$("#upload").html(response);
				},
				error : function(xhr, status, error) {
					console.log("Error: " + error);
				}
			});
		});

	}
</script>
</html>