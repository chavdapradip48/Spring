<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forgot Page</title>
<!-- Css File links -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
		html,body{
		    margin: 0%;
		    padding: 0%;
		    background-color: rgb(234, 228, 239);
		    
		}
		.form-section{
		    margin: 20px 0 ;
		    height: auto;	
		    width: 100%;
		    border: 2px solid black;
		    background-color: rgb(214, 228, 221);
		}
		.form-heading{
		    background-color: rgb(101, 183, 185);
		    margin: 0 0 10px 0;
		    border-bottom: 1px solid black;
		}
		.form-heading h2{
		    margin: 0 0 0 0;
		    padding: 5px 0;
		    text-align: center;
		}
		.form-group {
		    margin: 10px 50px;
		}
		.form-group1 {
		    margin: 15px 50px;
		}
		.field-error, .field-error1{
		    color: red;
		    font-size: 12px;
		    margin: 2px 0 2px 5px;
		}
		label{
		    font-weight: 500;
		}
		
		/* Button style */
		.form-button{
		    position: relative;
		    left: 40%;
		    margin: 20px 0;
		}
		.form-button #data{
		    background-color: cadetblue;
		    width: 20%;
		}
		.form-button #data:hover{
		    background-color:rgb(187, 214, 201);
		}
		
		span {
			display:inline-block;
		}
		.add-style input {
			width:100%;
			
		}
		.navbar-form {
			margin: 0;
		}
		
		

	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
</head>

<body>

	<!-- Banner section -->
	<aside></aside>

	<!-- Main section for other content -->
	<main>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<form id="data-form" action="ProcessForgot" method="post">
							<!-- Below div for form heading -->
							<div class="form-heading">
								<h2>Forgot Password</h2>
							</div>

							<!-- Below div for email of user -->
							<div class="form-group1">
								<label for="">Email :</label> 
								<input type="email"
									class="form-control" id="email" name="email"
									placeholder="Please enter valid email">
								<p class="field-error" id="email-error">eetert</p>
							</div>
							<div class="form-group">
								<label for="password">Password :</label> <input type="password" name="password"
									class="form-control" id="password"
									placeholder="Please enter Password" disabled>
								<p class="field-error" id="password-error"></p>
							</div>

							<!-- Below div for conform password of user -->
							<div class="form-group">
								<label for="c-password">Confirm Password :</label> <input
									type="password" class="form-control" id="c-password" name="cpassword"
									placeholder="Please enter confirm Password" disabled>
								<p class="field-error" id="cpassword-error"></p>
							</div>
							<div class="form-button">
								<input id="data" type="submit" value="submit">
							</div>
						</form>
						<!-- Below div for button  -->

					</section>	
				</div>
			</div>
		</div>
	</main>

</body>

</html>
	