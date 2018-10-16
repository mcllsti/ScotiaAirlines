<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add New Flight</title>
</head>
<body>


<h1>Scotia Airlines - Add New Flight</h1>

<form action="submitNewFlight" method = "POST">
Flight ID:<input type = "text" name = "txtFlightID" /> <br/><br/>
Departure:<input type = "text" name = "txtDeparture" /> <br/><br/>
Arrival:<input type = "text" name = "txtArrival" /> <br/><br/>
No. Of Rows:<input type = "text" name = "txtRows" /> <br/><br/>
No. Of Columns:<input type = "text" name = "txtColumns" /> <br/><br/>

<h3>${message}</h3>
	
<input type = "submit" value = "Submit"/>
</form>
<br/><br/>
<input type = "submit" value = "Clear" onclick="location.href='addFlight'"/>
<br/><br/>
<input type = "submit" value = "Return To Admin Options" onclick = "location.href='adminOptions'"/>



</body>
</html>