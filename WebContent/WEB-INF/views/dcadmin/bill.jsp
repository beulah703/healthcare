<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<style>
a {
	color: #000000;
	text-decoration: none;
	background-color: transparent;
}

.nav a:hover {
	color: #078344;
	text-decoration: none;
	border-style: solid;
	background-color: transparent;
}

.container {
	padding: 0px;
	margin: 0px;
}

.table {
	border: 1px solid #ccc;
	margin-top: 3px;
	margin-bottom: 3px;
}

.table th, .table td {
	border: 1px solid #ccc;
	padding: 2px;
}

.table thead th {
	background-color: #f0f0f0;
}

.card-container {
	white-space: nowrap;
	width: auto;
}

.card {
	display: inline-block;
	width: 300px;
	margin-right: 10px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp" />
	

<%-- Access the "bill" attribute in JSP --%>
<script>
  var billData = ${bill}; // Access the JSON data
  
  // Parse the JSON string
  var bill = JSON.parse(billData);
  
  // Access the properties or elements in the JSON data
  for (var i = 0; i < bill.length; i++) {
    var item = bill[i];
    console.log(item); // Output each item in the console
    // Perform further operations or display the data as needed
  }
</script>
</body>
</html>