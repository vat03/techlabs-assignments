package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterationForm")
public class RegisterationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterationForm() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String fname = request.getParameter("firstnameTxt");
		String lname = request.getParameter("lastnameTxt");
		String gender = request.getParameter("gender");
		String[] selectedLanguages = request.getParameterValues("language");
		String email = request.getParameter("emailTxt");
		String address = request.getParameter("addressTxt");
		String state = request.getParameter("state");
		String zip = request.getParameter("zipTxt");
		String cctype = request.getParameter("creditCardType");
		
		writer.print("First name: <b>"+fname+"</b><br><br>");
		writer.print("Last name: <b>"+lname+"</b><br><br>");
		writer.print("Gender: <b>"+gender+"</b><br><br>");
		writer.print("Selected: ");
		if (selectedLanguages != null) {
		    for (String language : selectedLanguages) {
		        writer.print("<b>"+language+" </b>");
		    }
		} else {
		    writer.println("<b>No hobbies selected</b>");
		}
		writer.print("<br><br>Email: <b>"+email+"</b><br><br>");
		writer.print("Address: <b>"+address+"</b><br><br>");
		writer.print("State: <b>"+state+"</b><br><br>");
		writer.print("Zip: <b>"+zip+"</b><br><br>");
		writer.print("Credit Card Type: <b>"+cctype+"</b><br><br>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
