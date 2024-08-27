<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<h2>welcome <span style="color: steelblue">${user.username} </span></h2>
<a href="./signout" style="color: blue;float:right">Signout</a>


<div class="body">
<div class="body1">
<img src="<c:url value="/resources/images/mydairy.png"/>" />
</div>
<div class="body2">
<h1>VIEW ENTRY</h1>
<table>
<tr><td>Date :</td><td>${entry.entrydate}</td></tr>
<tr><td>Description:</td><td>${entry.description}</td></tr>
</table>
<br/>
 <a href="./userhome"><button type="button">Back to home</button></a>



</div>


</div>
</body>
</html>