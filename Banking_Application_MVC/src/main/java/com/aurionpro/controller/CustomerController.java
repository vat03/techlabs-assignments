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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerQuery customerQuery = new CustomerQuery();
	private UserQuery userQuery = new UserQuery();
	private AccountQuery accountQuery = new AccountQuery();
	private TransactionQuery transactionQuery = new TransactionQuery();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		UserEntity user = (UserEntity) session.getAttribute("user");
		CustomerEntity customer = customerQuery.getCustomerByUserId(user.getUserId());
		if (customer == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		String action = request.getParameter("action");
		String sortField = request.getParameter("sortField");
		String sortOrder = request.getParameter("sortOrder");

		if ("passbook".equals(action)) {
			List<AccountEntity> accounts = accountQuery.getAccountsByCustomerId(customer.getCustomerId());
			List<TransactionEntity> transactions = new ArrayList<>();
			for (AccountEntity account : accounts) {
				transactions.addAll(
						transactionQuery.getTransactionsByAccountId(account.getAccountId(), sortField, sortOrder));
			}
			request.setAttribute("transactions", transactions);
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("passbook.jsp").forward(request, response);
		} else if ("editProfile".equals(action)) {
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("editProfile.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("customerHome.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		UserEntity user = (UserEntity) session.getAttribute("user");
		String action = request.getParameter("action");
		if ("editProfile".equals(action)) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");

			CustomerEntity customer = customerQuery.getCustomerById(customerId);
			if (customer != null) {
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				customerQuery.updateCustomer(customer);
				userQuery.updateUserPassword(user.getUserId(), password);
				response.sendRedirect(request.getContextPath() + "/customerHome.jsp");
			} else {
				request.setAttribute("error", "Customer not found");
				request.getRequestDispatcher("editProfile.jsp").forward(request, response);
			}
		}
	}
}
