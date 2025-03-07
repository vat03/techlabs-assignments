package com.aurionpro.controller;

import com.aurionpro.entity.AccountEntity;
import com.aurionpro.entity.CustomerEntity;
import com.aurionpro.entity.TransactionEntity;
import com.aurionpro.entity.UserEntity;
import com.aurionpro.query.AccountQuery;
import com.aurionpro.query.CustomerQuery;
import com.aurionpro.query.TransactionQuery;
import com.aurionpro.query.UserQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserQuery userQuery = new UserQuery();
	private CustomerQuery customerQuery = new CustomerQuery();
	private TransactionQuery transactionQuery = new TransactionQuery();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println(
				"[AdminController] GET request received, Session ID: " + (session != null ? session.getId() : "null"));

		if (session == null || session.getAttribute("user") == null) {
			System.out.println("[AdminController] No session or user, redirecting to login.jsp");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		UserEntity user = (UserEntity) session.getAttribute("user");
		System.out.println("[AdminController] User: " + user.getUsername() + ", Type: " + user.getUserType());

		if (!"admin".equals(user.getUserType())) {
			System.out.println("[AdminController] User is not admin, redirecting to login.jsp");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		String action = request.getParameter("action");
		String sortField = request.getParameter("sortField");
		String sortOrder = request.getParameter("sortOrder");
		System.out.println(
				"[AdminController] Action: " + action + ", SortField: " + sortField + ", SortOrder: " + sortOrder);

		if ("viewCustomers".equals(action)) {
			List<CustomerEntity> customers = customerQuery.getAllCustomers(sortField, sortOrder);
			request.setAttribute("customers", customers);
			System.out.println("[AdminController] Forwarding to viewCustomers.jsp");
			request.getRequestDispatcher("/viewCustomers.jsp").forward(request, response);
		} else if ("viewTransactions".equals(action)) {
			List<TransactionEntity> transactions = transactionQuery.getAllTransactions(sortField, sortOrder);
			request.setAttribute("transactions", transactions);
			System.out.println("[AdminController] Forwarding to viewTransactions.jsp");
			request.getRequestDispatcher("/viewTransactions.jsp").forward(request, response);
		} else {
			System.out.println("[AdminController] Default case: Forwarding to adminHome.jsp");
			request.getRequestDispatcher("/adminHome.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		String action = request.getParameter("action");
		if ("addCustomer".equals(action)) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			String returnToAccount = request.getParameter("returnToAccount");

			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setUserType("customer");
			int userId = userQuery.addUser(user);

			CustomerEntity customer = new CustomerEntity();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerQuery.addCustomer(customer, userId);

			if ("true".equals(returnToAccount)) {
				response.sendRedirect(request.getContextPath() + "/addAccount.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/adminHome.jsp");
			}
		} else if ("addAccount".equals(action)) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String accountType = request.getParameter("accountType");
			double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));

			CustomerEntity customer = customerQuery.getCustomerById(customerId);
			if (customer == null) {
				request.setAttribute("error", "Customer with ID " + customerId + " does not exist.");
				request.setAttribute("registerLink", true);
				request.getRequestDispatcher("/addAccount.jsp").forward(request, response);
				return;
			}

			AccountEntity account = new AccountEntity();
			account.setCustomerId(customerId);
			account.setAccountType(accountType);
			account.setBalance(initialBalance);

			AccountQuery accountQuery = new AccountQuery();
			accountQuery.addAccount(account);
			response.sendRedirect(request.getContextPath() + "/adminHome.jsp");
		}
	}
}