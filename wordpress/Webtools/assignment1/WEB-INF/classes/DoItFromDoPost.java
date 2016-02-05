import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Enumeration;
 
public class DoItFromDoPost extends HttpServlet  
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
		
		String acc_number="";
		String clinic_name="";
		String ph_number="";
		String fax_number="";
		
		String Signature="";
		String timestamp="";
		
        String html="<html><head><title>DoItFromDoPost</title></head><body><form action='DoItFromDoPost' method='post'>";
		
		html+="<table border='1'>";
		html+="<tbody><tr><td> <h1> ASPCA</h1> </td><td> <h1> Some Box</h1></td><td> <h1> Some Box</h1></td></tr><tr>";
		html+="<td colspan='3'>Claim Form PLEASE INCLUDE YOUR PET'S MEDICAL RECORDS TO HELP EXPEDITE PROCESSING.</td>";
		html+="</tr><tr><td colspan='3'>";
		html+="<br />1. General Information Please fill out this form completely. Incomplete forms will delay processing.";
		html+="</td> </tr><tr>";
		html+="<td colspan='3'><table border='1'><tbody><tr><td>Your Information Check here if this is a new address <br />";
		html+="<table border='1'><tbody>";
		html+="<tr> <td>Name:</td><td><input id='txtName' type='text' name='userName' value='"+username+"'/></td></tr>";
		html+="<tr> <td>Address:</td><td><textarea id='txtAreaAddress' name='Address' rows='2' cols='20' value='"+address+"'></textarea></td></tr>";
		html+="<tr> <td>State:</td><td><input id='txtState' type='text' name='State' value='"+state+"' /></td></tr>";
		html+="<tr> <td>City:</td><td><input id='txtCity' type='text' name='City' value='"+city+"' /></td></tr>";
		html+="<tr> <td>Zip:</td><td><input id='txtZip' type='text' name='Zip' value='"+zip+"' /></td></tr>";
		html+="<tr> <td>Phone:</td><td><input id='txtPhoneNumber' type='text' name='Phone' value='"+phone+"'/></td></tr>";
		html+="</tbody></table></td><td valign='top'>'Pet Information<table border='1'><tbody>";
		
		html+="<tr> <td>Account Number:</td><td><input id='txtAccNumber' type='text' name='Account_Number' value='"+account_number+"' /></td></tr>";
		html+="<tr> <td>Name:</td><td><input id='txtPetName' type='text' name='Name' value='"+name+"' /></td></tr>";
		html+="<tr> <td>Breed</td><td><input id='txtBreed' type='text' name='Breed' value='"+breed+"' /></td></tr>";
		html+="<tr> <td>Age:</td><td><input id='txtAge' type='text' name='Age' value='"+age+"' /></td></tr>";
		html+="<td>Gender:</td><td><input type='radio' name='gender' value='male'> Male<br>";
        html+="<input type='radio' name='gender' value='female'> Female<br>";
        html+="<input type='radio' name='gender' value='other'> Other<td>";
		
		html+="<td></tr></tbody></table></td></tr></tbody></table></td></tr><tr>";
		html+="<td colspan='3'><table><tbody><tr><td>2. Diagnosis/Symptom Information</td><td>";
		html+=" 2. HELP US! By providing the Story of Occurrence/Diagnosis, you will help<br />us avoid delays in processing your claim.";
		html+="</td></tr></tbody></table></td></tr><tr><td colspan='3'><table><tbody><tr>";
		html+="<td>Story of Occurrence/Diagnosis - Please describe this incident, including dates, details and symptoms leading up to it.</td></tr><tr>";
		html+="<td><textarea id='TextArea1' rows='3' cols='60' value='"+textAreaa+"'></textarea></td></tr>";
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
		 html+="<tr> <td>Total amount claimed:</td><td><input id='txtAmount' type='text' name='Amount' value='"+amount+"' /></td></tr>";
        html+="<tr>";
         html+="<td>Date illness/injury first occurred:</td><td>";
		html+="<input id='txtDate' type='text' name='Date' value='"+dateField+"'/>";
		html+="</td></tr><tr><td>Send Payment to</td><td>";
		html+= "<input type='radio' name='chkPayment' value='yes'>Yes";
         html+= "<input type='radio' name='chkPayment' value='no'>No</td>";
		 html+="</tr></tbody></table></td><td><table border='1'><tbody>";
		 html+= "<tr> <td>Veterinarian:</td><td><input id='txtAccNumber' type='text' name='Account Number' value='"+acc_number+"' /></td></tr>";
         html+="<tr> <td>Clinic Name:</td><td><input id='txtClinicName' type='text' name='Clinic Name' value='"+clinic_name+"' /></td></tr>";
         html+="<tr> <td>Phone</td><td><input id='txtPhoneNumber1' type='text' name='Phone Number' value='"+ph_number+"' /></td></tr>";
         html+="<tr> <td>Fax:</td><td><input id='txtFax' type='text' name='Fax' value='"+fax_number+"'/></td></tr>";
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
		html+= "<tr><td>Signature of Pet Owner:<input id='txtSign' type='text' name='Signature' value='"+Signature+"'/></td><td>";
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
		  String html="<html><head><title>DoItFromDoPost</title></head><body>";
		  PrintWriter out = response.getWriter();
		  Enumeration e = request.getParameterNames();

		   html+="<h1>Using getParameter</h1>";
	  
			while(e.hasMoreElements())
			{
				String name=(String) e.nextElement();
				html+=name +" : ";
				String value=request.getParameter(name);
				html+=value+"<br>";

			} 
			out.println("<h4>"+html+"</h4>");
			out.println("Request over");
			out.close();
	  }
}