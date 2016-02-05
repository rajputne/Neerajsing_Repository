import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

 
public class Part4 extends HttpServlet  
{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
		
		String username="";
		String address="";
		String state="";
		String city="";
		String zip="";
		String phone="";
		
		String account_number="";
		String name="";
		String breed="";
		String age="";
		String male="";
		String female="";
		String other="";
		String amount="";
		String textAreaa="";
		String dateField="";
		
		String Veterinarian="";
		String clinic_name="";
		String ph_number="";
		String fax_number="";
		
		String Signature="";
		String timestamp="";
	
		//Using Html because of buffer overrun problem
		
        String html="<html><head><title>Part6</title><link href=styles/style.css rel=stylesheet type=text/css></link>";
		html+="<script src=javascripts/ValidationScript.js></script>";
		html+="<script src='javascripts/Datepick/ts_picker.js'></script>";
		html+="</head><body><form action='Part4' method='post'>";
		
		html+="<table border='1'>";
		html+="<tbody><tr><td valign='top'> <h1> ASPCA</h1><br />Pet Health Insurance </td>";
		html+="<td valign='top'>  For office use only</td>";
        html+="<td valign='top'> HAVE A QUESTION?<br />Call us at 1-866-204-6764</td></tr><tr>";
		
		
		html+="<td colspan='3'>Claim Form PLEASE INCLUDE YOUR PET'S MEDICAL RECORDS TO HELP EXPEDITE PROCESSING.</td>";
		html+="</tr><tr><td colspan='3'>";
		html+="<br />1. General Information Please fill out this form completely. Incomplete forms will delay processing.";
		html+="</td> </tr><tr>";
		html+="<td colspan='3'><table border='1'><tbody><tr><td>Your Information Check here if this is a new address <br />";
		html+="<table border='1'><tbody>";
		html+="<tr> <td>Name:</td><td><input id='txtName' type='text' name='userName' maxlength='20' value='"+username+"'/></td></tr>";
		html+="<tr> <td>Address:</td><td><textarea id='txtAreaAddress' name='Address' rows='2' maxlength='50' cols='20' value='"+address+"'></textarea></td></tr>";
		html+="<tr> <td>State:</td><td><input id='txtState' type='text' name='State' value='"+state+"' maxlength='20' /></td></tr>";
		html+="<tr> <td>City:</td><td><input id='txtCity' type='text' name='City' value='"+city+"' maxlength='20' /></td></tr>";
		html+="<tr> <td>Zip:</td><td><input id='txtZip' type='text' name='Zip' value='"+zip+"' oninput='checkZipCode()' maxlength='5' /><p id='zipError'></p></td></tr>";
		html+="<tr> <td>Phone:</td><td><input id='txtPhoneNumber' type='text' name='Phone' oninput='phonenumber()' value='"+phone+"' maxlength='10'/><p id='phoneError'></p></td></tr>";
		html+="</tbody></table></td><td valign='top'>'Pet Information<table border='1'><tbody>";
		
		html+="<tr> <td>Account Number:</td><td><input maxlength='200' oninput='accountNumberValidate()' id='txtAccNumber' oninput='accountNumberValidate()' type='text' name='Account_Number' value='"+account_number+"' /><p id='accountNumber'></p></td></tr>";
		html+="<tr> <td>Name:</td><td><input id='txtPetName' maxlength='20'  type='text' name='Name' value='"+name+"' /></td></tr>";
		html+="<tr> <td>Breed</td><td><input id='txtBreed' type='text'  name='Breed' value='"+breed+"' /></td></tr>";
		html+="<tr> <td>Age:</td><td><input id='txtAge' type='text' maxlength='2' name='Age' value='"+age+"' oninput='checkAge()'/><p id='ageFactor'></p></td></tr>";
		html+="<td>Gender:</td><td><input type='radio' name='gender' value='male'> Male<br>";
        html+="<input type='radio' name='gender' value='female'>Female<br>";
        html+="<input type='radio' name='gender' value='other'> Other</td>";
		
		html+="<td></tr></tbody></table></td></tr></tbody></table></td></tr><tr>";
		html+="<td colspan='3'><table><tbody><tr><td>2. Diagnosis/Symptom Information</td><td>";
		html+=" 2. HELP US! By providing the Story of Occurrence/Diagnosis, you will help<br />us avoid delays in processing your claim.";
		html+="</td></tr></tbody></table></td></tr><tr><td colspan='3'><table><tbody><tr>";
		html+="<td>Story of Occurrence/Diagnosis - Please describe this incident, including dates, details and symptoms leading up to it.</td></tr><tr>";
		html+="<td><textarea id='TextArea1' maxlength='500' style=\"width:90%; display: block;margin-left: auto;margin-right: auto;\" name='Story' rows='3' cols='60' value='"+textAreaa+"'></textarea></td></tr>";
		html+="</tbody></table></td></tr><tr><td colspan='3'><table border='1'><tbody><tr><td><table border='1'><tbody><tr>";
		
