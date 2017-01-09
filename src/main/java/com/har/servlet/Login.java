package com.har.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.har.ui.model.LoginDTO;
import com.har.ui.service.LoginService;
import com.har.ui.service.LoginServiceImpl;

public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	String userName=(String)req.getParameter("userId");
	String password=(String)req.getParameter("pwd");
	LoginService loginService= new LoginServiceImpl();
	LoginDTO valueObject=loginService.findLoginUser(userName, password);
	if(valueObject==null)
		out.println("Login failed.");
	else 
		out.println("Login executed");
	System.out.println("Login Servlet Executed");
	
}
}
