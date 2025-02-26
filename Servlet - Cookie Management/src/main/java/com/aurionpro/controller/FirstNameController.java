package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstNameController")
public class FirstNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String firstname = request.getParameter("firstname");
		
		Cookie cookie = new Cookie("firstname", firstname);
		response.addCookie(cookie);
		
		writer.print("Welcome "+firstname);
		
		writer.print("<form action='LastNameController' method='post'>");
		writer.print("Last Name: <input type='text' name='lastname'><br><br>");
		writer.print("<button>Next</button>");
		writer.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