		html+="<td>This claim is related to:</td><td><input type='checkbox' name='chkClaimAccident' value='accident'>Accident";
        html+="<input type='checkbox' name='chkClaimIllness' value='illness'>Illness";
        html+="<input type='checkbox' name='chkClaimWellness' value='wellness'>Welness";
		html+="</td></tr>";
		
		html+="<tr><td>Is this claim an estimate for future treatment?</td><td>";
        html+="<input type='radio' name='chkEstimate' value='Yes'> Yes<br>";
        html+="<input type='radio' name='chkEstimate' value='No'> No<br>";
		html+="</td>";
         html+="</tr>";
		 html+="<tr> <td>Total amount claimed:</td><td><input maxlength='10' oninput='amountValidate()'  id='txtAmount' type='text' name='Amount' value='"+amount+"' /><p id='AmountError'></p></td></tr>";
        html+="<tr>";
         html+="<td>Date illness/injury first occurred:</td><td>";
		html+="<input id='txtDate' type='text' name='Date' value='"+dateField+"'/>";
		
		//html+="<a href=\"javascript:show_calendar('document.tstest.Date', document.tstest.Date.value);\">";
		//html+="<img src='javascripts/Datepick/cal.gif' width='16' height='16' border='0 alt='Click Here to Pick up the timestamp' /></a>";
		
		html+="</td></tr><tr><td>Send Payment to</td><td>";
		html+= "<input type='radio' name='chkPayment' value='yes'>Yes";
         html+= "<input type='radio' name='chkPayment' value='no'>No</td>";
		 html+="</tr></tbody></table></td><td><table border='1'><tbody>";
		 html+= "<tr> <td>Veterinarian:</td><td><input maxlength='20' id='txtVet' type='text' name='Veterinarian' value='"+Veterinarian+"' /></td></tr>";
         html+="<tr> <td>Clinic Name:</td><td><input maxlength='20' id='txtClinicName' type='text' name='Clinic Name' value='"+clinic_name+"' /></td></tr>";
         html+="<tr> <td>Phone</td><td><input id='txtPhoneNumber1' maxlength='10' type='text' oninput='phonenumber2()' name='Phone Number' value='"+ph_number+"' /><p id='phoneError2'></p></td></tr>";
         html+="<tr> <td>Fax:</td><td><input id='txtFax' type='text' name='Fax' oninput='faxValidate()' maxlength='15' value='"+fax_number+"'/><p id='FaxError'></p></td></tr>";
		html+="<tr><td>Did any other veterinarian treat your pet?</td><td>";
        html+="<input type='radio' name='chkVet' value='yes'>Yes";
        html+="<input type='radio' name='chkVet' value='no'>No";
            html+="</td></tr>";
			html+="<tr><td>Is this a new condition?:</td><td>";
          html+="<input type='radio' name='chkNewCond' value='yes'>Yes";
          html+="<input type='radio' name='chkNewCond' value='no'>No";
             html+="</td></tr></tbody>";
			 html+="</table></td></tr>";
			 html+="<tr><td colspan='3'><table> <tr><td>3.Pet Owner Declaration</td></tr><tr><td>";
			 html+="I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may"+
                   "exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim"+
                   "cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal's condition or the omission of"+
                   "any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and"+
                   "its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination,"+
                   "history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about"+
				   "me and my pet, as well as information about my claim experience, to my veterinarian.";
		html+= "<tr><td>Signature of Pet Owner:<input maxlength='20' id='txtSign' type='text' name='Signature' value='"+Signature+"'/></td><td>";
		html+="Date:<input type='Text' name='timestamp' value='"+timestamp+"'>";
		html+="</td></tr></table></td></tr></tbody></table></td></tr><tr>";
        html+="<td colspan='3'>";
        html+="<input id='Submit1' type='submit' value='submit' />";
                        
        html+="</td></tr></tbody></table>";
        html+="</form></body></html>";
	    out.println(html);
	
