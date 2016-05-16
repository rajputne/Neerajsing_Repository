<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>


<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Smart Energy</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
</head>
<body>
<div id="main">
		<div id="site_content">
	<form name="LoginCheck" action="LoginAndPasswordCheck.htm" method="post">
		Username:<input id="txtUsername" type="text" name="txtUsername" /><div id="Message"></div><br />
		Password:<input type="password" name="txtPassword" /><br />
		<button id="Submit">Submit</button>
	</form>
	</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		$("#txtUsername").keyup(function() {
			var username=document.getElementById("txtUsername").value;
			$.ajax({
				type : "POST",
				contentType : "application/json; charset=utf-8",
				data:username,
				url : "LoginCheck.htm",
				complete : function(data) {				
				
					var dataJson = data.responseText;
					
					var jsonResponse = JSON.parse(dataJson);
					
					
					if (jsonResponse.isCorrectUserAccount==true) {
				
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