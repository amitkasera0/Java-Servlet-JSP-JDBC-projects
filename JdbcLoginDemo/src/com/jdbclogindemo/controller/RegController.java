package com.jdbclogindemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbclogindemo.dao.UserDao;
import com.jdbclogindemo.daoimpl.UserDaoImpl;
import com.jdbclogindemo.pojo.User;

@WebServlet("/adduser")
public class RegController extends HttpServlet {

	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) 
			throws ServletException, IOException {
	
		String uname = request.getParameter("txtUname");
		String upass = request.getParameter("txtPass");
		
		User user = new User();
		user.setUsername(uname);
		user.setPassword(upass);
		
		UserDao daoImpl = new UserDaoImpl();
		
		if(daoImpl.addNewUser(user)) {
			response.sendRedirect("success?msg=regsuccess");
		} else {
			response.sendRedirect("error?msg=regerror");
		}
	}
}




