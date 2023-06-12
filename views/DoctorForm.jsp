<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
   
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('https://img.freepik.com/premium-photo/female-doctor-showing-something-white-background_397897-64.jpg');
             background-repeat: no-repeat;
            background-size: cover;
            background-position: center center;
            height: 100vh;
        }

        .container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            margin-top: 100px;
        }
        h1 {
            font-family: Arial, sans-serif;
            font-size: 32px;
            font-weight: bold;
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="savedoc" method="post">
         <center>
  
    <h1>Doctors Feeding</h1></center>
            <div class="form-group">
                <label for="doc_name" class="form-label">Doctor Name</label>
                <input type="text" name="dname" id="dname" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="doc_qual" class="form-label">Doctor Qualification</label>
                <input type="text" name="dqual" id="dqual" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="spec_id" class="form-label">Specialization id</label>
                <input type="text" name="spec_id" id="spec_id" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="doc_exp" class="form-label">Experience</label>
                <input type="text" name="doc_exp" id="doc_exp" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="doctor_photo" class="form-label">Photo</label>
                <input type="text" name="doctor_photo" id="doctor_photo" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="doc_fee" class="form-label">Fees</label>
                <input type="number" name="doc_fee" id="doc_fee" class="form-control" required>
            </div>

<div class="form-group">
                <label for="weekday	" class="form-label">Available weekday</label>
                <input type="text" name="weekday" id="weekday" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="dcsc_timefrom" class="form-label">From</label>
                <input type="text" name="dcsc_timefrom" id="dcsc_timefrom" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="dcsc_timeto" class="form-label">To</label>
                <input type="text" name="dcsc_timeto" id="dcsc_timeto" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="scsc_avgat" class="form-label">Average Time</label>
                <input type="text" name="scsc_avgat" id="scsc_avgat" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Add</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   
     <main>
        <div id="edit">
          <center>  <h1>Doctors Details</h1>
            
    <table>
                <tr>
                    <th>Doctor ID</th>
                    <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.doc_id}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <th>Name</th>
                    <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.doc_name}</td>
                      </c:forEach>
                </tr>
                <tr>
                
                    <th>Qualification</th>
                     <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.doc_qual}</td>
                      </c:forEach>
                </tr>
                <tr>
                
                    <th>Specialization ID</th>
                     <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.spec_id}</td>
                      </c:forEach>
                </tr>
                <tr>
                 
                    <th>Experience</th>
                     <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.doc_exp}</td>
                      </c:forEach>
                </tr>
                <tr>
                
                    <th>Photo</th>
                     <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.doc_photo}</td>
                      </c:forEach>
                </tr>
                <tr>
                 
                    <th>Fees</th>
                     <c:forEach var="doctor" items="${doctorList}">
                    <td>${doctor.doc_cfee}</td>
                      </c:forEach>
                </tr>
                
            </table>
    <!-- Add more details as needed -->
</center>
            
            <button onclick="editprofile()">EDIT-PROFILE</button>
        </div>
    </main> 
<script>
function editprofile() {
    var ele = document.getElementById("edit");
    ele.innerHTML = `
    <form action="updateDocProfile" method="post">    
        <label>Doctor Id:</label>
        <input type="text" id="doc_id" name="doc_id" value="${doctor.doc_id}" readonly><br>

        <label for="doc_name">Name:</label>
        <input type="text" id="doc_name" name="doc_name" value="${doctor.doc_name}"><br>

        <label for="doc_qual">Qualification:</label>
        <input type="text" id="doc_qual" name="doc_qual" value="${doctor.doc_qual}"><br>

        <label for="spec_id">Specialization id</label>
        <input type="text" id="spec_id" name="spec_id" value="${doctor.spec_id}"><br>

        <label for="doc_exp">Experience:</label>
        <input type="text" id="doc_exp" name="doc_exp" value="${doctor.doc_exp}"><br>

        <label for="doc_photo">Photo:</label>
        <input type="text" id="doc_photo" name="doc_photo" value="${doctor.doc_photo}"><br>

        <label for="doc_cfee">Fees:</label>
        <input type="text" id="doc_cfee" name="doc_cfee" value="${doctor.doc_cfee}"><br>

        <input type="submit" value="Update Profile">
    </form>`;
}
</script>
</body>
</html>