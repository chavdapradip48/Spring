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

	<link href='<c:url value="/resources/library/bootstrap/css/bootstrap.min.css"/>' type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href='<c:url value="/resources/css/custom.css"/>'>
	<script type="text/javascript" src='<c:url value="/resources/javascript/jquery-3.6.0.min.js"/>' ></script>
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
						<form id="data-form" action="Forgot" method="post">
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


	<!-- Javascript file links -->

	<!-- 2. Custom file -->
	<script type="text/javascript" >
		$("#data-form").submit(function(e){
		    	//!imageCheck($("#imageclick")[0],"#image-error") |
	    	console.log(($("#email-error").text()).length);
			if(!passwordCheck($("#password").val(),"#password-error")
					| !cPasswordCheck("#password","#c-password","#cpassword-error")){
						//| !emailCheck($("#email").val(),"#email-error")){
				alert("Please fill all fields");
				e.preventDefault(e);
			}
	    });
	
		$('#email').blur(function(){
			console.log(emailCheck($("#email").val(),"#email-error"));
		});
		$('#password').blur(function(){
			passwordCheck($("#password").val(),"#password-error");
		});
		$('#c-password').blur(function(){
			cPasswordCheck("#password","#c-password","#cpassword-error");
		});
		
		function emailCheck(fValue,errorField){
			var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;	
			if(!nullCheck(fValue,errorField)){		
				return false;
			}
			else if(!regex.test(fValue)){
				$(errorField).text("Please enter valid email.");
				return false;
			}
			else{
					
					$.ajax({
						url : "DelUser",
						type : "post",
						data : {
							cuEmail : fValue,
							isCheck : "email",
						},
						success : function(data) {
							if (data.length != 0) {
								$("input").removeAttr('disabled');	
								$("#email-error").text("");
							}
							else{
								$("#email-error").text("!! Email not exist");
								$("#password-error").text("");
								$("#cpassword-error").text("");
								$('#password').prop('disabled', true);
								$('#c-password').prop('disabled', true);
							}
						}
					});
					return true;
			}
			return true;
		}

		function nullCheck(fValue,errorField){
			if(fValue.length == 0){
					$(errorField).text("Please enter field value.");
					return false;
			}	
			else{
					$(errorField).text("");
					return true;
					
			}
		}
		function passwordCheck(fValue,errorField){
			var regex = /^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/;	
			if(nullCheck(fValue,errorField) && !regex.test(fValue)){
				$(errorField).text("Please enter valid password.");
				return false;
			}	
			else{
					return true;
			}
		}
		function cPasswordCheck(fValue,fValue2,errorField){
			if(nullCheck($(fValue2).val(),errorField) && $(fValue).val() != $(fValue2).val()){
				$(errorField).text("Password and confirm password not same");
				return false;
			}	
			else{
					return true;
			}
		
		}
	</script>
	

</body>

</html>
	