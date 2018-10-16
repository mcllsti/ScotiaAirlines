<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Change Flight Status</title>
</head>
<body>

	<h1>Scotia Airlines - Change Flight Status</h1>
	
	${selectedFlight.flightNumber}
	<br/><br/>
	
	<form action="changeFlightStatusForm" method="POST">
		<input type="submit" value="Seats Available" name="changeFlightStatusChoice"/>
			<br/><br/>
		<input type="submit" value="Checking In" name="changeFlightStatusChoice"/>
			<br/><br/>
		<input type="submit" value="Boarding" name="changeFlightStatusChoice"/>
			<br/><br/>
		<input type="submit" value="Flight Closed" name="changeFlightStatusChoice"/>
			<br/><br/>
		<input type="submit" value="Return to Flight Selection" name="changeFlightStatusChoice"/>
	</form>
	
</body>
</html>