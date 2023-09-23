package com.an.controllers;

import com.an.entities.Account;
import com.an.entities.Log;
import com.an.services.AccountService;
import com.an.services.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.rmi.RemoteException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name = "ControlServlet",value = "/ControlServlet")
public class ControlerServlet extends HttpServlet {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private AccountService accountService;
    private LogService logService;
    private int log_id;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        this.req = req;
        this.resp = resp;
        if (action.equals("login")) {
            if (handleLogin()) req.getRequestDispatcher("/user.jsp").forward(req, resp);
        } else if (action.equals("logout")) {
            handleLogout();
        } else if (action.equals("View As Admin")) {
            handleViewAdmin();
        }

    }

    private boolean handleLogin() throws JsonProcessingException, RemoteException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        accountService = new AccountService();
        Account account = accountService.checkLogin(email, password);
        String json = convertObjectToJson(account);
        req.setAttribute("account", json);
        if (account == null) return false;
        else {
            Log log = new Log(account.getId());
            req.setAttribute("log_account", log.getAccountID());
            logService = new LogService();
            log_id = Math.toIntExact(logService.insertLog(log));
            return true;
        }
    }

    private void handleLogout() throws ServletException, IOException {
        logService.updateLogoutTime(log_id);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void handleViewAdmin() throws IOException, ServletException {
        List<Account> listAcc = new ArrayList<>();
        listAcc = accountService.getAll();
        String json = convertObjectToJson(listAcc);
        req.setAttribute("listAcc", json);
        System.out.println(json);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    private String convertObjectToJson(Object o) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(o);
        return json;
    }

}
