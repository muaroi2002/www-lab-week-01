<%--
  Created by IntelliJ IDEA.
  User: minan
  Date: 9/23/2023
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        html {
            min-height: 80%;
            display: grid;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .row {
            height: 30px;
            display: flex;
            align-items: center;
        }

        .col1 {
            min-width: 80px;
        }

        .col2 {
            width: 150px;
        }

        .btn {
            width: 100px;
            height: 30px;
            margin: 10px;
        }
    </style>
</head>

<body>

<form style="border: 1px solid black; width: 50%; height: 50%; border-radius: 5%; padding: 30px;", action="ControlServlet", method="post">
    <h2>User Information</h2>
    <div class="row">
        <label class="col1">Fullname: </label>
        <label  class="col2" id="fullname">NhatAn</label>
    </div>
    <div class="row">
        <label class="col1">Email: </label>
        <label  class="col2" id="email">nhatan@gmail.com</label>
    </div>
    <div class="row">
        <label class="col1">Phone: </label>
        <label  class="col2" id="phone">0912991919</label>
    </div>
    <br>
    <input type="submit" value="logout" class="btn" name="action">
    <input type="submit" value="View As Admin" class="btn" name="action">
</form>

<script>
    var obj = ${account};
    document.getElementById("fullname").innerHTML = obj.fullName;
    document.getElementById("email").innerHTML = obj.email;
    document.getElementById("phone").innerHTML = obj.phone;
</script>

</body>
