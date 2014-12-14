<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log into Lantern</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css"/>
</head>
<body>
<div>
	<h3>Welcome, to Lantern</h3>
</div>
<div id = "login">
<form id = "loginForm" method="POST" action="Login">
     <div class = 'label'><label for = "username">Username: </label></div>
     <input type="text" name="username" /><br />
     <div class = 'label'><label for = 'password'>Password: </label></div>
     <input type="password" name="password" /><br />
     <input class = "loginButton" type="submit" value = "Login" />
     <div class = "invalidLogin">${invalidLogin}</div>
</form>
</div>
</body>
</html>
</body>
</html>