<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Promo</title>
</head>
<body>
<form action="getPromoForm" method="POST">


	Is this part of a promotion? : <input type = "text" name = "txtPromo" />
	<br/><br/>
	<input type="submit" value="Submit"/>	
	
</form>
	<input type="submit" value="Return to Passenger Name" onclick="location.href='getPassengerName'"/>
</body>
</html>