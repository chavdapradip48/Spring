<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="com.mvc.model.UserModel" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link href='<c:url value="/resources/library/bootstrap/css/bootstrap.min.css"/>' type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href='<c:url value="/resources/css/custom.css"/>'>
	<script type="text/javascript" src='<c:url value="/resources/javascript/jquery-3.6.0.min.js"/>' ></script>


</head>
<body>
	<!-- header section -->
	<header>
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">Pradip Company  </a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
		        <li><a href="Profile">Profile</a></li>
		         
		        <%-- <%
		        	UserModel userObjec=(UserModel) (session.getAttribute("user"));
		    		if(userObjec.getRoletype() == 1){
				%> --%>
		         <li class=""><a href="AdminHome">View All User</a></li>
		         <li class=""><a href="Register.jsp">Add New User</a></li>
<%-- 		      	<%
		      	}
		      	%> --%>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="Logout">Logout</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</header>
</body>
</html>