<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<link href="<c:url value="/resources/css/LoggingMessage.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.plugin.js" />"></script>
   
<head>
<style>
table {
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid white;
}
</style>
<title>Home</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		$("#Subscribe").click(function() {
			var radSelectedLocal=$("input[name=rad_Select]:checked").val();
		
			document.getElementById("ls").value=radSelectedLocal;
				
			var radSelected=$("input[name=rad_Select_Global]:checked").val();
			
			document.getElementById("gs").value=radSelected;
			
			if(radSelectedLocal==null || radSelected==null )
			{
			alert("Select both the services");	
			return;
				
			}
			else
				{
				document.getElementById("myFormConsumerSubscription").submit();
				}
		})
		$("#Global").click(function() {
			$.ajax({
				type : "POST",
				contentType : "application/json; charset=utf-8",
				url : "ConsumerSelectsGlobalEnergy.htm",
				complete : function(data) {
					
					var dataJson = data.responseText;
					
					var jsonResponse = JSON.parse(dataJson);
					$("#global").html("");
				
					var x = document.createElement("TABLE");
					x.setAttribute("id", "myTable2");
					document.getElementById("global").appendChild(x);
					var y = document.createElement("TR");
					y.setAttribute("id", "myTrr");
					document.getElementById("myTable2").appendChild(y);
					var z = document.createElement("TH");
					var t = document.createTextNode("Select");
					z.appendChild(t);
					
					document.getElementById("myTrr").appendChild(z);
					var z = document.createElement("TH");
					var t = document.createTextNode("GlobalEnergyServiceName");
					z.appendChild(t);
					document.getElementById("myTrr").appendChild(z);
					
					var z = document.createElement("TH");
					var t = document.createTextNode("Rate");
					z.appendChild(t);
					document.getElementById("myTrr").appendChild(z);
					
					
					var z = document.createElement("TH");
					var t = document.createTextNode("GlobalEnergyServiceDescription");
					z.appendChild(t);
					document.getElementById("myTrr").appendChild(z);
					$.each(jsonResponse.Globalservices, function(index, element) {
					
						var y = document.createElement("TR");
                        y.setAttribute("id", "myTrr" + index);
                        document.getElementById("myTable2").appendChild(y);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = index;
                        inp.setAttribute("type", "radio");
                        inp.setAttribute("name", "rad_Select_Global");
                        inp.setAttribute("id", "rad_Id");
                        inp.setAttribute("value",element.id.globalServiceId);
                        z.appendChild(inp);
                        document.getElementById("myTrr" + index).appendChild(z);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = element.globalServiceName;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp);
                        document.getElementById("myTrr" + index).appendChild(z);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = element.ratePerPower;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp); 
                        document.getElementById("myTrr" + index).appendChild(z);
                        
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        
                        inp.value = element.globalDescription;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp); 
                        document.getElementById("myTrr" + index).appendChild(z);
                        
						
					}
					)
					
					
				}
				}
			)
			}
		)
		
		$("#More").click(function() {
			
			var zip = document.getElementById('Zip').value;
		
			$.ajax({
				type : "POST",
				contentType : "application/json; charset=utf-8",
				url : "ConsumerSelectsEnergy.htm",
				data : zip,
				complete : function(data) {
				
					var dataJson = data.responseText;
					
					var jsonResponse = JSON.parse(dataJson);
					
			
					$("#success").html("");
					var x = document.createElement("TABLE");
					x.setAttribute("id", "myTable");
					document.getElementById("success").appendChild(x);
					var y = document.createElement("TR");
					y.setAttribute("id", "myTr");
					document.getElementById("myTable").appendChild(y);
					var z = document.createElement("TH");
					var t = document.createTextNode("Select");
					z.appendChild(t);
					
					document.getElementById("myTr").appendChild(z);
					var z = document.createElement("TH");
					var t = document.createTextNode("LocalEnergyServiceName");
					z.appendChild(t);
					document.getElementById("myTr").appendChild(z);
					var z = document.createElement("TH");
					var t = document.createTextNode("Rate");
					z.appendChild(t);

					document.getElementById("myTr").appendChild(z);
					var z = document.createElement("TH");
					var t = document.createTextNode("LocalEnergyServiceDescription");
					z.appendChild(t);
					document.getElementById("myTr").appendChild(z);
					
					document.getElementById("myTr").appendChild(z);
					var z = document.createElement("TH");
					var t = document.createTextNode("Local Batteries");
					z.appendChild(t);
					document.getElementById("myTr").appendChild(z);
					
					$.each(jsonResponse.LocalServices, function(index, element) {
						
						
						var y = document.createElement("TR");
                        y.setAttribute("id", "myTr" + index);
                        document.getElementById("myTable").appendChild(y);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = index;
                        inp.setAttribute("type", "radio");
                        inp.setAttribute("name", "rad_Select");
                        inp.setAttribute("id", "rad_Id");
                        inp.setAttribute("value",element.id.localServicesId);
                        z.appendChild(inp);
                        document.getElementById("myTr" + index).appendChild(z);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = element.localEnergyServiceName;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp);
                        document.getElementById("myTr" + index).appendChild(z);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = element.rate;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp); 
                        document.getElementById("myTr" + index).appendChild(z);
                        
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");
                        inp.value = element.localEnergyServiceDescription;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp); 
                        document.getElementById("myTr" + index).appendChild(z);
                        
                        var z = document.createElement("TD");
                        var inp = document.createElement("INPUT");        
                        inp.value = element.numberOfBatteriesInZip;
                        inp.setAttribute("type", "text");
                        inp.setAttribute("readOnly","true");
                        z.appendChild(inp); 
                        document.getElementById("myTr" + index).appendChild(z);
                    	  
                       
					})
				}
			})

		});
	});
</script>
</head>
<body>
<div id="main">
		<div id="site_content">
<form action="ConsumerSubscription.htm" id="myFormConsumerSubscription">
		<h1>
			New User Created Successfully: ${Consumer.firstName}<br>
			<c:set var="Zip" value="${Consumer.zip}" />
			<input type="hidden" value='${Consumer.zip}' name="Zip" id="Zip" />
		</h1>
		<table>
			<tr>
				<td>
					<button id="More" type="button">Get Local Area Services</button>

				</td>
			<tr>
				<td>
					<div id="success"></div><br>

				</td>
			<tr />
			<tr>
				<td>
					<button id="Global" type="button">Get Global Area Services</button>
				</td>
			</tr>
			<tr>
				<td>
					<span id="global"></span>
				</td>
			</tr>
			<tr>
				<td>
					<button id="Subscribe" type="button">Subscribe</button>
				</td>
				<td><input type="hidden" name="LocalSubscription" id="ls">
				 <input type="hidden" name="GlobalSubscription" id="gs">
				 <input type="hidden" name="ConsumerId" id="ConId" value="${Consumer.consumerId}">
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>

</html>
