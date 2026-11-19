<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Patients</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 80%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .nav { margin-bottom: 20px; padding-bottom: 10px; border-bottom: 1px solid #ccc; }
        .nav a { margin-right: 15px; text-decoration: none; color: #3498db; font-weight: bold; }
        .form-group { margin-bottom: 10px; display: block; }
    </style>
</head>
<body>
    <div class="nav">
       <a href="dashboard.jsp">⬅ Return to Dashboard</a>
    </div>

    <h2>Add New Patient</h2>
    <form action="PatientController" method="POST">
        <input type="hidden" name="action" value="insert">
        
        <span class="form-group">Name: <input type="text" name="name" required></span>
        <span class="form-group">Age: <input type="number" name="age" min="1" max="120" required></span>
        <span class="form-group">Gender: 
            <select name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>
        </span>
        <span class="form-group">Contact: <input type="text" name="contact" required></span>
        <span class="form-group">Address: <input type="text" name="address" required></span>
        
        <input type="submit" value="Add Patient">
    </form>

    <hr>

    <h2>Patient Directory</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Contact</th>
            <th>Address</th>
        </tr>
        <c:forEach var="patient" items="${patientList}">
            <tr>
                <td>${patient.patientId}</td>
                <td>${patient.name}</td>
                <td>${patient.age}</td>
                <td>${patient.gender}</td>
                <td>${patient.contact}</td>
                <td>${patient.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>