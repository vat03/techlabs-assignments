package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.entity.UserEntity;
import com.aurionpro.entity.CustomerEntity;
import com.aurionpro.entity.AdminEntity;
import com.aurionpro.repository.UserRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.AdminRepository;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository = new UserRepository();
	private CustomerRepository customerRepository = new CustomerRepository();
	private AdminRepository adminRepository = new AdminRepository();
	private static final String ADMIN_SIGNUP_CODE = "1234";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null || action.isEmpty()) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("signup".equals(action)) {
			String userType = request.getParameter("userType");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");

			// Check if username already exists
			if (userRepository.validateUser(username, password) != null) {
				request.setAttribute("error", "Username already exists. Please choose a different one.");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
				return;
			}

			// Validate admin signup code if userType is admin
			if ("admin".equals(userType)) {
				String adminCode = request.getParameter("adminCode");
				if (!ADMIN_SIGNUP_CODE.equals(adminCode)) {
					request.setAttribute("error", "Invalid admin signup code.");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
					return;
				}
			}

			// Create new user
			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setUserType(userType);
			userRepository.addUser(user);

			// Register as admin or customer
			if ("admin".equals(userType)) {
				AdminEntity admin = new AdminEntity();
				admin.setUserId(user.getUserId());
				admin.setFirstName(firstName);
				admin.setLastName(lastName);
				adminRepository.addAdmin(admin);
			} else {
				CustomerEntity customer = new CustomerEntity();
				customer.setUserId(user.getUserId());
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customerRepository.addCustomer(customer);
			}

			// Redirect to login page after successful signup
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			// Handle login
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserEntity user = userRepository.validateUser(username, password);

			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if ("admin".equals(user.getUserType())) {
					response.sendRedirect(request.getContextPath() + "/adminHome.jsp");
				} else {
					response.sendRedirect(request.getContextPath() + "/customerHome.jsp");
				}
			} else {
				request.setAttribute("error", "Invalid credentials / please try again");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}