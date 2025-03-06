
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
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("login".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// Line 47: Use validateUser from UserQuery
			UserEntity user = userQuery.validateUser(username, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if ("admin".equals(user.getUserType())) {
					response.sendRedirect(request.getContextPath() + "/AdminController");
				} else if ("customer".equals(user.getUserType())) {
					response.sendRedirect(request.getContextPath() + "/CustomerController");
				} else {
					request.setAttribute("error", "Invalid user type");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
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

			// Add user and get userId
			int userId = userQuery.addUser(user);

			CustomerEntity customer = new CustomerEntity();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);

			// Line 83: Fix addCustomer call to include userId
			customerQuery.addCustomer(customer, userId);

			// Line 91: Validate newly registered user
			UserEntity registeredUser = userQuery.validateUser(username, password);
			if (registeredUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", registeredUser);
				response.sendRedirect(request.getContextPath() + "/CustomerController");
			} else {
				request.setAttribute("error", "Registration failed");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
