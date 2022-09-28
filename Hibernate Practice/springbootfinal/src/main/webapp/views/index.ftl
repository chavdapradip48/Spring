<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello World !</title>
     <link rel="stylesheet" href="/custom.css">
</head>
<body>
    <h2>Form</h2>
    <form action="form" method="post">
    <input type="hidden" name="id" value="${editUser.id!""}">
    	Name : <input type="text" name="name" value="${editUser.name!""}">
    	Mobile : <input type="text" name="mobile" value="${editUser.mobile!""}">
    	<input type="submit" value="submit">
    </form>
    <#if users??>
    <table border="1">
    	<tr>
    		<th>ID</th>
    		<th>NAME</th>
    		<th>MOBILE</th>
    	<tr>
    	<#list users![] as user>
    		<tr>
	    		<td>${user.id!""}</td>
	    		<td>${user.name!""}</td>
	    		<td>${user.mobile!""}</td>
	    		<td><a href="EditUser?id=${user.id!""}">Edit</a></td>
	    		<td><a href="DeleteUser?id=${user.id!""}">delete</a></td>
	    	<tr>
	    </#list>
    </table>
    </#if>
</body>
</html>