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
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserQuery userQuery = new UserQuery();
	private CustomerQuery customerQuery = new CustomerQuery();
	private AccountQuery accountQuery = new AccountQuery();
	private TransactionQuery transactionQuery = new TransactionQuery();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("viewCustomers".equals(action)) {
			List<CustomerEntity> customers = customerQuery.getAllCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
		} else if ("viewTransactions".equals(action)) {
			List<TransactionEntity> transactions = transactionQuery.getAllTransactions();
			request.setAttribute("transactions", transactions);
			request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("addCustomer".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String returnToAccount = request.getParameter("returnToAccount");

			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setUserType("customer");
			userQuery.addUser(user);

			CustomerEntity customer = new CustomerEntity();
			customer.setUserId(user.getUserId());
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerQuery.addCustomer(customer);

			// Redirect based on context
			if ("true".equals(returnToAccount)) {
				response.sendRedirect(request.getContextPath() + "/addAccount.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/adminHome.jsp");
			}
		} else if ("addAccount".equals(action)) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String accountType = request.getParameter("accountType");
			double initialBalance = Double.parseDouble(request.getParameter("initialBalance"));

			// Validate customer existence
			CustomerEntity customer = customerQuery.getCustomerById(customerId);
			if (customer == null) {
				request.setAttribute("error", "Customer ID does not exist.");
				request.setAttribute("registerLink", "true");
				request.getRequestDispatcher("addAccount.jsp").forward(request, response);
				return;
			}

			AccountEntity account = new AccountEntity();
			account.setCustomerId(customerId);
			account.setAccountType(accountType);
			account.setBalance(initialBalance);
			accountQuery.addAccount(account);

			response.sendRedirect(request.getContextPath() + "/adminHome.jsp");
		}
	}
}
