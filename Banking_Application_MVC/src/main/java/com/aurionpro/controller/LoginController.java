package com.aurionpro.controller;

import com.aurionpro.entity.CustomerEntity;
import com.aurionpro.entity.UserEntity;
import com.aurionpro.query.CustomerQuery;
import com.aurionpro.query.UserQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserQuery userQuery = new UserQuery();
	private CustomerQuery customerQuery = new CustomerQuery();
	private static final String ADMIN_CODE = "1234";

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

			UserEntity user = userQuery.validateUser(username, password);
			if (user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				if ("admin".equals(user.getUserType())) {
					response.sendRedirect(request.getContextPath() + "/AdminController");
				} else if ("customer".equals(user.getUserType())) {
					response.sendRedirect(request.getContextPath() + "/CustomerController");
				} else {
					request.setAttribute("error", "Invalid user type");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", "Invalid username or password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else if ("signup".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String userType = request.getParameter("userType");
			String adminCode = request.getParameter("adminCode");

			if ("admin".equals(userType) && !ADMIN_CODE.equals(adminCode)) {
				request.setAttribute("error", "Invalid admin code");
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
				return;
			}

			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setUserType(userType != null ? userType : "customer");

			int userId = userQuery.addUser(user);

			CustomerEntity customer = new CustomerEntity();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerQuery.addCustomer(customer, userId);

			UserEntity registeredUser = userQuery.validateUser(username, password);
			if (registeredUser != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", registeredUser);
				if ("admin".equals(registeredUser.getUserType())) {
					response.sendRedirect(request.getContextPath() + "/AdminController");
				} else {
					response.sendRedirect(request.getContextPath() + "/CustomerController");
				}
			} else {
				request.setAttribute("error", "Registration failed");
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "Invalid action");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
