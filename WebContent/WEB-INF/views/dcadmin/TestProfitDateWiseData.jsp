<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Test Information</title>
    <style>
        .container {
            display: flex;
            justify-content: center;
        }

        table {
            border-collapse: collapse;
            width: 30%;
            margin: 10px;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    

    <div class="container">
        <table>
           
            <tr>
                <th>Test Name</th>
                <th>Profit</th>
            </tr>
            <tr>
                <td>Blood Test</td>
                <td>$150</td>
            </tr>
            <tr>
                <td>X-Ray</td>
                <td>$250</td>
            </tr>
            <tr>
                <td>Ultrasound</td>
                <td>$350</td>
            </tr>
            <tr>
                <td>CT Scan</td>
                <td>$400</td>
            </tr>
            <tr>
                <td>MRI</td>
                <td>$500</td>
            </tr>
        </table>

        <table>
           
            <tr>
                <th>Test Category</th>
                <th>Profit</th>
            </tr>
            <tr>
                <td>Cardiology</td>
                <td>$500</td>
            </tr>
            <tr>
                <td>Pathology</td>
                <td>$400</td>
            </tr>
            <tr>
                <td>Radiology</td>
                <td>$600</td>
            </tr>
            <tr>
                <td>Neurology</td>
                <td>$350</td>
            </tr>
            <tr>
                <td>Dermatology</td>
                <td>$300</td>
            </tr>
        </table>

        <table>
            <tr>
                <th>Test Method</th>
                <th>Profit</th>
            </tr>
            <tr>
                <td>PCR</td>
                <td>$300</td>
            </tr>
            <tr>
                <td>CT Scan</td>
                <td>$450</td>
            </tr>
            <tr>
                <td>Colonoscopy</td>
                <td>$350</td>
            </tr>
            <tr>
                <td>Endoscopy</td>
                <td>$400</td>
            </tr>
            <tr>
                <td>Mammography</td>
                <td>$200</td>
            </tr>
        </table>
    </div>
</body>
</html>
