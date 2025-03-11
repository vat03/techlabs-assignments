package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.aurionpro.entity.CustomerEntity;
import com.aurionpro.entity.UserEntity;
import com.aurionpro.entity.AdminEntity;
import com.aurionpro.query.CustomerQuery;
import com.aurionpro.query.UserQuery;
import com.aurionpro.query.AdminQuery;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserQuery userQuery = new UserQuery();
    private CustomerQuery customerQuery = new CustomerQuery();
    private AdminQuery adminQuery = new AdminQuery();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserEntity user = userQuery.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("message", "Login successful"); // Success message
                if ("admin".equals(user.getUserType())) {
                    response.sendRedirect(request.getContextPath() + "/adminHome.jsp");
                } else {
                    response.sendRedirect(request.getContextPath() + "/customerHome.jsp");
                }
            } else {
                request.setAttribute("error", "Login attempt failed"); // Failure message
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("signup".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String userType = request.getParameter("userType");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            // Check if username already exists
            if (userQuery.getUserByUsername(username) != null) {
                request.setAttribute("error", "Sign in failed: Username already exists"); // Failure message
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }

            // Add to users table
            UserEntity user = new UserEntity();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setUserType(userType);
            int userId = userQuery.addUser(user);

            // Handle user type-specific table updates
            if ("customer".equals(userType)) {
                CustomerEntity customer = new CustomerEntity();
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customerQuery.addCustomer(customer, userId);
            } else if ("admin".equals(userType)) {
                AdminEntity admin = new AdminEntity();
                admin.setUserId(userId);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                adminQuery.addAdmin(admin);
            }

            HttpSession session = request.getSession();
            session.setAttribute("message", "Sign in successful"); // Success message
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
