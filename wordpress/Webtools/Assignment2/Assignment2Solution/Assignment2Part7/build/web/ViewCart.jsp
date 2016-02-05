<%-- 
    Document   : ViewCart
    Created on : Feb 2, 2016, 8:37:25 PM
    Author     : neera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Cart"%>
<%@page import="Bean.Product"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Cart</title>
</head>

<form action="ViewCart">
    <%
        session = request.getSession();

        Cart myCart = new Cart();
        myCart = (Cart) session.getAttribute("cart");
        int addPrice = 0;
        for (Product p : myCart.getCart()) {

            addPrice += p.getPrice();

    %>
    <h4> Product Name </h4><jsp:expression>p.getName()</jsp:expression> <h4> Product price </h4>  <jsp:expression>p.getPrice()</jsp:expression>
    <input type="checkbox" name="removedProducts" value=<jsp:expression>p.getID()</jsp:expression>>
        Check to Remove Item<br/>

    <jsp:scriptlet>
        }
    </jsp:scriptlet>
    <br/>
    <strong>Total:<jsp:expression>addPrice</jsp:expression></strong>
    <br/>
    <input type="Submit" name="Submit" value="Remove selected item"/>


</form>


