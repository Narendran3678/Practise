<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body>
	<div style="height:100%; width:100%; text-align:center">
		<h1>Login Successfully</h1>	
		<%
		String sessionId = request.getSession().getAttribute("Sessionkey")!=null ? request.getSession().getAttribute("Sessionkey").toString():null;
		if(sessionId!=null) {
		%>
		<h2>SessionId = <%=sessionId%></h2>
		<% 
		}
		Cookie[] cookies = request.getCookies();
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
		<a href="LogoutServlet">Logout</a>	
	</div>
</body>
</html>