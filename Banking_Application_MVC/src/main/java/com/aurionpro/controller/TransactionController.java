package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.entity.AccountEntity;
import com.aurionpro.entity.TransactionEntity;
import com.aurionpro.entity.UserEntity;
import com.aurionpro.entity.CustomerEntity;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.repository.TransactionRepository;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionRepository transactionRepository = new TransactionRepository();
	private AccountRepository accountRepository = new AccountRepository();
	private CustomerRepository customerRepository = new CustomerRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("newTransaction".equals(action)) {
			HttpSession session = request.getSession(false);
			if (session == null || session.getAttribute("user") == null) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return;
			}

			UserEntity user = (UserEntity) session.getAttribute("user");
			CustomerEntity customer = customerRepository.getCustomerByUserId(user.getUserId());
			List<AccountEntity> accounts = accountRepository.getAccountsByCustomerId(customer.getCustomerId());
			if (accounts.isEmpty()) {
				request.setAttribute("error", "You don’t have an account. Please contact an admin to create one.");
				request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
				return;
			}
			// Assume the customer has one account for simplicity; extend if multiple
			// accounts are supported
			AccountEntity senderAccount = accounts.get(0); // First account as sender

			String receiverAccountNumber = request.getParameter("receiverAccountNumber");
			String actionType = request.getParameter("actionType");
			double amount = Double.parseDouble(request.getParameter("amount"));

			AccountEntity receiverAccount = accountRepository.getAccountByNumber(receiverAccountNumber);
			if (receiverAccount == null) {
				request.setAttribute("error", "Receiver account number does not exist.");
				request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
				return;
			}

			if ("withdraw".equals(actionType) && senderAccount.getBalance() < amount) {
				request.setAttribute("error", "Insufficient balance.");
				request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
				return;
			}

			TransactionEntity transaction = new TransactionEntity();
			transaction.setSenderAccountNumber(senderAccount.getAccountNumber());
			transaction.setReceiverAccountNumber(
					"add".equals(actionType) ? senderAccount.getAccountNumber() : receiverAccountNumber);
			transaction.setTransactionType(actionType);
			transaction.setAmount(amount);
			transactionRepository.addTransaction(transaction);

			response.sendRedirect(request.getContextPath() + "/customerHome.jsp");
		}
	}
}
