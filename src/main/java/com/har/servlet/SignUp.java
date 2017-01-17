/**
 * 
 */
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

/**
 * @author HSandadi
 *
 */
public class SignUp  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String userName=(String)req.getParameter("userId");
		String password=(String)req.getParameter("pwd");
		LoginService loginService= new LoginServiceImpl();
		loginService.saveCreateLoginUser(new LoginDTO(userName, password));
		out.println("Created new User.");
		
	}
}
