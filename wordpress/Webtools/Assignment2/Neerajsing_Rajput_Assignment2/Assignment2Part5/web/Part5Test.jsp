<%-- 
    Document   : Part5Test
    Created on : Feb 1, 2016, 2:34:08 AM
    Author     : neera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServlet" %>

<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Pet Insurance Form
        </title>
        <script src="javascripts/Datepick/ts_picker.js"></script>
        <script src="javascripts/ValidationScript.js"></script>
        <link href="styles/style.css" rel="stylesheet" />
        <meta charset="utf-8" />
    </head>
    <body>

        <FORM name="tstest" METHOD="GET" onsubmit="return validateForm()" ACTION="Part5Test.jsp">
            <table border="1">
                <tbody>
                    <tr>
                        <td valign="top"> <h1> ASPCA</h1><br />Pet Health Insurance </td>
                        <td valign="top">  For office use only</td>
                        <td valign="top"> HAVE A QUESTION?<br />Call us at 1-866-204-6764</td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Claim Form PLEASE INCLUDE YOUR PET'S MEDICAL RECORDS TO HELP EXPEDITE PROCESSING.
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <br />
                            1. General Information Please fill out this form completely. Incomplete forms will delay processing.
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <table border="1">
                                <tbody>
                                    <tr>
                                        <td>
                                            Your Information Check here if this is a new address <br />
                                            <table border="1">
                                                <tbody>
                                                    <tr> <td>Name:</td><td><input id="txtName" type="text" name="userName" /></td></tr>
                                                    <tr> <td>Address:</td><td><textarea id="txtAreaAddress" name="Address" rows="2" cols="20"></textarea></td></tr>
                                                    <tr> <td>State:</td><td><input id="txtState" type="text" name="State" /></td></tr>
                                                    <tr> <td>City:</td><td><input id="txtCity" type="text" name="City" /></td></tr>
                                                    <tr> <td>Zip:</td><td><input id="txtZip" type="text" name="Zip"  oninput="checkZipCode()" /><p id="zipError"></p></td></tr>

                                                    <tr> <td>Phone:</td><td><input id="txtPhoneNumber" type="text" name="Phone" oninput="phonenumber()" /><p id="phoneError"></p></td></tr>
                                                </tbody>

                                            </table>
                                        </td>
                                        <td valign="top">
                                            Pet Information
                                            <table border="1">
                                                <tbody>
                                                    <tr> <td>Account Number:</td><td><input oninput="accountNumberValidate()" id="txtAccNumber" type="text" name="Account_Number" /><p id="accountNumber"></p></td></tr>
                                                    <tr> <td>Name:</td><td><input id="txtPetName" type="text" name="Name" /></td></tr>
                                                    <tr> <td>Breed</td><td><input id="txtBreed" type="text" name="Breed" /></td></tr>
                                                    <tr> <td>Age:</td><td><input id="txtAge" oninput="checkAge()" type="text" name="Age" /><p id="ageFactor"></p></td></tr>
                                                    <tr>
                                                        <td>Gender:</td>
                                                        <td>
                                                            <input type="radio" name="gender" value="male"> Male<br>
                                                            <input type="radio" name="gender" value="female"> Female<br>
                                                            <input type="radio" name="gender" value="other"> Other

                                                        <td>
                                                    </tr>
                                                </tbody>

                                            </table>
                                        </td>

                                    </tr>

                                </tbody>

                            </table>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>2. Diagnosis/Symptom Information</td>
                                        <td>
                                            2. HELP US! By providing the "Story of Occurrence/Diagnosis," you will help<br />
                                            us avoid delays in processing your claim.
                                        </td>
                                    </tr>

                                </tbody>

                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Story of Occurrence/Diagnosis - Please describe this incident, including dates, details and symptoms leading up to it.</td>
                                    </tr>
                                    <tr>
                                        <td valign="middle"><textarea style="width:90%; display: block;margin-left: auto;margin-right: auto;" id="txtStory" rows="3" name="Story" cols="60"></textarea></td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <table border="1">
                                <tbody>
                                    <tr>
                                        <td>

                                            <table border="1">
                                                <tbody>
                                                    <tr>
                                                        <td>This claim is related to:</td>
                                                        <td>
                                                            <input type="checkbox" name="chkClaimAccident" value="accident">Accident
                                                            <input type="checkbox" name="chkClaimIllness" value="illness">Illness
                                                            <input type="checkbox" name="chkClaimWellness" value="wellness">Welness
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Is this claim an estimate for future treatment?</td>
                                                        <td>
                                                            <input type="radio" name="chkEstimate" value="Yes"> Yes<br>
                                                            <input type="radio" name="chkEstimate" value="No"> No<br>

                                                        </td>
                                                    </tr>
                                                    <tr> <td>Total amount claimed:</td><td><input id="txtAmount" oninput="amountValidate()" type="text" name="Amount" /><p id="AmountError"></p></td></tr>
                                                    <tr>
                                                        <td>Date illness/injury first occurred:</td>
                                                        <td>
                                                            <input id="txtDate" type="text" name="Date" />
                                                            <a href="javascript:show_calendar('document.tstest.Date', document.tstest.Date.value);">

                                                                <img src="javascripts/Datepick/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp" />
                                                            </a>

                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Send Payment to</td>
                                                        <td>
                                                            <input type="radio" name="chkPayment" value="yes">Yes
                                                            <input type="radio" name="chkPayment" value="no">No
                                                        </td>
                                                    </tr>
                                                </tbody>

                                            </table>
                                        </td>
                                        <td>
                                            <table border="1">
                                                <tbody>
                                                    <tr> <td>Veterinarian:</td><td><input id="txtAccNumber" type="text" name="Veterinarian" /></td></tr>
                                                    <tr> <td>Clinic Name:</td><td><input id="txtClinicName" type="text" name="Clinic Name" /></td></tr>
                                                    <tr> <td>Phone</td><td><input id="txtPhoneNumber1" type="text" name="Phone Number" oninput="phonenumber2()" /><p id="phoneError2"></p></td></tr>
                                                    <tr> <td>Fax:</td><td><input id="txtFax" oninput="faxValidate()" type="text" name="Fax" /><p id="FaxError"></p></td></tr>
                                                    <tr>
                                                        <td>Did any other veterinarian treat your pet?</td>
                                                        <td>
                                                            <input type="radio" name="chkVet" value="yes">Yes
                                                            <input type="radio" name="chkVet" value="no">No
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Is this a new condition?:</td>
                                                        <td>
                                                            <input type="radio" name="chkNewCond" value="yes">Yes
                                                            <input type="radio" name="chkNewCond" value="no">No
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">
                                            <table>
                                                <tr><td>3.Pet Owner Declaration</td></tr>
                                                <tr>
                                                    <td>
                                                        I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may
                                                        exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim
                                                        cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal's condition or the omission of
                                                        any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and
                                                        its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination,
                                                        history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about
                                                        me and my pet, as well as information about my claim experience, to my veterinarian.
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Signature of Pet Owner:<input id="Text1" type="text" name="Signature" /></td>
                                                    <td>
                                                        Date:
                                                        <input type="Text" name="timestamp" value="">
                                                        <a href="javascript:show_calendar('document.tstest.timestamp', document.tstest.timestamp.value);">

                                                            <img src="javascripts/Datepick/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp" />
                                                        </a>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <div class="wrapper">
                                <input id="Submit1" type="submit" value="submit"  />
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </FORM>
        <h1>The parameters are</h1>
        <% 

            String userName = request.getParameter("userName");
            

            String state = request.getParameter("State");
            

            String address = request.getParameter("Address");
            

            String City = request.getParameter("City");
            

            String Name = request.getParameter("Name");
            

            String Breed = request.getParameter("Breed");
          

            String Story = request.getParameter("Story");
            

            String ClinicName = request.getParameter("Clinic Name");
         
            String Signature = request.getParameter("Signature");
       
        %>
