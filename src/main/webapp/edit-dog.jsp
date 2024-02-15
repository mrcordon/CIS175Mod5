<!-- Mike Cordon - mrcordon@dmacc.com
	 CIS175 Java 2
	 Module 5 Assignment - JPA/Servlet/JSP
	 FILE: edit-dog.jsp
	 02/15/24 
	 
	 Description:  A jsp file where an individual record for a dog from the 
	 			   database can be edited using a GUI-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a Dog</title>
<link rel="stylesheet" href="web-dog-stylesheet.css">
</head>
<body>
	<img src="dog-banner-image.png" alt="dogs">
	<br />
	<h1>Dog Database</h1><br /><br />
	<h3>Edit a Dog</h3>
	<form action="editDogServlet" method="post">
		Name:<input type="text" name="name" value="${dogToEdit.name}"><br />
		Breed:<input type="text" name="breed" value="${dogToEdit.breed}"><br />
		Color :<input type="text" name="color" value="${dogToEdit.color}"><br /><br />
		<input type="hidden" name="id" value="${dogToEdit.id}">
		<input type="submit" value="Save Dog">
	</form><br />	
	<br /><br /><br /><br />
	<img src="dog-banner-2.png" alt="more dogs">
</body>
</html>