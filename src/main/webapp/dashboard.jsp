<%@ page import="vn.edu.iuh.fit.entities.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<section class="container ">

    <%--menu admin--%>
    <div class="navbar bg-light navbar-expand-md">

        <ul class="nav navbar-nav col-md-7">
            <li class="nav-item"><a href="" class="nav-link"> Account</a></li>

            <li class="nav-item"><a href="" class="nav-link"> Role</a></li>
            <li class="nav-item"><a href="" class="nav-link" name="user" > Profile</a></li>


        </ul>
        <ul class="nav navbar-expand col-2">
            <%
                String roleID = request.getAttribute("roleID") + "";
            %>
            <H5 >Hello <%=roleID%></H5>  </ul>
        <ul class="nav navbar-expand col-4">

            <li class="nav-item">
                <button onclick="logout()">Logout</button></li>

        </ul>
    </div>

    <%--table account--%>

    <div class="container mt-5 mx-auto">
        <form class="w-3" action="controller" method="get">
            <h1>List Account</h1>


            <table class="table">
                <thead>

                <tr>
                    <th scope="col">Account id</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Action</th>

                </tr>
                </thead>
                <tbody>
                <%
                    List<Account> accountList;

                    accountList = new AccountRepository().getAll();
                    for (Account account : accountList) {%>
                <tr>

                    <td><%=account.getId()%></td>

                    <td><%=account.getFullName()%></td>

                    <td><%=account.getEmail()%></td>


                    <td><%=account.getPhone()%></td>
                    <td class="action-links">
                        <div class="d-flex gap-1">
                            <a class="btn" >
                                <i class="fa-solid fa-circle-info"></i>
                            </a>
                            <a class="btn" >
                                <i class="far fa-user"></i>
                            </a>
                            <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                <i class="fa fa-pen"></i>
                            </button>
                        </div>
                    </td>

                </tr>
                <% } %>
                </tbody>
            </table>
        </form>
    </div>

</section>

<%--modal add Account--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Update a account</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="controller">
                <div class="modal-body">

                    <div class="mb-3">
                        <label for="up_acc_id" class="form-label">ID:</label>
                        <input type="text" class="form-control" id="up_acc_id" placeholder=""
                               name="up_acc_id" readonly value=" " disabled>
                    </div>
                    <div class="mb-3">
                        <label for="up_acc_name" class="form-label">Name:</label>
                        <input type="text" class="form-control" id="up_acc_name" placeholder="Enter Account Name"
                               name="up_acc_name" value="">
                    </div>
                    <div class="mb-3">
                        <label for="up_acc_email" class="form-label">Email:</label>
                        <input type="email" class="form-control" id="up_acc_email"
                               placeholder="Enter Account Email" name="up_acc_email"
                               value="">
                    </div>
                    <div class="mb-3">
                        <label for="up_acc_password" class="form-label">Password:</label>
                        <input type="text" class="form-control" id="up_acc_password"
                               placeholder="Enter Account Password" name="up_acc_password"
                               value="">
                    </div>
                    <div class="mb-3">
                        <label for="up_acc_phone" class="form-label">Phone:</label>
                        <input type="tel" class="form-control" id="up_acc_phone" placeholder="Enter Account Phone"
                               name="up_acc_phone" value="">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" name="upAccount">Update</button>
                </div>
            </form>
        </div>
    </div>

</div>


<script>
    function logout() {
        // Thực hiện chuyển hướng đến trang cụ thể (ví dụ: index.jsp)
        window.location.href = "index.jsp";
    }

</script>
</body>
</html>
