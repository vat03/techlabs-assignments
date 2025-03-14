//package com.aurionpro.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/LogoutController")
//public class LogoutController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			session.invalidate(); // Invalidate the session
//		}
//		request.getSession(true).setAttribute("message", "Logout Successful");
//		response.sendRedirect(request.getContextPath() + "/login.jsp");
//	}
//}










package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle GET requests (e.g., if session expires and user navigates)
		doLogout(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle POST requests (e.g., logout button click)
		doLogout(request, response);
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); // Invalidate the session if it exists
		}
		// Create a new session to store the logout message
		HttpSession newSession = request.getSession(true);
		newSession.setAttribute("message", "Logout Successful");
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
}