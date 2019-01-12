package org.liaohailong.http;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> parameterMap = req.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String key = entry.getKey();
			String[] value = entry.getValue();
			String values = Arrays.toString(value);
			System.out.println("parameterMap  key = " + key);
			System.out.println("parameterMap  values = " + values);
		}
		resp.getWriter().write("from UserServlet , success!");
	}
}