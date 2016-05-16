<%@page import="com.smartenergy.spring.pojo.Consumer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<link href="<c:url value="/resources/css/jquery.datepick.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/LoggingMessage.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
     
<body>
<div id="main">
		<div id="site_content">
	<form action="ConsumerDash.htm">
		New User Created Successfully: ${Consumer.firstName}<br>
		<c:set var="Consumer" value="${Consumer}" scope="session" />
		UserName:<input type="text" id="txtUserName" name="txtUserName" maxlength="20" /><br /> Password:<input
			type="password"  name="txtPassword" maxlength="20" /><br /> <input id="Submit" type="submit"
			value="Create User Account">
			<div id="Message"></div>
	</form>
	</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		$("#txtUserName").keyup(function() {
			var username=document.getElementById("txtUserName").value;
			$.ajax({
				type : "POST",
				contentType : "application/json; charset=utf-8",
				data:username,
				url : "LoginCheck.htm",
				complete : function(data) {				
					var dataJson = data.responseText;
					var jsonResponse = JSON.parse(dataJson);
					if (jsonResponse.isCorrectUserAccount==false) {
						$("#Message").html("User Account Valid");
						$("#Submit").prop("disabled",false);	
					}
					else
						{
						$("#Message").html("User Account Invalid");
						$("#Submit").prop("disabled",true);
						}
				}
			}

			)
		});
	});
</script>
</html>