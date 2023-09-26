<%@ page import="com.an.entities.Account" %>
<%@ page import="com.an.entities.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="com.an.repositories.AccountRepository" %><%--
  Created by IntelliJ IDEA.
  User: minan
  Date: 9/23/2023
  Time: 4:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,
        th,
        td {
            border: 1px solid black;
            border-collapse: collapse;
            height: 30px;
        }

        form {
            width: 700px;
        }

        button {
            width: 100px;
            height: 30px;
        }
    </style>
</head>
<body>
<form>
    <table style="width:100%" id="table">
        <tr>
            <th></th>
            <th>Account ID</th>
            <th>Full name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Status</th>
        </tr>
        <tr>
        </tr>
    </table>

    <br>
    <button type="button" onclick="add()">Add</button>
    <button type="button" onclick="edit()">Edit</button>
    <button type="button" onclick="deletee()">Delete</button>
</form>

</body>

<body>
<%
    Account account1 = (Account) request.getSession().getAttribute("user");
    List<Role> roleList1 = (List<Role>) request.getAttribute("list_gant");
    AccountRepository accountReponsitory = new AccountRepository();
    List<Account> accountList = accountReponsitory.getAll();
    String thongbao = request.getAttribute("thongbao") + "";
    boolean check = thongbao.equals("Thêm Thành Viên Mới Thành Công.") || thongbao.equals("Đã Xoá Thành Công") || thongbao.equals("Cấp Quyền Thành Công.") || thongbao.equals("Thêm Quyền Thành công") || thongbao.equals("Cập Nhật Thông Tin Thành Công") || thongbao.equals("Xoá quyền thành công");
%>

<div class="containers" style="align-items: center;">
    <div class="containers" style="justify-content: center;align-items: center;margin-top: 0">
        <h1 style="text-align: center;">Thông Tin Người Dùng</h1>
        <div style="margin-left: 20px">
            <p>
                <span style="font-weight: bold">Họ Tên:</span>
                <span><%=account1.getFullname()%></span>
            </p>
            <p>
                <span style="font-weight: bold">Email:</span>
                <span><%=account1.getEmail()%></span>
            </p>
            <p>
                <span style="font-weight: bold">SĐT:</span>
                <span><%=account1.getPhone()%></span>
            </p>
            <p>
                <span>Quyền:</span>
            <ul>
                <%for (Role role : roleList1) {%>
                <li><%=role.getRoleName()%></li>
                <%}%>
            </ul>
            </p>

        </div>
    </div>
    <h2 style="text-align: center; font-weight: bold;">
        Danh sách thành viên
    </h2>
    <div class="center" style="width: 100%; height: 50px; justify-content: center;flex-direction: row;">
        <button class="submit" style=" width: 200px;" data-toggle="modal" data-target="#AddTV">Thêm Thành Viên mới
        </button>
        <form action="controller" method="post">
            <input type="submit" name="logout" class="submit" style=" width: 200px; text-align: center;"
                   value="Đăng xuất"/>
        </form>
        <button class="submit" style=" width: 200px; margin-right:0" data-toggle="modal" data-target="#addRole">Thêm
            Quền mới
        </button>
    </div>
    <div style="display: flex; flex-direction: row; justify-content: center;">
        <%if (!thongbao.equals("null")) {%>
        <p style="font-size: 20px; font-weight: bold; color: <%if (check){%>rgb(82, 186, 82)<%}else{%>rgb(255, 0, 0)<%}%>;"><%=thongbao%>
        </p>
        <%}%>
    </div>
    <div class="modal fade" id="PhanQuyen" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Phân Quyền</h4>
                </div>
                <div class="modal-body">
                    <form action="controller" method="post">
                        <input type="hidden" id="userRole">
                        <label for="selectRole">Quyền:</label>
                        <select id="selectRole" name="selectRole" class="form-control">

                        </select>
                        <label for="note">Notes:</label>
                        <input type="text" name="note" class="form-control" id="note">
                    </form>
                </div>
                <div class="modal-footer">
                    <form action="controller" method="post">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" id="add" name="add" value="son" class="btn btn-default"
                                onclick="getValuRole()">Lưu
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="AddTV" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Thêm Thành Viên Mới</h4>
                </div>
                <div class="modal-body">
                    <form action="controller" method="post">
                        <label for="name_Add">Họ Tên:</label>
                        <input type="text" name="name_Add" class="form-control" id="name_Add">
                        <label for="email_Add">Email:</label>
                        <input type="text" name="email_Add" class="form-control" id="email_Add">
                        <label for="sdt_Add">SĐT:</label>
                        <input type="text" name="sdt_Add" class="form-control" id="sdt_Add">
                    </form>
                </div>
                <div class="modal-footer">
                    <form action="controller" method="post">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" id="AddTVNew" value="" name="addTV" onclick="getValueAddTV()"
                                class="btn btn-default">Lưu
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="EditTV" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sửa Thông Tin Thành Viên</h4>
                </div>
                <div class="modal-body">
                    <form action="controller" method="post">
                        <input type="hidden" id="id_edit">
                        <label for="name_Edit">Họ Tên:</label>
                        <input type="text" name="name_Edit" class="form-control" id="name_Edit">
                        <label for="email_Edit">Email:</label>
                        <input type="text" name="email_Edit" class="form-control" id="email_Edit">
                        <label for="sdt_Edit">SĐT:</label>
                        <input type="text" name="sdt_Edit" class="form-control" id="sdt_Edit">
                        <label for="pass_Edit">Password:</label>
                        <input type="text" name="pass_Edit" class="form-control" id="pass_Edit">
                        <label class="form-check-label" for="is_Status">Status:</label>
                        <input type="checkbox" class="form-check-input" id="is_Status">
                    </form>
                </div>
                <div class="modal-footer">
                    <form action="controller" method="post">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" id="EditTVNew" value="" name="EditTV" onclick="getValueEditTV()"
                                class="btn btn-default">Lưu
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="EditRole" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sửa Quyền của Thành Viên</h4>
                </div>
                <div class="modal-body">
                    <form action="controller" method="post" id="formEditRole">

                    </form>
                </div>
                <div class="modal-footer">
                    <form action="controller" method="post">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" id="deleteRoleUser" value="" name="deleteRoleUser"
                                onclick="getValueDeleteRole()"
                                class="btn btn-default">Xoá Quyền
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addRole" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sửa Thông Tin Thành Viên</h4>
                </div>
                <div class="modal-body">
                    <form action="controller" method="post">
                        <input type="hidden" id="id_addRole">
                        <label for="name_addRole">Tên: </label>
                        <input type="text" name="name_Edit" class="form-control" id="name_addRole">
                        <label for="description_addRole">Description:</label>
                        <input type="text" name="email_Edit" class="form-control" id="description_addRole">
                        <label class="form-check-label" for="is_Status">Status:</label>
                        <input type="checkbox" class="form-check-input" id="is_Status_addRole">
                    </form>
                </div>
                <div class="modal-footer">
                    <form action="controller" method="post">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" id="btn_addRole" value="" name="btn_addRole" onclick="getValueAddRole()"
                                class="btn btn-default">Thêm Role
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>