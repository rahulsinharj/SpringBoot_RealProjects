<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Note</title>
<%@include file="base.jsp"%>
</head>
<body class="mybg">

<h1 class="myhead m-2">NOTE TAKER APP :</h1>
	<div class="container">
		<%@include file="navbar.jsp"%>
		
		<br><h2 class="text-center">Edit your note</h2><br>

		<form action="/save-updated-note" method="post">

			<input value="${note.id}" name="id" type="hidden" />

			<div class="form-group">
				<label for="title">Note title</label> 
				<input name="title" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here"
					value="${note.title}" />

			</div>


			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea class="form-control" name="content" id="content" rows="12" required
						placeholder="Enter the product description">${note.content}
				</textarea>
				


			</div>

			<div class="container text-center">

				<button type="submit" class="btn btn-success">Save your
					note</button>
			</div>

		</form>


	</div>
</body>
</html>