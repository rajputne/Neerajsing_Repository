<%-- 
    Document   : Part5
    Created on : Jan 31, 2016, 9:08:25 PM
    Author     : neeraj
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parameters Received</title>
    </head>
    <body >
        <h1>Receiving Parameters using JSP</h1>
        <%

            String userName = request.getParameter("userName");
            userName = userName.replaceAll("[^\\dA-Za-z]",
                    "");

            String state = request.getParameter("State");
            state = state.replaceAll("[^A-Za-z]",
                    "").replaceAll("\\s", "+").trim();

            String address = request.getParameter("Address");
            address = address.replaceAll("[^\\dA-Za-z]",
                    "");

            String City = request.getParameter("City");
            City = City.replaceAll("[^A-Za-z]",
                    "").replaceAll("\\s", "+").trim();

            String Name = request.getParameter("Name");
            Name = Name.replaceAll("[^\\dA-Za-z]",
                    "").replaceAll("\\s", "+").trim();

            String Breed = request.getParameter("Breed");
            Breed = Breed.replaceAll("[^\\dA-Za-z]",
                    "").replaceAll("\\s", "+").trim();

            String Story = request.getParameter("Story");
            Story = Story.replaceAll("[^\\dA-Za-z]",
                    "");

            String ClinicName = request.getParameter("Clinic Name");
            ClinicName = ClinicName.replaceAll("[^\\dA-Za-z]",
                    "").replaceAll("\\s", "+").trim();

            String Signature = request.getParameter("Signature");
            Signature = Signature.replaceAll("[^\\dA-Za-z]",
                    "").replaceAll("\\s", "+").trim();

            if (userName.equals("") || Signature.equals("") || ClinicName.equals("") || Story.equals("") || Name.equals("") || City.equals("") || state.equals("") || address.equals("")) {
                //response.sendRedirect("/Assignment2Part5/error.jsp");
            }
            
            
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