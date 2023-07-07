<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Apache Commons File Upload Example </title> 
</head>
<body>
	<div align="center">
		<h1>Welcome to Apache Commons File Upload</h1>
	</div>
	<form method="POST" action="FileUploadServlet" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<input type="file" name="file" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Upload" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>