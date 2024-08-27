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
<h1>Update Entry</h1>
<form action="./processentryupdate" method="post">
<label style="color: Green;text-align: center;">Date :</label><input type="text"  name="entrydate" value="${entry.entrydate}" pattern="yyyy-MM-dd" readonly="readonly"><br><br>
<label style="color: Green;text-align: center;">Description:</label>
<textarea rows="10" cols="22" name="description">
${entry.description}
</textarea>
<input type="hidden" name="userid" value="${user.id}">
<input type="hidden" name="id" value="${entry.id}">
<br/>
<button type="submit">Update entry</button>

</form>

</div>


</div>
</body>
</html>