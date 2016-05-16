<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumer DashBoard</title>
</head>
<link href="<c:url value="/resources/css/jquery.datepick.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/LoggingMessage.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>


<body>
<div id="main">
		<div id="site_content">
	<form name="Something" action="Logout.htm">
		<h2>Welcome Consumer this is your dashboard:
			${Consumer.firstName}</h2>
		<br>
		<table>
			<tr>
				<td>How many devices you want to connect</td>
				<td><input type="text" id="txtNumb"></input></td>
				<td>
					<button id="Connect" type="button" onclick="create()">How
						many devices you want to Connect</button>
				</td>
			</tr>
			<tr>
				<td><span id="screens"></span></td>
			</tr>
			<tr>
				<td><button id="btnConnect" type="button">Add the
						Devices</button></td>
				<td><button id="btnGetGlobalEnergyBill" type="button">Get
						My GlobalBill</button></td>
				<td><div id="MessageGlobalBill"></div></td>
			</tr>
			<tr>
				<td><button id="btnConnectToElectricity" type="button">Connect
						To Electricity</button>
					<button id="btnDisConnectToElectricity" type="button">Stop
						The Electricity</button></td>
				<td>
					<button id="btnGetLocalEnergyBill" type="button">Get My
						LocalBill</button>
				</td>
				<td><div id="MessageLocalBill"></div></td>
			</tr>
			<tr>
				<td>
					<button type="button" id="btnCheckEffect" name="btnCheckEffect">Check
						Effect</button></td>
				<td>Tempereture:<input maxlength="2" type="text" id="txtTemp"></td>
				<td>Wind:<input type="text" maxlength="2" id="txtWind"></td>
			</tr>
			<tr>
				<td colspan="3">
					<div class="container">
						<h2>Log Messages</h2>
						<div id="Message" class="ourwork"></div>
					</div>
				</td>
			</tr>
			<tr>

			</tr>
			<tr>

			</tr>
			<tr>
				<td>
					<button id="btnLogout" type=submit>Logout</button> <input
					type="hidden" id="hdnConsId" value="${Consumer.consumerId}">
				</td>
			</tr>

		</table>
	</form>
	</div>
	</div>
</body>

<script>
	function create() {
		var param = document.getElementById("txtNumb").value;
		var s = "";
		if (!isNaN(param)) {
			s = '<table border=1><tr><td>Device Name </td><td>Power</td><td>Voltage</td></tr>';
			for (var i = 0; i < param; i++) {
				s += '<tr><td><input maxlength="10" type="text" id="devName'+i+'"></td>';
				s += '<td><input maxlength="2" type="text" id="Power' + i + '"></td>';
				s += '<td><input maxlength="2" type="text" id="Voltage' + i + '"></td>';
				document.getElementById("screens").innerHTML = s;
			}
			s += '</table>';

			document.getElementById("screens").innerHTML = s;
		} else {
			s += 'Please input number';
			document.getElementById("screens").innerHTML = s;
		}
	}

	var interval;
	$(document)
			.ready(
					function() {
						$("#btnCheckEffect").click(function() {
							var temp = $("#txtTemp").val();
							var wind = $("#txtWind").val();
							

							$.ajax({
								type : "POST",
								url : "CheckEffect.htm",
								data : temp + "&" + wind,
								error : function(data) {
									alert("Data not entered correctly");
								},
								success : function(data) {
									//Not working check tomorrow				
									

								}
							})
						})

						$("#btnLogout").click(function() {
							var temp = $("#hdnConsId").val();
							
							$.ajax({
								type : "POST",
								url : "Logout.htm",
								data : consumerId,
								success : function(data) {
									//Not working check tomorrow				
									

								}
							})
						})
						$("#btnGetLocalEnergyBill")
								.click(
										function() {
											var consumerId = $("#hdnConsId")
													.val();
											
											$
													.ajax({
														type : "POST",
														contentType : "application/json; charset=utf-8",
														url : "GetLocalCharge.htm",
														data : consumerId,
														complete : function(
																data) {
															//Not working check tomorrow
															var dataJson = data.responseText;
															var jsonResponse = JSON
																	.parse(dataJson);
															$(
																	"#MessageLocalBill")
																	.html(
																			jsonResponse.localBill);
														}
													})
										})

						$("#btnGetGlobalEnergyBill")
								.click(
										function() {
											var consumerId = $("#hdnConsId")
													.val();
											
											$
													.ajax({
														type : "POST",
														contentType : "application/json; charset=utf-8",
														url : "GetGlobalCharge.htm",
														data : consumerId,
														complete : function(
																data) {
															//Not working check tomorrow
															var dataJson = data.responseText;

															var jsonResponse = JSON
																	.parse(dataJson);

															$(
																	"#MessageGlobalBill")
																	.html(
																			jsonResponse.globalBill);
														}
													})
										})
						$("#btnDisConnectToElectricity").click(function() {
							clearInterval(interval);
						})

						$("#btnConnectToElectricity")
								.click(
										function() {
											interval = setInterval(
													function() {

														$
																.ajax({
																	type : "post",
																	url : "ConnectToElect.htm",

																	complete : function(
																			data) {
																		var dataJson = data.responseText;

																		var jsonResponse = JSON
																				.parse(dataJson);
																		var c = jsonResponse.Message;

																		$(
																				"#Message")
																				.append(
																						"<li>"
																								+ c
																								+ "</li>");
																	}
																});
													}, 2000);
										})

						$("#btnConnect")
								.click(
										function() {

											var param = document
													.getElementById("txtNumb").value;
											info = [];

											for (var i = 0; i < param; i++) {

												var s = document
														.getElementById("devName"
																+ i).value;
												info.push(s);
												var s1 = document
														.getElementById("Power"
																+ i).value;
												info.push(s1);
												var s2 = document
														.getElementById("Voltage"
																+ i).value
												info.push(s2 + ":");
												if (s.indexOf(",") > -1
														|| isNaN(s1)
														|| isNaN(s2)
														|| s1.indexOf(",") > -1
														|| s2.indexOf(",") > -1) {
													alert("Correct values not entered");
													return;
												}
												var consumerId = $("#hdnConsId").val();
												
												info.push("consumerId"+consumerId);
												

											}
											
											$
													.ajax({
														type : "POST",
														contentType : "application/json; charset=utf-8",
														url : "ConnectToElectricity.htm",
														data : info.toString(),
														error : function() {
															var dataJson = data.responseText;

															var jsonResponse = JSON
																	.parse(dataJson);
															var c = jsonResponse.error;
															$(
																	"#btnConnectToElectricity")
																	.prop(
																			"disabled",
																			true);

															
														},
														complete : function(
																data) {
															$(
																	"#btnConnectToElectricity")
																	.prop(
																			"disabled",
																			false);

														}
													})
										})
					});
</script>


</html>