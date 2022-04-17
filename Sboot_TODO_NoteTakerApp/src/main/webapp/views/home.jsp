<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="base.jsp"%>
<meta charset="ISO-8859-1">
<title>Note Taker : Home page</title>

</head>
<body class="mybg">

<h1 class="myhead m-2">NOTE TAKER HOME PAGE</h1>

<!-- <button onclick="mybtnFunction()">Click me</button> -->
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>


		<div class="card  shadow bg-white py-5">
			<img alt="" class="img-fluid mx-auto" style="max-width: 300px;"
				src="img/notepad.png">
			<h1 class="text-primary text-uppercase text-center mt-3">Start Taking your notes</h1>

			<div class="container text-center">
				<a href="/add-notes" class="btn btn-outline-primary text-center">Start here</a>
			</div>

		</div>

	</div>



</body>
</html>