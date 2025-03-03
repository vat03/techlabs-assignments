package com.aurionpro.controller;

import com.aurionpro.entity.TransactionEntity;
import com.aurionpro.repository.TransactionRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionRepository transactionRepository = new TransactionRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String action = request.getParameter("action");
		if ("newTransaction".equals(action)) {
			int senderAccountId = Integer.parseInt(request.getParameter("senderAccountId"));
			int receiverAccountId = Integer.parseInt(request.getParameter("receiverAccountId"));
			String transactionType = request.getParameter("transactionType");
			double amount = Double.parseDouble(request.getParameter("amount"));

			TransactionEntity transaction = new TransactionEntity();
			transaction.setSenderAccountId(senderAccountId);
			transaction.setReceiverAccountId(receiverAccountId);
			transaction.setTransactionType(transactionType);
			transaction.setAmount(amount);
			transactionRepository.addTransaction(transaction);

			response.sendRedirect("customerHome.jsp");
		}
	}
}
