

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smart Energy Billing System</title>
</head>
<link href="<c:url value="/resources/css/jquery.datepick.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/image_slide.js" />"></script>

<body>
	<div id="main">
		<div id="header">
			<div id="banner">
				<div id="welcome">
					<h1>Welcome To Smart Energy</h1>
				</div>
				<!--close welcome-->
				<div id="menubar">
					<ul id="menu">
						<li class="current"><a href="AddConsumer.htm">Create
								Consumer</a></li>
						<li><a href="CreateLocalVendor.htm">Create Local Vendor</a></li>
						<li><a href="AddGlobalEnergy.htm">Create Global Vendor</a></li>
						<li><a href="Login.htm">ExistingUser</a></li>
					</ul>
				</div>
				<!--close menubar-->
			</div>
			<!--close banner-->
			<br> <br> <br>
			<div id="site_content">

				<div class="slideshow">
					<ul class="slideshow">
						<li class="show"><img width="900" height="350"
							src="resources/images/home_1.jpg"
							alt="Renewable Sources are best source of energy" /></li>
						<li><img width="900" height="350"
							src="resources/images/home_2.jpg" alt="Wind Power At its Best" /></li>
					</ul>
				</div>
				
				<!--close slideshow-->
			</div>
			
			<!--close header-->

		</div>
	</div>

</body>
</html>
