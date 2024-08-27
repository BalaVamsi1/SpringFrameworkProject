<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Dairy Home Page</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>">
</head>
<body>
<div class="header">
<div class="first">
<img src="<c:url value="/resources/images/dairry.jpg"/>" width="85" height="85"/>
</div>
<div class="second">
<p style="color :Green; "> MY DAIRY APP</p>
</div>
</div>
<br/>
<hr>
<hr>

<div class="body">
<div class="body1">
<img src="<c:url value="/resources/images/mydairy.png"/>" />
</div>
<div class="body2">
<h1>Login here</h1>
<form action="./authenticate" method="post">
<label style="color: Green">Username:</label><input type="text" placeholder="Enter your Username here" name="username" ><br><br>
<label style="color: Green">Password:</label><input type="password" placeholder="Enter your password here" name="password"><br><br>
<h3>New User can <a href="./register">Register</a> here</h3>
<br/>
<button type="submit">Login Here</button>

</form>

</div>


</div>
</body>
</html>