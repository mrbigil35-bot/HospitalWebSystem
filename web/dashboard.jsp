<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 40px; text-align: center; }
        .menu-box { display: inline-block; padding: 20px; margin: 10px; background: #ecf0f1; border-radius: 8px; width: 200px; text-decoration: none; color: #2c3e50; font-weight: bold; font-size: 18px; border: 2px solid #bdc3c7; }
        .menu-box:hover { background: #3498db; color: white; border-color: #2980b9; }
    </style>
</head>
<body>
    <h2>Welcome to the Hospital Management System</h2>
    <p>Logged in as: <strong>${loggedInUser}</strong></p>
    
    <div style="margin-top: 40px;">
        <a href="PatientController" class="menu-box">Manage Patients</a>
        <a href="DoctorController" class="menu-box">Manage Doctors</a>
        <a href="AppointmentController" class="menu-box">Appointments</a>
    </div>
    
    <br><br>
    <a href="LogoutServlet" style="color: red; text-decoration: none; font-weight: bold;">[ Logout ]</a>
</body>
</html>