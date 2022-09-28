<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register Page</title>

<link
	href='<c:url value="/resources/library/bootstrap/css/bootstrap.min.css"/>'
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" href='<c:url value="/resources/css/custom.css"/>'>
<script type="text/javascript" src='<c:url value="/resources/javascript/jquery-3.6.0.min.js"/>'></script>


<style type="text/css">
#imgPreview {
	height: 150px;
	width: 150px;
	border: 1px solid black;
}
</style>
</head>

<body>

	<!-- Banner section -->
	<aside></aside>


	<main>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<form action="insertuser" id="register-form"
							enctype='multipart/form-data' method="post">
							<!-- Below div for form heading -->
							<div class="form-heading">
								<h2>Register Page</h2>
							</div>
							<input type='hidden' name='userId'>

							<!-- Below div for name of user -->
							<div class="form-group">
								<label for="name">Name :</label> <input type="text"
									class="form-control" id="name" name="name"
									placeholder="Please enter name">
								<p class="field-error" id="name-error"></p>
							</div>


							<!-- Below div for mobile of user -->
							<div class="form-group">
								<label for="mobile">Mobile :</label> <input type="number"
									class="form-control" id="mobile" name="mobile"
									placeholder="Please enter mobile number">
								<p class="field-error" id="mobile-error"></p>
							</div>
							<!-- Below div for email of user -->
							<div class="form-group">
								<label for="">Email :</label> <input type="text"
									class="form-control" id="email" name="email"
									placeholder="Please enter valid email">
								<p class="field-error" id="email-error"></p>

							</div>

							<!-- Below div for url of user -->
							<div class="form-group">
								<label for="date">Birth Date :</label> <input type="date"
									class="form-control" id="birthdate" name="birthdate"
									placeholder="Please enter birthdate">
								<p class="field-error" id="birthdate-error"></p>
							</div>


							<!-- Below div for gender of user -->
							<div class="form-group">
								<label for="">Gender :</label>
								<div class="radio">
									<label> <input type="radio" name="gender" id="male"
										value="male"> Male
									</label> <label> <input type="radio" name="gender" id="female"
										value="female"> Female
									</label> <label> <input type="radio" name="gender" id="other"
										value="other"> other
									</label>
								</div>
								<p class="field-error" id="radio-error"></p>
							</div>
							<!-- Below div for Hobby of user -->
							<div class="form-group">
								<label for="hobby">Hobby :</label> <select class="form-control"
									id="hobby" name="hobby" >
									<option value="not">Select Hobby</option>
									<option value="Cricket">Cricket</option>
									<option value="Travelling">Travelling</option>
									<option value="Reading Books">Reading Books</option>
									<option value="Learning New Things">Learning New
										Things</option>
								</select>
								<p class="field-error" id="drop-error"></p>
							</div>
							<div class="addresses">

								<div class="form-group address-section">
									<label for="address">Address :</label>
									<textarea class="form-control address" rows="3" class="address"
										placeholder="Please enter Address" name="address.general"></textarea>
									<div class="add-style">
										<span> <select class="form-control city" name="address.city">
												<option value="not">Select City</option>
												<option value="botad">Botad</option>
												<option value="ahmedabad">Ahmedabad</option>
												<option value="baroda">Baroda</option>
												<option value="rajkot">Rajkot</option>
										</select>
										</span> <span> <select class="form-control state" name="address.state">
												<option value="not">Select State</option>
												<option value="gujarat">Gujarat</option>
												<option value="rajasthan">Rajasthan</option>
												<option value="madhyapradesh">Madhyapradesh</option>
										</select>
										</span> <span> <input type="number"
											class="form-control pincode" name="address.pincode"
											placeholder="Please enter pincode">
										</span> <span><a href="javascript:void(0);"
											class="list_remove_button btn btn-danger">-</a></span>
									</div>
									<input type="hidden" name="newOldStatus" value="new">
									<p class="field-error1"></p>
								</div>

							</div>
							<div class="form-group">
								<p class="field-error" id="address-max-error"></p>
							</div>
							<div class="form-button">
								<button class="btn btn-primary list_add_button" type="button">+</button>
							</div>
							<!-- Below div for password of user -->
							<div class="form-group">
								<label for="password">Password :</label> <input type="password"
									name="password" class="form-control" id="password"
									placeholder="Please enter Password">
								<p class="field-error" id="password-error"></p>
							</div>

							<!-- Below div for conform password of user -->
							<div class="form-group">
								<label for="c-password">Confirm Password :</label> <input
									type="password" class="form-control" id="c-password"
									name="cpassword" placeholder="Please enter confirm Password">
								<p class="field-error" id="cpassword-error"></p>
							</div>
							<!-- Below div for image input of user -->
							<div class="form-group demo-image">
								
								<input type="file" name="image" >
								<p class="field-error" id="image-error"></p>
								<div id="iii"></div>
							</div>

							<div class="form-button">
								<input id="data" type="submit" value="Submit">
							</div>


							<div class="form-group">
								<label for="">Already have an account ? </label> <a href="index">Login</a>
							</div>
						</form>
					</section>
				</div>
			</div>
		</div>

	</main>

	<jsp:include page="footer.jsp" />
	<!-- Javascript file links -->
	<!-- 1.Already created file -->

	<!-- 2. Custom file <script type="text/javascript" src="assets/javascript/custom.js"></script>-->

	
</body>

</html>