	    out.close();    
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException 
	  {
		  response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	  
	  out.println("<table border='1'>");
	  out.println("<tr><td><strong>Parameters</strong></td><td><strong>Values</strong></td></tr>");
	  
	  //Allowed space in Name
	  String userName=request.getParameter("userName");
	  userName=userName.replaceAll("[^\\dA-Za-z]",
                "");
				
	  String state=request.getParameter("State");
	  state=state.replaceAll("[^A-Za-z]",
                "").replaceAll("\\s", "+").trim();
				
	
	 String address=request.getParameter("Address");
	  address=address.replaceAll("[^\\dA-Za-z]",
                "");			
      
	  
	 String City=request.getParameter("City");
	  City=City.replaceAll("[^A-Za-z]",
                "").replaceAll("\\s", "+").trim();	

	  String Name=request.getParameter("Name");
	  Name=Name.replaceAll("[^\\dA-Za-z]",
                "").replaceAll("\\s", "+").trim();
				
	  String Breed=request.getParameter("Breed");
	  Breed=Breed.replaceAll("[^\\dA-Za-z]",
                "").replaceAll("\\s", "+").trim();
	 			
	   String Story=request.getParameter("Story");
	  	
				
	 String ClinicName=request.getParameter("Clinic Name");
	  ClinicName=ClinicName.replaceAll("[^\\dA-Za-z]",
                "").replaceAll("\\s", "+").trim();	
				
	  String Signature=request.getParameter("Signature");
	  Signature=Signature.replaceAll("[^\\dA-Za-z]",
                "").replaceAll("\\s", "+").trim();	
	  
	  if (userName.equals("")||Signature.equals("")||ClinicName.equals("")||Story.equals("")||Name.equals("")||City.equals("")||state.equals("")||address.equals("")) {
		   
            response.sendRedirect("/assignment2part4/error.jsp");
        }	
	  
	  out.println("<tr><td>City:</td><td>"+City+"</td></tr>");
      out.println("<tr><td>UserName:</td><td>"+userName+"</td></tr>");
	  out.println("<tr><td>Address:</td><td>"+address+"</td></tr>");	  
	  out.println("<tr><td>State:</td><td>"+state+"</td></tr>");
	  //Done from Client Side
	  out.println("<tr><td>Zip:</td><td>"+request.getParameter("Zip")+"</td></tr>");
	  out.println("<tr><td>Phone:</td><td>"+request.getParameter("Phone")+"</td></tr>");
	  out.println("<tr><td>Account Number:</td><td>"+request.getParameter("Account_Number")+"</td></tr>");
	  out.println("<tr><td>Amount:</td><td>"+request.getParameter("Amount")+"</td></tr>");
	  
				
	   
	  out.println("<tr><td>Pet Name:</td><td>"+Name+"</td></tr>");
	  
	  
				
	   
	  out.println("<tr><td>Breed:</td><td>"+Breed+"</td></tr>");
	  
	  //Client Side	
	  out.println("<tr><td>Age:</td><td>"+request.getParameter("Age")+"</td></tr>");
	  out.println("<tr><td>Gender:</td><td>"+request.getParameter("gender")+"</td></tr>");
	  
	  
	 	
	  
	  out.println("<tr><td>Story:</td><td>"+Story+"</td></tr>");
	  
	  
	  out.println("<tr><td>Claim Type:</td><td>"+request.getParameter("chkClaimAccident")+"</td></tr>");
	  out.println("<tr><td>Claim Type:</td><td>"+request.getParameter("chkClaimIllness")+"</td></tr>");
	  out.println("<tr><td>Claim Type:</td><td>"+request.getParameter("chkClaimWellness")+"</td></tr>");
	  
	  out.println("<tr><td>Check Estimate:</td><td>"+request.getParameter("chkEstimate")+"</td></tr>");
	  out.println("<tr><td>Send Payment to</td><td>"+request.getParameter("chkPayment")+"</td></tr>");
	  out.println("<tr><td>Veterinarian:</td><td>"+request.getParameter("Veterinarian")+"</td></tr>");
	
		
	   
	  out.println("<tr><td>Clinic Name:</td><td>"+ClinicName+"</td></tr>");
	  out.println("<tr><td>Phone Number:</td><td>"+request.getParameter("Phone Number")+"</td></tr>");
	  out.println("<tr><td>Fax:</td><td>"+request.getParameter("Fax")+"</td></tr>");
	  out.println("<tr><td>Check Vet:</td><td>"+request.getParameter("chkVet")+"</td></tr>");
	  out.println("<tr><td>Check New Condition:</td><td>"+request.getParameter("chkNewCond")+"</td></tr>");
	  
	  	
	  out.println("<tr><td>Signature:</td><td>"+Signature+"</td></tr>");
	  out.println("<tr><td>Date:</td><td>"+request.getParameter("timestamp")+"</td></tr>");
	  out.println("</table>");
	  
	  
      
	  out.close();	
	  }
}