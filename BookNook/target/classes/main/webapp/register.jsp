
<html>
<head>  <meta name="viewport" content="width=device-width,initial-scale=1"><style>
table {
  margin-left: auto;
  margin-right: auto;
  background: #fff;
}
</style></head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<body style="background-color: #BFDAB9">
	<%@include file="navbar.jsp"%>
	<center>
		<h4 style="font-size:60px;">Registration Page</h4>
		<%
		String success_msg = (String) session.getAttribute("success_msg");
		String error_msg = (String) session.getAttribute("error_msg");
		if (success_msg != null) {
		%>
		<p><%=success_msg%></p>
		<%
		session.removeAttribute("success_msg");
		}
		if (error_msg != null) {
		%>
		<p><%=error_msg%></p>
		<%
		session.removeAttribute("error_msg");
		}
		%>
		<form action="register" method="post">
				<table border="1">


					<tr>
						<td>Enter Name<input name="name" type="text"></td>
					</tr>
					<tr>
						<td>Email address<input name="email" type="email"></td>
					</tr>
					<tr>
						<td>Password<input name="password" type="password"></td>
					<tr>
						<td align="center"><input type="submit" value="Register">
						</td>
					</tr>
					</form>
					</center>
</body>
</html>
