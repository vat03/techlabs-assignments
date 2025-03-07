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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController: GET request received");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("LoginController: POST action = " + action);

		if ("login".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("Login attempt for username: " + username);

			UserEntity user = userQuery.validateUser(username, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println("User validated: " + user.getUsername() + ", Type: " + user.getUserType());
				if ("admin".equals(user.getUserType())) {
					System.out.println("Redirecting to AdminController");
					response.sendRedirect(request.getContextPath() + "/AdminController");
				} else if ("customer".equals(user.getUserType())) {
					System.out.println("Redirecting to CustomerController");
					response.sendRedirect(request.getContextPath() + "/CustomerController");
				} else {
					System.out.println("Invalid user type: " + user.getUserType());
					request.setAttribute("error", "Invalid user type");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				System.out.println("Login failed: Invalid credentials");
				request.setAttribute("error", "Invalid username or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else if ("register".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");

			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setUserType("customer");

			int userId = userQuery.addUser(user);
			System.out.println("User registered with ID: " + userId);

			CustomerEntity customer = new CustomerEntity();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerQuery.addCustomer(customer, userId);

			UserEntity registeredUser = userQuery.validateUser(username, password);
			if (registeredUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", registeredUser);
				System.out.println("Registered and redirecting to CustomerController");
				response.sendRedirect(request.getContextPath() + "/CustomerController");
			} else {
				System.out.println("Registration failed");
				request.setAttribute("error", "Registration failed");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}