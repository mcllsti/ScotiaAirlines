<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scotia Airlines- Enter Passenger Details</title>
</head>
<body>
<form action="getPassengerNameForm" method="POST">


	Passenger Name : <input type = "text" name = "txtPassengerName" />
	<br/><br/>
	Select passenger Type:
	<br/><br/>
	<input type="submit" value="Ordinary Passenger" name="passengerTypeChoice"/>
	<br/><br/>
	<input type="submit" value="Island Resident" name="passengerTypeChoice"/>
	<br/><br/>
	<input type="submit" value="Business Traveller" name="passengerTypeChoice"/>
	
	
</form>
	<input type="submit" value="Return to Booking Menu" onclick="location.href='bookingMenu'"/>
</body>
</html>