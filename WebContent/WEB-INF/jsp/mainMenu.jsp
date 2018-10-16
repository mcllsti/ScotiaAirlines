<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Main Menu</title>
</head>
<body>

<h1>Scotia Airlines - Main Menu</h1>

<input type = "submit" value = "Flight Administration" onclick = "location.href='adminOptions'"/>
<br/><br/>

<form action="mainMenuForm" method="POST">
<input type = "submit" value = "Booking Menu" name="mainMenuChoice"/>
<br/><br/>
<input type = "submit" value = "Display Seat Details" name="mainMenuChoice"/>
<br/><br/>
<input type = "submit" value = "Display Flight Details" name="mainMenuChoice"/>
</form>

</body>
</html>