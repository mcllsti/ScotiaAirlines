<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Booking Menu</title>
</head>
<body>

	<h1>Scotia Airlines - Booking Menu</h1>
	
	${selectedFlight.flightNumber}
	<br/><br/>
	
	<form action="bookingMenuForm" method="POST">
		<input type="submit" value="Cancel A Reservation/Booking" name="bookingMenuChoice"/>
		<br/><br/>
		<input type="submit" value="Reserve A Seat" name="bookingMenuChoice"/>
		<br/><br/>
		<input type="submit" value="Book A Seat" name="bookingMenuChoice"/>
		<br/><br/>
		<input type="submit" value="Return to Flight Selection" name="bookingMenuChoice"/>
	</form>
	
</body>
</html>