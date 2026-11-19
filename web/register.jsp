<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital System - Register</title>
</head>
<body>
    <h2>Create a New Account</h2>
    <p style="color:red;">${param.error}</p>
    
    <form action="RegisterServlet" method="POST">
        <label>New Username:</label>
        <input type="text" name="username" required><br><br>
        
        <label>New Password:</label>
        <input type="password" name="password" required><br><br>
        
        <input type="submit" value="Register Account">
    </form>
    
    <br>
    <a href="index.jsp">Back to Login</a>
</body>
</html>