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
    <title>Doctor Management</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { border-collapse: collapse; width: 60%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .nav { margin-bottom: 20px; padding-bottom: 10px; border-bottom: 1px solid #ccc; }
        .nav a { margin-right: 15px; text-decoration: none; color: #3498db; font-weight: bold; }
    </style>
</head>
<body>
    <!-- Unified Navigation Menu -->
    <div class="nav">
        <a href="dashboard.jsp">⬅ Return to Dashboard</a>
    </div>

    <h2>Doctor Directory</h2>

    <h3>Add New Doctor</h3>
    <form action="DoctorController" method="POST">
        <input type="hidden" name="action" value="insert">
        <label>Name:</label>
        <input type="text" name="name" required>
        
        <label>Specialty:</label>
        <input type="text" name="specialty" required>
        
        <input type="submit" value="Add Doctor">
    </form>

    <table>
        <tr>
            <th>Doctor ID</th>
            <th>Name</th>
            <th>Specialty</th>
        </tr>
        <c:forEach var="doctor" items="${doctorList}">
            <tr>
                <td>${doctor.doctorId}</td>
                <td>${doctor.name}</td>
                <td>${doctor.specialty}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>