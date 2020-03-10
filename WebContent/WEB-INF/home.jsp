<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<style type="text/css">
body {
	margin: 10px;
	padding: 10px;
}

#hidden {
	visibility: hidden;
	align-self: left;
	width: 200px;
	height: 100px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

	<div class="alert alert-primary" role="alert">
		<%=request.getAttribute("user")%>
	</div>
	<button type="button" class="btn btn-danger"
		onclick="location.href = '/WebApp03/login.jsp';">Log out</button>
	<br>
	<br>
	<form action="/WebApp03/home" method="post">
	<%request.setAttribute("user", "Logged in as: "+request.getParameter("username"));
	request.setAttribute("username", request.getAttribute("username"));%>
		<button type="submit" class="btn btn-primary" name="listall"
			value="true">List all cities</button>
	</form>
	<br>
	<table class="table">
		<%=(request.getAttribute("table")==null)?"":request.getAttribute("table")%>
	</table>
	<br>
	<button type="button" class="btn btn-primary"
		onclick="$('#hidden').css({
	        'visibility': 'visible'
	  	    });">Add
		city</button>
	<br>
	<br>
	<div id="hidden">
	<form action="/WebApp03/home" method="post">
		<div class="form-group">
			<label for="exampleFormControlInput1">Ime</label> <input name="naziv"
				class="form-control" id="exampleFormControlInput1"
				placeholder="Ime grada">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">PTT broj</label> <input
				name="pttbroj" class="form-control" id="exampleFormControlInput1"
				placeholder="PTT broj">
		</div>
		<br>
		<button type="submit" class="btn btn-primary" name="dodajgrad">Add</button>
		</form>
	</div>
</body>
</html>