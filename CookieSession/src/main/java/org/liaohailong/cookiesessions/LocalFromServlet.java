package org.liaohailong.cookiesessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/localfrom")
public class LocalFromServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = TokenUtil.getToken();
		HttpSession session = req.getSession();
		session.setAttribute("sessionToken", token);
		req.getRequestDispatcher("from.jsp").forward(req, resp);
	}

}