<table border="1">
            <tbody >
                <tr><td>Name:</td><td><%= userName %></td></tr>    
                <tr><td>Address</td><td><%= address %></td></tr>
                <tr><td>City:</td><td><%= City %></td></tr>
                <tr><td>State:</td><td><%= state %></td></tr>
                <tr><td>Zip:</td><td><%= request.getParameter("Zip") %></td></tr>
                <tr><td>Phone:</td><td><%= request.getParameter("Phone") %></td></tr>
                <tr><td>Account Number:</td><td><%= request.getParameter("Account_Number") %></td></tr>
                <tr><td>Amount:</td><td><%= request.getParameter("Amount") %></td></tr>
                <tr><td>Name:</td><td><%= Name %></td></tr>
                <tr><td>Breed:</td><td><%= Breed %></td></tr>
                <tr><td>Age:</td><td><%= request.getParameter("Age") %></td></tr>
                <tr><td>Gender:</td><td><%= request.getParameter("gender") %></td></tr>
                <tr><td>Story:</td><td><%= Story %></td></tr>
                <tr><td>Claim Accident:</td><td><%= request.getParameter("chkClaimAccident") %></td></tr>
                <tr><td>Claim Illness:</td><td><%= request.getParameter("chkClaimIllness") %></td></tr>
                <tr><td>Claim Wellness:</td><td><%= request.getParameter("chkClaimWellness") %></td></tr>
                <tr><td>Do you want Estimate:</td><td><%= request.getParameter("chkEstimate") %></td></tr>
                <tr><td>Do you want Payment:</td><td><%= request.getParameter("chkPayment") %></td></tr>
                
                <tr><td>Vet:</td><td><%= request.getParameter("Veterinarian") %></td></tr>
                <tr><td>Clinic Name:</td><td><%= ClinicName %></td></tr>
                <tr><td>Fax:</td><td><%= request.getParameter("Fax")%></td></tr>
                <tr><td>Check Vet:</td><td><%= request.getParameter("chkVet") %></td></tr>
                <tr><td>Check New Condition:</td><td><%= request.getParameter("chkNewCond") %></td></tr>
                
                <tr><td>Signature:</td><td><%= Signature %></td></tr>
                <tr><td>Date:</td><td><%= request.getParameter("timestamp") %></td></tr>
            </tbody>
        </table>

    </body>

</html>
