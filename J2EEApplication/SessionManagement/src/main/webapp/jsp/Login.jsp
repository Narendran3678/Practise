<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div style="height:100%; width:100%; text-align:center">
		<h1>Login Page</h1>
		<form action="LoginServlet" method="POST">
			<table>
				<tr> 
					<td>
						<label for="usernamelbl">UserName</label>
					</td>
					<td>
						<input type="text" name="username" />
					</td>				
				</tr>
				<tr> 
					<td>
						<label for="passwordlbl">Password</label>
					</td>
					<td>
						<input type="text" name="password" />
					</td>
				</tr>
				<tr> 
					<td>
						<input type="submit" name="Save" />
					</td>
				</tr>
			</table>
		</form>
		<%
		String sessionId = request.getSession().getAttribute("Sessionkey")!=null ? request.getSession().getAttribute("Sessionkey").toString():null;
		if(sessionId!=null) {
		%>
		<h2>SessionId = <%=sessionId%></h2>
		<% 
		}
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("CookieKey"))
				{
				%>
					<h2>CookieKey = <%=cookie.getValue()%></h2>
				<%
				}
				if(cookie.getName().equals("JSESSIONID"))
				{
					%>
						<h2>JSESSIONID = <%=cookie.getValue()%></h2>
					<%
				}
			}
		%>
	</div>
</body>
</html>