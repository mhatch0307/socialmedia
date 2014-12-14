<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Post to Social Media Sites</title>
    <link rel="stylesheet" type = "text/css" href = "css/style.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <script src = "js/fbLogin.js"></script>
    <script>
        function Post_Text() {
        	var text = document.getElementById("poster").value;
            console.log(text);
            FB.api('/me/feed','post', {message: text}, function(response) {
                    if (!response || response.error) {
                        console.log('Error occured');
                    } 
                    else {
                        console.log('Action was successful! Action ID: ' + response.id)
                    }
                 });
        }
    </script>
    
</head>
<body>
    <h1>Lantern </h1><br/>
    <h2>Social Media Poster for Twitter, Facebook, and Tumblr</h2>
    <form class = "statusText" id = "statusText" method = "POST" action = "TextPost">
    	<input type = "hidden" name = "userID" value = '${userID}'/>
        <textarea id = "poster" rows = "10" name = "post" placeholder = "Merry Christmas..."></textarea>
        <input type = "submit" class = "postTextButton" onclick = "Post_Text();" value = "Post"/>
    </form>
    <fb:login-button scope="public_profile,email,publish_actions" onlogin="checkLoginState();"></fb:login-button><br/>
    <button id="fbLogout" onclick="fbLogout()">Log Out</button><br>
    <div id="status">
    </div>
</body>
</html>