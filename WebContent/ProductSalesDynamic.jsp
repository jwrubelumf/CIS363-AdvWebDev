<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table, th, td {
   border: 2px solid black;
}
.textright{float:right;padding:20px}
body{background-color:lightgray}
</style>
<title>Product Sales</title>
</head>
<body>
<div class="textright">Welcome ${sessionScope.UserName}<span style="padding-left:10px;padding-right:10px;"><form action="./Logout" method="post">
    <input type="submit" name="Logout" value="Logout" />
</form></span></div>
<table bgcolor="#f2f2f2">
<h1>Product Sales</h1>
<tr><th>MfgName</th><th>Image</th><th>Storage</th><th>Cost</th></tr>
<c:forEach items="${Products}" var="prd"> 
    <tr> 
    <td style="padding: 25px;">${prd.mfgName}</td>
    <td><image src=${prd.imagePath} width="100px" height="100px"></image></td>
    <td style="padding: 25px;">${prd.storage}</td>
    <td style="padding: 25px;">$${prd.cost}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>