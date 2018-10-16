<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Get Seat Number</title>
</head>
<body>

<h1>Enter Seat Number</h1>

<form action="getSeatNoForm" method="POST">

	${output[0]} :

	<input type = "text" name = "txtSeatNo" />
	<br/><br/>
	<input type="submit" value= "${output[1]}" />
	<br/><br/>
	<input type="submit" value= "${output[2]}"/>

</form>

</body>
</html>