<!-- Mike Cordon - mrcordon@dmacc.com
	 CIS175 Java 2
	 Module 5 Assignment - JPA/Servlet/JSP
	 FILE: web-dogs.jsp
	 02/15/24 
	 
	 Description:  a jsp file that presents an html page that displays
	 			   the contents of the dogs table from the dog database
	 			   in a web friendly format.  When a dog is selected by a 
	 			   radio button, the user has the option to add a dog, 
	 			   edit a dog, or delete a dog from this page.-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select a Dog</title>
<link rel="stylesheet" href="web-dog-stylesheet.css">
</head>
<body>
	<img src="dog-banner-image.png" alt="dogs">
	<br />
	<h1>Our Dogs</h1><br /><br />
	<form method="post" action="navigationServlet">
		<table style="margin: 0px auto;">
			<c:forEach items="${requestScope.allDogs}" var="currentdog">
				<tr>
					<td><input type="radio" name="id" value="${currentdog.id}"></td>
					<td>${currentdog.name}</td>
					<td>${currentdog.breed}</td>
					<td>${currentdog.color}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToDog">
		<input type="submit" value="delete" name="doThisToDog">
		<input type="submit" value="add" name="doThisToDog">
	</form><br />	
	<br /><br /><br /><br />
	<img src="dog-banner-2.png" alt="more dogs">
</body>
</html>