<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Đăng Nhập</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .login-container h2 {
            text-align: center;
        }

        .form-group {
            margin: 15px 0;
        }

        .form-group label {
            display: block;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-group button {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<form action="controler", method="post", style="border: 1px solid black; width: 300px; height: 250px; border-radius: 5%; padding: 20px;">
    <h1 align="center">Login</h1>
    <div class="row" >
        <label class="col1">Email: </label>
        <input type="text" name="email" placeholder="Username" value="nhatan@gmail.com" /><br><br>
    </div>
    <div class="row">
        <label class="col1">Password: </label>
        <input type="password" name="password" placeholder="Password" value="123" /><br><br>
    </div>
    <div class="row">
        <input type="submit" value="login" name = "action" style="margin: 80px"/>
        <%--		<input type="reset" value="Reset" />--%>
    </div>
</form>
</div>
</body>
</html>