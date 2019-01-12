package org.liaohailong.cookiesessions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/createsession")
public class CreateSessionServlet extends HttpServlet {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String thisTime = DATE_FORMAT.format(new Date());
		String sessionValue = "liaohailong time ->" + thisTime;
		session.setAttribute("name", sessionValue);

		ResponsUtil.setUtf8(resp);
		String text = "���Ѵ����� sessionId = " + session.getId();
		ResponsUtil.write(resp, text);
	}
}
