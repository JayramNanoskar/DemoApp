package com.jayram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.media.sound.RealTimeSequencerProvider;
import com.sun.org.apache.xpath.internal.patterns.ContextMatchStepPattern;

public class AddServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		
		ServletContext ctx = req.getServletContext();
		String str = ctx.getInitParameter("name");
		System.out.println(str);
		
		res.sendRedirect("sq");
		
		
	}
}
