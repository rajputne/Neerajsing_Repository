
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
 import java.util.ArrayList;

import javax.servlet.ServletException;

public class Part3 extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException {

      response.setContentType("text/html");
	  String html="<html><head><title>Claims Servlet</title></head><body>";
	  html+="<h2>"+request.getQueryString()+"<br /></h1>";
      PrintWriter out = response.getWriter();
	  
	out.println("Request over");
	out.close();	
	}
}