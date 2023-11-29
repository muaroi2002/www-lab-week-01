package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;
import vn.edu.iuh.fit.services.AccountService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/controller", "/action"})
public class ControllerServlet extends HttpServlet {
    private LocalDateTime timeLogout;
    private RequestDispatcher requestDispatcher = null;
    private static final AccountService accountService = new AccountService();
    private static final RoleRepository roleRepository = new RoleRepository();
    private Account account = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String logout = req.getParameter("logOut");
        String user = req.getParameter("user");
        if (login != null) {
            handleLogin(req, resp);
        } else {
            System.out.println("Oh no can't add!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
    }

    public void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        timeLogout = LocalDateTime.now();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        account = accountService.checkLogin(userName, password);
        if (account != null) {
            Role role = roleRepository.findRoleByAccountId(account.getId());
            if (role != null) {
                if (role.getId().equalsIgnoreCase("admin")) {
                    req.setAttribute("roleID", role.getId());
                    requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
                } else {
                    req.setAttribute("accountID", account.getId());
                    req.setAttribute("fullName", account.getFullName());
                    req.setAttribute("email", account.getEmail());
                    req.setAttribute("phone", account.getPhone());
                    req.setAttribute("roleID", role.getId());
                    req.setAttribute("roleName", role.getName());
                    req.setAttribute("description", role.getDescription());
                    requestDispatcher = getServletContext().getRequestDispatcher("/user.jsp");
                }
                requestDispatcher.forward(req, resp);
            } else {
                System.out.println("Role not found for the account!");
            }
        } else {
            System.out.println("Invalid login credentials!");
        }
    }
}