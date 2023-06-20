<!DOCTYPE html>
<html>
<head>
    <title>Patients</title>
</head>
<body>
    <table >
        <tr>
            <th>Patient ID</th>
            <th>DGBL ID</th>
            <th>Patient Name</th>
            <th>Patient Gender</th>
            <th>Amount</th>
            <th align="center">Action</th>
        </tr>
        
        <%
        // Static data
        String[][] patients = {
            {"1", "1234", "John Doe", "Male", "100"},
            {"2", "5678", "Jane Smith", "Female", "200"},
            {"3", "9012", "David Johnson", "Male", "150"},
            {"4", "3456", "Sarah Davis", "Female", "300"},
            {"5", "7890", "Michael Wilson", "Male", "250"},
            {"6", "2345", "Emily Taylor", "Female", "400"},
            {"7", "6789", "Andrew Brown", "Male", "350"},
            {"8", "0123", "Olivia Miller", "Female", "500"},
            {"9", "4567", "Daniel Anderson", "Male", "450"},
            {"10", "8901", "Sophia Thomas", "Female", "600"}
        };
        
        for (String[] patient : patients) {
            String patientId = patient[0];
            String dgblId = patient[1];
            String patientName = patient[2];
            String patientGender = patient[3];
            String amount = patient[4];
        %>
        
        <tr>
            <td><%= patientId %></td>
            <td><%= dgblId %></td>
            <td><%= patientName %></td>
            <td><%= patientGender %></td>
            <td ><%= amount %></td>
            <td><input type="file" name="upload" align="center" /></td>
        </tr>
        
        <%
        }
        %>
        
    </table>
</body>
</html>