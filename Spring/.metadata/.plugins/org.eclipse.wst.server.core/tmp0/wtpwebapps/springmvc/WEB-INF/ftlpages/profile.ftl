<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<!-- Css File links -->

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
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
		.fields *, .a-field * {
			display: inline-block;
		}
		
		.fields, .p-address, .personal h4 {
			margin: 15px;
		}
		
		.p-address .a-field {
			margin-left: 25px;
		}
		
		.personal .fields {
			margin-left: 40px;
		}
		
		label {
			font-size: 16px;
			color: blue;
		}
		#profile-img{
			height:10%;
			width:20%;
			border: 1px solid black;
			border-radius:50%;
			margin-left:37%; 
		}
</style>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<!-- Banner section -->
	<aside></aside>
	<!-- Main section for other content  -->

	
	<main>
	
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<div class="personal">
					
							<h4>Personal Information :</h4>
							<div class="fields">
									<!-- assets/images/Image.png src="data:image/jpg;base64,<c:out value="{user.imageString}" />"-->
									<img id="profile-img" alt="Profile Image" >
									
							</div>
							<div class="fields">
								<label>Name : </label>
								<div class="fields-value">${profileUser.name}</div>
							</div>
							<div class="fields">
								<label>Mobile : </label>
								<div class="fields-value">${profileUser.mobile}</div>
							</div>
							<div class="fields">
								<label>Email : </label>
								<div class="fields-value">${profileUser.email}</div>
							</div>
							<div class="fields">
								<label>Gender : </label>
								<div class="fields-value">${profileUser.gender}</div>
							</div>
							<div class="fields">
								<label>Birthdate : </label>
								<div class="fields-value">${profileUser.birthdate}</div>
							</div>
							<div class="fields">
								<label>Hobby : </label>
								<div class="fields-value">${profileUser.hobby}</div>
							</div>
						</div>
						<#list profileUser.address as addr>
							<div class="p-addresses">
								<div class="p-address">
									<h4>Address :</h4>
									<div class="a-field">
										<label>Address : </label>
										<div class="fields-value">${addr.general}</div>
									</div>
									<div class="a-field">
										<label>City : </label>
										<div class="fields-value">${addr.city}</div>
									</div>
									<div class="a-field">
										<label>State : </label>
										<div class="fields-value">${addr.state}</div>
									</div>
									<div class="a-field">
										<label>Pincode : </label>
										<div class="fields-value">${addr.pincode}</div>
									</div>
								</div>
							</div>					
	
						<#else>
			
						</#list>
						<div class="form-button">
							<a id="data" href="EditProfile" class="btn btn-success">Edit</a>
						</div>					
					</section>
				</div>
			</div>
		</div>
	</main>

</body>

</html>
