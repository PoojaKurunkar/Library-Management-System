<html>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="style.css">
<head>  <meta name="viewport" content="width=device-width,initial-scale=1">
<style>
table {
	margin-left: auto;
	margin-right: auto;
	background: #fff;
}
</style>
</head>
<body style="background-color: #d1eaa0"><%@include
		file="navbar.jsp"%>
	<center>
		<h1>
			<b>Login Page</b>
		</h1>
		<%
		String invalidMsg = (String) session.getAttribute("invalidMsg");
		if (invalidMsg != null) {
		%>
		<p><%=invalidMsg%></p>
		<%
		session.removeAttribute("invalidMsg");
		}
		%>


		<%
		String logoutMsg = (String) session.getAttribute("logoutMsg");
		if (logoutMsg != null) {
		%>
		<p><%=logoutMsg%></p>
		<%
		session.removeAttribute("logoutMsg");
		}
		%>
		<form action="login" method="post">
			<table border="1">

				<tr>
					<td>Enter Email Address: <input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Enter Password: <input type="text" name="password"></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="login">
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
