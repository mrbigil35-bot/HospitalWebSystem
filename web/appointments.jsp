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
    <title>Manage Appointments</title>
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

    <h2>Book New Appointment</h2>
    <form action="AppointmentController" method="POST">
        <input type="hidden" name="action" value="insert">
        
        <span class="form-group"><label>Select Patient:</label>
        <select name="patientId" required>
            <option value="">-- Choose Patient --</option>
            <c:forEach var="patient" items="${patientList}">
                <option value="${patient.patientId}">${patient.name} (ID: ${patient.patientId})</option>
            </c:forEach>
        </select></span>
        
        <span class="form-group"><label>Select Doctor:</label>
        <select name="doctorId" required>
            <option value="">-- Choose Doctor --</option>
            <c:forEach var="doctor" items="${doctorList}">
                <option value="${doctor.doctorId}">${doctor.name} - ${doctor.specialty}</option>
            </c:forEach>
        </select></span>
        
        <span class="form-group"><label>Date:</label>
        <input type="date" name="appointmentDate" required></span>
        
        <input type="submit" value="Book Appointment">
    </form>

    <hr>

    <h2>Appointment Schedule</h2>
    <table>
        <tr>
            <th>Appt ID</th>
            <th>Patient Name</th>
            <th>Doctor Name</th>
            <th>Date (YYYY-MM-DD)</th>
        </tr>
        <c:forEach var="appt" items="${appointmentList}">
            <tr>
                <td>${appt.appointmentId}</td>
                <td>${appt.patientName}</td>
                <td>${appt.doctorName}</td>
                <td>${appt.appointmentDate}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>