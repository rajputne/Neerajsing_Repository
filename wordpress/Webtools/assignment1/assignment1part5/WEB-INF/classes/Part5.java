
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
 import java.util.ArrayList;

import javax.servlet.ServletException;

public class Part5 extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException {
      response.setContentType("text/html");
	  String html="<html><head><title>Claims Servlet</title></head><body>";
      PrintWriter out = response.getWriter();
	  Enumeration e = request.getParameterNames();
	  html+="<body bgcolor=pink>";
	  html+="Using getParameter";
	  html+="<table border='1'>";
	  out.println("<tr><td><strong>Parameters</strong></td><td><strong>Values</strong></td></tr>");
      while(e.hasMoreElements())
      {
		String name=(String) e.nextElement();
		html+="<tr><td>"+name +"</td> ";
		String value=request.getParameter(name);
		html+="<td>"+value+"</td></tr>";
      } 
	html+="</table>";
	out.println(html);
	out.close();	
	}
}