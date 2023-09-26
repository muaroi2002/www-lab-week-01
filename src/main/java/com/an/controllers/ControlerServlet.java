package com.an.controllers;

import com.an.entities.Account;
import com.an.entities.Log;
import com.an.entities.Role;
import com.an.repositories.AccountRepository;
import com.an.repositories.LogRepository;
import com.an.repositories.RoleRepository;
import com.an.services.AccountService;
import com.an.services.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.rmi.RemoteException;
import java.security.PublicKey;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet( urlPatterns = {"/controler", "/control"})
public class ControlerServlet extends HttpServlet {
    private final AccountRepository accountReponsitory = new AccountRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String check = req.getParameter("submit");
        String logout = req.getParameter("logout");
        String add = req.getParameter("add");
        String delete = req.getParameter("delete");
        String addTV = req.getParameter("addTV");
        String edit = req.getParameter("EditTV");
        String deleteRoleUser = req.getParameter("deleteRoleUser");
        String btn_addRole = req.getParameter("btn_addRole");


        if (check != null) {
            handleLogin(req, resp);
        } else if (logout != null) {
            handleLogout(req, resp);
        }
    }

    public boolean checkAdmin(Account account) {
        RoleRepository roleReponsitory = new RoleRepository();
        for (Role role : roleReponsitory.getRole(account.getId())) {
            if (role.getRoleName().equalsIgnoreCase("admin")) {
                return true;
            }
        }
        return false;
    }




    public void handleLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = (Log) req.getSession().getAttribute("log");

        log.setLogoutTime(new Date());
        LogRepository logReponsitory = new LogRepository();
        logReponsitory.readLog(log);
        req.getSession().removeAttribute("log");
        req.getSession().removeAttribute("user");
        req.removeAttribute("list_gant");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }



    public void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email != null && password != null) {
            Account user01 = accountReponsitory.getAccountByEmailAndPassword(email, password);
            if (user01 != null) {
                Log log = new Log(user01, new Date(), null, user01.getFullname());
                HttpSession session = req.getSession();
                session.setAttribute("log", log);
                session.setAttribute("user", user01);

                if (!checkAdmin(user01)) {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    req.setAttribute("thongbao", null);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin2.jsp");
                    dispatcher.forward(req, resp);
                }
            } else {
                req.setAttribute("noti", "Tài khoản mật khẩu không chính xác!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            req.setAttribute("noti", "Tài khoản mật khẩu không bỏ trống");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
