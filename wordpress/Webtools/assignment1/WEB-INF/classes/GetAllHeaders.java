
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
    response.setContentType("text/plain");
	
    PrintWriter out = response.getWriter();

    out.println("Request Headers:");
    Enumeration names = request.getHeaderNames();
    while (names.hasMoreElements()) {
      String name = (String) names.nextElement();
      Enumeration values = request.getHeaders(name); // support multiple values
      if (values != null) {
        while (values.hasMoreElements()) {
          String value = (String) values.nextElement();
          out.println(name + ": " + value);
        }
      }
    }
	
	
  }
}