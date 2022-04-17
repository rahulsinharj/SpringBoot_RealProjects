<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Notes</title>
<%@include file="base.jsp"%>
</head>
<body class="mybg">

	<h1 class="myhead m-2">ALL YOUR NOTES :</h1>
	<div class="container">
		<%@include file="navbar.jsp"%>


		<div class="row">

			<div class="col-12">

				<c:forEach items="${allNotes}" var="note">

					<div class="card mt-3">
						<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
							src="img/notepad.png" alt="Card image cap">
						<div class="card-body px-5">
							<h5 class="card-title">${note.title}</h5>
							<p class="card-text">${note.content}</p>
							<p>
								<b class="text-primary">${note.addedDate}</b>
							</p>

							<div class="d-flex offset-sm-5">

								<form method="post" action="/edit-note?note_id=${note.id}" >
									<button type="submit" class="btn btn-info ml-4"
										title="Update this Contact !">Edit</button>
								</form>
								
								<form method="post" action="/delete-note?note_id=${note.id}">
									<button type="submit" class="btn btn-warning ml-1"
										title="Delete this Contact !">Delete</button>
								</form>

							</div>

 	<!-- // Below code is only for @GETMAPPING in NoteController for edit/delete 
							<div class="container text-center mt-2">
								<a href="/edit-note?note_id=${note.id}" class="btn btn-primary">Edit</a>
								<a href="/delete-note?note_id=${note.id}" class="btn btn-warning">Delete</a>
							</div>			
	-->
	<!-- We can also use here 	<a href="/edit-note/${note.id}">Delete</a> 
						
		and in NoteController we can write 	@PostMapping("/edit-note/{note_id}")  and fetching it through  @PathVariable("note_id") int nodeId 	: 
	
										// Here @PostMapping is because since we have mentioned here form method as "post" with a submit button for edit/delete  	
	-->
						

							
							
						</div>
					</div>
				</c:forEach>



			</div>

		</div>


	</div>
</body>
</html>