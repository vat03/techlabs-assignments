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
import com.aurionpro.query.AccountQuery;
import com.aurionpro.query.CustomerQuery;
import com.aurionpro.query.TransactionQuery;
import com.aurionpro.entity.CustomerEntity;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionQuery transactionQuery = new TransactionQuery();
	private AccountQuery accountQuery = new AccountQuery();
	private CustomerQuery customerQuery = new CustomerQuery();

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
			CustomerEntity customer = customerQuery.getCustomerByUserId(user.getUserId());
			List<AccountEntity> accounts = accountQuery.getAccountsByCustomerId(customer.getCustomerId());
			if (accounts.isEmpty()) {
				request.setAttribute("error", "You don’t have an account. Please contact an admin to create one.");
				request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
				return;
			}
			AccountEntity senderAccount = accounts.get(0);

			String actionType = request.getParameter("actionType");
			String receiverAccountNumber = actionType.equals("transfer") ? request.getParameter("receiverAccountNumber")
					: senderAccount.getAccountNumber();
			double amount = Double.parseDouble(request.getParameter("amount"));

			AccountEntity receiverAccount;
			if ("transfer".equals(actionType)) {
				receiverAccount = accountQuery.getAccountByNumber(receiverAccountNumber);
				if (receiverAccount == null) {
					request.setAttribute("error", "Receiver account number does not exist.");
					request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
					return;
				}
			} else {
				receiverAccount = senderAccount;
			}

			String transactionType;
			switch (actionType) {
			case "transfer":
				transactionType = "transfer";
				break;
			case "add":
				transactionType = "credit";
				break;
			case "withdraw":
				transactionType = "debit";
				break;
			default:
				throw new IllegalArgumentException("Invalid action type: " + actionType);
			}

			TransactionEntity transaction = new TransactionEntity();
			transaction.setSenderAccountNumber(senderAccount.getAccountNumber());
			transaction.setReceiverAccountNumber(receiverAccount.getAccountNumber());
			transaction.setTransactionType(transactionType);
			transaction.setAmount(amount);

			boolean isSuccess = true;
			String errorMessage = null;
			if ("withdraw".equals(actionType) || "transfer".equals(actionType)) {
				if (senderAccount.getBalance() < amount) {
					isSuccess = false;
					errorMessage = "Insufficient balance.";
					transaction.setStatus("failed");
				} else {
					transaction.setStatus("completed");
				}
			} else {
				transaction.setStatus("completed");
			}

			try {
				transactionQuery.addTransaction(transaction, isSuccess);
				if (isSuccess) {
					response.sendRedirect(request.getContextPath() + "/customerHome.jsp");
				} else {
					request.setAttribute("error", errorMessage);
					request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
				}
			} catch (RuntimeException e) {
				request.setAttribute("error", "Transaction failed: " + e.getMessage());
				request.getRequestDispatcher("newTransaction.jsp").forward(request, response);
			}
		}
	}
}
