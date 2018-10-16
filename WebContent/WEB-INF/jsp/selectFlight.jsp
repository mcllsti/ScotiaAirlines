<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Select Flight</title>
</head>
<body>

<h1>Please Select Flight</h1>
<form action="afterSelectingFlight" method="POST">
<c:forEach var="flightEntry" items="${scotia.flights}"> 
	<input type = "submit" name="selectedFlight" value = "ID: ${flightEntry.value.flightNumber} ${flightEntry.value.departure} to ${flightEntry.value.arrival}" />
	<br/><br/>
</c:forEach>
</form>
<input type = "submit" value = "Return To Main Menu" onclick = "location.href='mainMenu'"/>

</body>
</html>