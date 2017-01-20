package com.har.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.har.ui.model.LoginDTO;
import com.har.ui.model.Member;
import com.har.ui.service.LoginService;
import com.har.ui.service.LoginServiceImpl;
import com.har.util.ExpensesUtil;

public class MemberInformation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String prefix= (String) req.getParameter("prefix");
		String firstName= (String) req.getParameter("firstName");
		String middleName= (String) req.getParameter("middleName");
		String lastName= (String) req.getParameter("lastName");
		String suffix= (String) req.getParameter("suffix");
		Date dateOfBirth= ExpensesUtil.getDateFromString((String) req.getParameter("dateOfBirth"));
		String gender= (String) req.getParameter("gender");
		LoginDTO user=(LoginDTO)req.getSession().getAttribute("loginUser");
		LoginService loginService = new LoginServiceImpl();
		Member member=new Member(prefix, firstName, middleName, lastName, suffix, dateOfBirth, gender,user);
		loginService.saveCreateMember(member);

	}
}
