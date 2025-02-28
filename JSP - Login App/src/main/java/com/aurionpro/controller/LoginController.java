package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.db.DatabaseConnection;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DatabaseConnection databaseConnection = new DatabaseConnection();
		databaseConnection.Connect();
		RequestDispatcher dispatcher = null;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolename = request.getParameter("rolename");

		try {
			if (rolename.equalsIgnoreCase("admin") && databaseConnection.check(username, password))
				dispatcher = request.getRequestDispatcher("/AdminDashboard.jsp");
			if (rolename.equalsIgnoreCase("customer") && databaseConnection.check(username, password))
				dispatcher = request.getRequestDispatcher("/CustomerDashboard.jsp");

			dispatcher.forward(request, response);
		} catch (Exception e) {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<b>Invalid Credentials !!</b><br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
