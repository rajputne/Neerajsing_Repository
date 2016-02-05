
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
 import java.util.ArrayList;

import javax.servlet.ServletException;

public class ClaimsServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException {

      response.setContentType("text/html");
	  String html="<html><head><title>Claims Servlet</title></head><body>"
	  html+="<h2>"+request.getQueryString()+"<br /></h1>";
      PrintWriter out = response.getWriter();
	  //out.println("<h2>"+request.getQueryString()+"<br /></h1>");
	  Enumeration e = request.getParameterNames();
	  html+="<body bgcolor=pink>";
	  html+="Using getParameter";
	  //out.println("<body bgcolor=pink>");
	//out.println("Using getParameter");
    while(e.hasMoreElements())
    {
      String name=(String) e.nextElement();
	  html+=name +" : ";
      //out.println( name +" : ");
      String value=request.getParameter(name);
	 html+=value+"<br>";
      //out.println(value.toUpperCase() +"<br>");
    } 
	out.println("Request over");
	out.close();	
	}
}