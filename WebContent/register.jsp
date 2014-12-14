<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="Register">
     Username: <input type="text" name="username" /><br />
     Password: <input type="password" name="password" /><br />
	 Twitter credentials: <br/>
     Consumer Key: <input type="text" name="twitterConsumerKey" /><br />
     Consumer Secret: <input type="password" name="twitterConsumerSecret" /><br />
     Access Token: <input type="text" name="twitterToken" /><br />
     Access Token Secret: <input type="password" name="twitterTokenSecret" /><br />
     Tumblr credentials: <br/>
     Consumer Key: <input type="text" name="tumblrConsumerKey" /><br />
     Consumer Secret: <input type="password" name="tumblrConsumerSecret" /><br />
     Access Token: <input type="text" name="tumblrToken" /><br />
     Access Token Secret: <input type="password" name="tumblrConsumerSecret" /><br />
     <input type="submit" value="Submit" />
    Facebook credentials: <br/>
    <fb:login-button scope="public_profile,email,publish_actions" onlogin="checkLoginState();">
    </fb:login-button>
    <button id="fbLogout" onclick="fbLogout()">Log Out</button><br>

</form>
</body>
</html>