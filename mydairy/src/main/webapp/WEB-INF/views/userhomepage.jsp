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

<div class="userhome">
welcome <span style="color: Blue;font-weight: bold">${user.username}</span>
<a href="./signout" style="color: blue;float:right">Signout</a>
<br/>
<span class="heading" style="color: blue">List of past entries</span>
<a href="./addentry"><button type="submit"class="entrybutton">add entry</button></a>
<br/><br>
<table border="1">
<tr>
<th>Date</th>
<th colspan="3">Actions</th>
</tr>
<c:if test="${entrieslist.size()==0}"></c:if>
<tr><td style="font-size: 18px;color:black" colspan="4">User not added any entries here</td></tr>

<c:forEach items="${entrieslist}" var="e">
<tr>
<td>
<fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/>
</td>

<td><a href="./viewentry?id=${e.id}">View</a></td>
<td><a href="./updateentry?id=${e.id}">Update</a></td>
<td><a href="./deleteentry?id=${e.id}">Delete</a></td>
</tr>

</c:forEach>



</table>

</div>
</body>
</html>