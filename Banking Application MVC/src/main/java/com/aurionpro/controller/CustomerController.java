package com.aurionpro.controller;

import com.aurionpro.entity.AccountEntity;
import com.aurionpro.entity.CustomerEntity;
import com.aurionpro.entity.TransactionEntity;
import com.aurionpro.entity.UserEntity;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.TransactionRepository;
import com.aurionpro.repository.UserRepository;
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
	private CustomerRepository customerRepository = new CustomerRepository();
	private UserRepository userRepository = new UserRepository();
	private AccountRepository accountRepository = new AccountRepository();
	private TransactionRepository transactionRepository = new TransactionRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		CustomerEntity customer = customerRepository.getCustomerByUserId(user.getUserId());

		if ("passbook".equals(action)) {
			List<AccountEntity> accounts = accountRepository.getAccountsByCustomerId(customer.getCustomerId());
			List<TransactionEntity> transactions = new ArrayList<>();
			for (AccountEntity account : accounts) {
				transactions.addAll(transactionRepository.getTransactionsByAccountId(account.getAccountId()));
			}
			request.setAttribute("transactions", transactions);
			request.getRequestDispatcher("passbook.jsp").forward(request, response);
		} else if ("editProfile".equals(action)) {
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("editProfile.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");

		if ("editProfile".equals(action)) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");

			CustomerEntity customer = customerRepository.getCustomerById(customerId);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerRepository.updateCustomer(customer);

			userRepository.updateUserPassword(user.getUserId(), password);

			response.sendRedirect("customerHome.jsp");
		}
	}
}
