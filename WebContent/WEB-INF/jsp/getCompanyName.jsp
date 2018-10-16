<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Company Name</title>
</head>
<body>
<form action="getComapnyNameForm" method="POST">


	Please enter name of company : <input type = "text" name = "txtCompanyName" />
	<br/><br/>
	<input type="submit" value="Submit"/>	
	
</form>
	<input type="submit" value="Return to Passenger Name" onclick="location.href='getPassengerName'"/>
</body>
</html>