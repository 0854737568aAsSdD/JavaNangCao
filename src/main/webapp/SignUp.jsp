<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Store</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%
String username = "UserName";
if(request.getAttribute("username")!=null)
{
	username =(String) request.getAttribute("username");
}
%>
	<div class="header">
		<div class="container">
			<div class="navbar">
				<div class="logo">
					<a href="home"><img
						src="http://www.minhkhai.com.vn/store2/images/minhkhai-logo.png"
						width="400px"></a>
				</div>
				<nav>
					<ul id="MenuItems">
						<li><a href="home">Home</a></li>
						<li><a href="ViewServlet?page=1">Products</a></li>
						<li><a href="About.jsp">About</a></li>
						<li><a href="home">Contact</a></li>
						<li><a href="home">Account</a></li>
					</ul>

					<a href="Cart.jsp"><img src="images/cart.png" width="30px"
						height="30px"></a> <img src="images/menu.png" class="menu-icon"
						onclick="menutoggle()">
					<p></p>
			</div>
			<div class="row">
				<div class="col-2">
					<h1>
						Book is mylife<br>And i love it
					</h1>
					<p>Tell me the book you read and I will tell you what kind of
						person you are</p>
					<a href="http://it.husc.edu.vn/gv/nhha/" class="btn">Explore
						Now &#8594;</a>
				</div>
				<div>
					<img
						src="http://static.ybox.vn/2017/3/21/5cade000-0ddd-11e7-a84a-2e995a9a3302.jpg"
						width="800px">
				</div>
			</div>
		</div>
	</div>
	<h2>Sign Up Form</h2>
	<%
	if (request.getAttribute("kiemtra") == null && request.getAttribute("trave")==null) {
	%>
	<form action="kiemtra" method="get">
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">UserName:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="email"
					placeholder="Name" name="name">
				<button type="submit" class="btn btn-primary" style="width: 100px">Check</button>
			</div>
		</div>
	</form>
	<%
	}
%>
	<% 
		if(request.getAttribute("trave")!=null && request.getAttribute("kiemtra")==null )
		{
	%>

	<div class="container">
		<form lass="form-horizontal" action="kiemtra" method="get">
			<table>
				<tr>
					<td>
						<div class="form-group">
							<label class="control-label col-sm-2" for="email">UserName:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email"
									placeholder="Name" name="name">
								<button type="submit" class="btn btn-primary"
									style="width: 100px">Check</button>
							</div>
					</td>
					<td><img alt="" src="daux.png" width="100px"></td>
					</div>
				</tr>
			</table>
		</form>
	</div>
	<%} %>


	<div class="container">
		<form class="form-horizontal" action="signup" method="get">
			<%if (request.getAttribute("kiemtra") != null && request.getAttribute("trave")!=null){%>
			<table>
				<tr>
					<td>
						<div class="form-group">

							<label class="control-label col-sm-2" for="email">UserName:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email"
									placeholder="Name" name="name" value="<%=username%>">
							</div>
					</td>
					<td><img alt="" src="dautich.jpg" width="20px"></td>
	</div>
	</tr>
	</table>

	<%} %>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">FullName:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email"
				placeholder="FullName" name="fullname">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Address:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email"
				placeholder="Address" name="address">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">Email:</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email"
				placeholder="Enter email" name="email">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="email">NumberPhone:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email"
				placeholder="Number Phone" name="numberphone">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">Password:</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="pwd">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">Repeat
			Password:</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="repeatpwd">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="remember">
					Remember me</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" style="color: blue;">Đăng
				Ký</button>
		</div>
	</div>
	</form>
	</div>

</body>
</html>