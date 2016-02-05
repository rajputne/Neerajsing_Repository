
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;

public class GetAllHeaders extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h1>Request Headers</h1>");
	
    Enumeration names = request.getHeaderNames();
	out.println("<table border='1'>");
    while (names.hasMoreElements()) {
      String name = (String) names.nextElement();
      Enumeration values = request.getHeaders(name);
      if (values != null) {
        while (values.hasMoreElements()) {
		  out.println("<tr>");
          String value = (String) values.nextElement();
          out.println("<td>"+name + "</td><td>" + value+"</td>");
		  out.println("</tr>");
        }
      }
    }
	out.println("</table>");
	
  }
}