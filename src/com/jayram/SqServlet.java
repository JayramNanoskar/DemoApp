package com.jayram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/sq"}, initParams = {@WebInitParam(name="place", value="boisar")})
public class SqServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int k = 0;
		PrintWriter out = res.getWriter();
		
		Cookie cookies[] = req.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
		
		k*=k;
		out.println("<html><body bgcolor = 'cyan'>");
		out.println("Sum Square = "+k);
		
		
		ServletContext ctx = req.getServletContext();
		String str = ctx.getInitParameter("name");
		out.println(str);
		
		ServletConfig cfg = getServletConfig();
		String place = cfg.getInitParameter("place");
		out.println(place);
		out.println("</body></html>");
	}
}
