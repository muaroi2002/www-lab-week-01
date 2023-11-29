<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>LOGON</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="index">
    <form id="formLogin" action="action" method="get">
        <h2>LOGIN FORM</h2>
        <div class="form-group">
            <label for="userName">User:</label>
            <input class="ip1" type="text" name="userName" id="userName" placeholder="Enter User"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input class="ip2" type="password" name="password" id="password" placeholder="Enter password"/>
        </div>
        <button type="submit" id="loginbtn" name="login">Login</button>
    </form>
    <a class="dashboard-link" href="dashboard.jsp">Go to Dashboard</a>
</div>
</body>
</html>
