<body>
    <h2>Hospital Management System Login</h2>
    <p style="color:red;">${param.error}</p>
    <p style="color:green; font-weight:bold;">${param.msg}</p> <!-- Displays success message -->
    
    <!-- Form Validation using HTML5 'required' -->
    <form action="LoginServlet" method="POST">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>
        
        <label>Password:</label>
        <input type="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    
    <br>
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</body>