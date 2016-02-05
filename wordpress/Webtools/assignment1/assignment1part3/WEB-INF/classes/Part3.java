
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
	  PrintWriter out = response.getWriter();
	  
	  out.println("<table border='1'>");
	  out.println("<tr><td><strong>Parameters</strong></td><td><strong>Values</strong></td></tr>");
      out.println("<tr><td>UserName:</td><td>"+request.getParameter("userName")+"</td></tr>");
	  out.println("<tr><td>Address:</td><td>"+request.getParameter("Address")+"</td></tr>");
	  out.println("<tr><td>State:</td><td>"+request.getParameter("State")+"</td></tr>");
	  out.println("<tr><td>City:</td><td>"+request.getParameter("City")+"</td></tr>");
	  out.println("<tr><td>Zip:</td><td>"+request.getParameter("Zip")+"</td></tr>");
	  out.println("<tr><td>Phone:</td><td>"+request.getParameter("Phone")+"</td></tr>");
	  out.println("<tr><td>Account Number:</td><td>"+request.getParameter("Account_Number")+"</td></tr>");
	  out.println("<tr><td>Pet Name:</td><td>"+request.getParameter("Name")+"</td></tr>");
	  out.println("<tr><td>Breed:</td><td>"+request.getParameter("Breed")+"</td></tr>");
	  out.println("<tr><td>Age:</td><td>"+request.getParameter("Age")+"</td></tr>");
	  out.println("<tr><td>Gender:</td><td>"+request.getParameter("gender")+"</td></tr>");
	  out.println("<tr><td>Story:</td><td>"+request.getParameter("Story")+"</td></tr>");
	  
	  out.println("<tr><td>Claim Type:</td><td>"+request.getParameter("chkClaimAccident")+"</td></tr>");
	  out.println("<tr><td>Claim Type:</td><td>"+request.getParameter("chkClaimIllness")+"</td></tr>");
	  out.println("<tr><td>Claim Type:</td><td>"+request.getParameter("chkClaimWellness")+"</td></tr>");
	  
	  out.println("<tr><td>Check Estimate:</td><td>"+request.getParameter("chkEstimate")+"</td></tr>");
	  out.println("<tr><td>Send Payment to</td><td>"+request.getParameter("chkPayment")+"</td></tr>");
	  out.println("<tr><td>Veterinarian:</td><td>"+request.getParameter("Veterinarian")+"</td></tr>");
	
	  out.println("<tr><td>Clinic Name:</td><td>"+request.getParameter("Clinic Name")+"</td></tr>");
	  out.println("<tr><td>Phone Number:</td><td>"+request.getParameter("Phone Number")+"</td></tr>");
	  out.println("<tr><td>Fax:</td><td>"+request.getParameter("Fax")+"</td></tr>");
	  out.println("<tr><td>Check Vet:</td><td>"+request.getParameter("chkVet")+"</td></tr>");
	  out.println("<tr><td>Check New Condition:</td><td>"+request.getParameter("chkNewCond")+"</td></tr>");
	  out.println("<tr><td>Signature:</td><td>"+request.getParameter("Signature")+"</td></tr>");
	  out.println("<tr><td>Date:</td><td>"+request.getParameter("timestamp")+"</td></tr>");
	  out.println("</table>");
	
	  
      
	  out.close();	
	}
}