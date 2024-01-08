package com.jdbclogindemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbclogindemo.dao.UserDao;
import com.jdbclogindemo.daoimpl.UserDaoImpl;
import com.jdbclogindemo.pojo.User;

@WebServlet("/checkuser")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) 
			throws ServletException, IOException {
	
		String uname = request.getParameter("txtUname");
		String upass = request.getParameter("txtPass");
		
		User user = new User();
		user.setUsername(uname);
		user.setPassword(upass);
		
		UserDao daoImpl = new UserDaoImpl();
		
		if(daoImpl.checkUserCredentials(user)) {
			HttpSession session = 
					request.getSession(true);
			session.setAttribute("USERNAME", uname);
			session.setMaxInactiveInterval(120);
			response.sendRedirect("ghr");
		} else {
			response.sendRedirect("error?msg=loginerror");
		}
	}
}




