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
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository = new UserRepository();
	private CustomerRepository customerRepository = new CustomerRepository();
	private AccountRepository accountRepository = new AccountRepository();
	private TransactionRepository transactionRepository = new TransactionRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("viewCustomers".equals(action)) {
			List<CustomerEntity> customers = customerRepository.getAllCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
		} else if ("viewTransactions".equals(action)) {
			List<TransactionEntity> transactions = transactionRepository.getAllTransactions();
			request.setAttribute("transactions", transactions);
			request.getRequestDispatcher("viewTransactions.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String action = request.getParameter("action");
		if ("addCustomer".equals(action)) {
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
			userRepository.addUser(user);

			CustomerEntity customer = new CustomerEntity();
			customer.setUserId(user.getUserId());
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customerRepository.addCustomer(customer);

			response.sendRedirect("adminHome.jsp");
		} else if ("addAccount".equals(action)) {
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			String accountType = request.getParameter("accountType");

			AccountEntity account = new AccountEntity();
			account.setCustomerId(customerId);
			account.setAccountType(accountType);
			account.setBalance(0.0);
			accountRepository.addAccount(account);

			response.sendRedirect("adminHome.jsp");
		}
	}
}