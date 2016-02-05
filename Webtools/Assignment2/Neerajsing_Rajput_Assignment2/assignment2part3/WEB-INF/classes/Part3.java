
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
 import java.util.ArrayList;
 import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import javax.servlet.ServletException;

public class Part3 extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
	  String html="<html><head><title>Part6</title>";
		html+="<script src=javascripts/ValidationScript.js></script>";
		html+="</head><body><form action='Part3' method='post'>";
        html+="<h1>Children Registration Form</h1>";
        html+="<p>Please enter the number of childrens you have</p>";
        html+="<input id='txtNumb' name='txt' type='text'>";
		html+= "<button type='button' name='action' onclick='create()' value='submit'/>Submit Number</button>";
        html+="<p id='screens'></p><br />";
        
		html+="</form></body></html>";
		out.println(html);
		out.close();	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException 
	  {
		  PrintWriter out=response.getWriter();
        response.setContentType("text/html");
		out.println("<h1>Children name are here</h1>");
        Map parameter=request.getParameterMap();
        Set set = parameter.entrySet();
        Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)iterator.next();
                String key=entry.getKey();
				if(key.contains("name"))
				{
                String[] value=entry.getValue();
                out.println("The names are below");
                    if(value.length>1){    
						
                        for (int i = 0; i < value.length; i++) {
                            out.println("<li>"+ value[i].toString() + "</li>");
                        }
						
                    }else
                            out.println("Value is "+value[0].toString()+"<br>");
 
				}   
            }
 
        out.close(); 
	  }
}