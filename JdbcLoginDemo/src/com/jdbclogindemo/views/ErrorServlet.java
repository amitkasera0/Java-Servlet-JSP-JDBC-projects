package com.jdbclogindemo.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
	HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String msg = request.getParameter("msg");
		String pageUrl = "" , message = "";
		
		switch (msg) {
		case "loginerror":
			pageUrl = "login.html";
			message = "invlid username or password";
			break;

		case "notloggedin":
			pageUrl = "login.html";
			message = "you need to login first";
			break;
			
		case "regerror":
			pageUrl = "register.html";
			message = "registration failed";
			break;
		}
		
		pw.println("<p style=\"color:red;"
		+ "text-align:center\">"+message+"</p>");
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(pageUrl);
		dispatcher.include(request, response);
	}
}







