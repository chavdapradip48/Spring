$(document).ready(function(){

    $("form").submit(function(e){
    	//!imageCheck($("#imageclick")[0],"#image-error")  
		if(!birthDateCheck() | !alphabets($("#name").val(), "#name-error") | 
				!numberCheck($("#mobile").val(),"#mobile-error") | !genderMust() |  !passwordCheck($("#password").val(),"#password-error")
				| !cPasswordCheck("#password","#c-password","#cpassword-error") | !dropCheck($("#hobby").val(),"#drop-error")){
			//	| !emailCheck($("#email").val(),"#email-error") | !allAddressesCheck()){
			alert("Please fill all fields");
			e.preventDefault(e);
		}
    });
	
	$('#email').blur(function() {
		emailCheck($("#email").val(),"#email-error")
	});
	
	$('.list_add_button').on('click', function() {
		addAddress();
	});
	
	$('.addresses').on('click', '.list_remove_button', function() {
		removeAddress(this);
	});
	
	function addAddress(){
		var numOfAddress =$('[name="address.city"]').length;	
		if (numOfAddress < 5) {
			var list_fieldHTML = '<div class="form-group"><label>Address '
					+ ' :</label><textarea class="form-control address" rows="3"  placeholder="Please enter Address" name="address.general"></textarea>'
					+ '<div class="add-style"><span><select class="form-control city"  name="address.city" required><option value="not">Select City</option>'
					+ '<option value="botad">Botad</option><option value="ahmedabad">Ahmedabad</option><option value="baroda">Baroda</option>'
					+ '<option value="rajkot">Rajkot</option></select></span><span><select class="form-control state"  name="address.state" required>'
					+ '<option value="not">Select State</option><option value="gujarat">Gujarat</option><option value="rajasthan">Rajasthan</option>'
					+ '<option value="madhyapradesh">Madhyapradesh</option></select></span><span>'
					+ '<input type="number" class="form-control pincode"  name="address.pincode" placeholder="Please enter pincode" ></span><span><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></span></div><input type="hidden"  name="newOldStatus" value="new"><p class="field-error" id="address-error"></p></div>';
			$('.addresses').append(list_fieldHTML); //Add field html
		}
	}
	function removeAddress(element){
		if ($('[name="address.city"]').length > 1) {
			$(element).parent().parent().parent().remove(); //Remove field html
		}
	}
	/* Below function add preview image after user add some image */	
			$('#imageclick').change(function(){
		        const file = this.files[0];
		        if (file){
		          let reader = new FileReader();
		          reader.onload = function(event){
		        	  $("#iii").html($("<img id='imgPreview'  alt='Profile preview' width='250px' height='200px'/>"));
		            $('#imgPreview').attr('src', event.target.result);
		          }
		          reader.readAsDataURL(file);
		        }
		 });
	
	
			   $(".addresses").on('blur',"textarea",function(){
				   nullCheck($(this).val(),$(this).siblings("p"));
				   // $(this).siblings("p").text("this text area");
			   });
			   $(".addresses").on('blur',".pincode",function(){
				   pincodeCheck($(this).val(),$(this).parent().parent().siblings("p"));
			   });
			   $(".addresses").on('blur',".city",function(){
				   cityStateFun($(this));
			   });
			   $(".addresses").on('blur',".state",function(){
				   cityStateFun($(this));
			   });
				function addressFun(element){
					 return nullCheck(element.val(),element.siblings("p"));
				}
				function cityStateFun(element){
					return dropCheck(element.val(),element.parent().parent().siblings("p"));
				}	
				function pincodeFun(element){
					return pincodeCheck(element.val(),element.parent().parent().siblings("p"));
				}
				function allAddressesCheck(){
					var addressesCheck=0;
					for(var i=0;i<$(".address").length;i++)
					{
						
						if(!addressFun($(".address").eq(i)) || !cityStateFun($(".city").eq(i)) || !cityStateFun($(".state").eq(i)) || !pincodeFun($(".pincode").eq(i))){
							$(".address").eq(i).siblings("p").text("Please fill all fields of address");
							addressesCheck++;
						}
					}
					if(addressesCheck != 0){
						return false;
					}
					else{
						return true;
					}
				}
	
	
	$('#password').blur(function(){
		passwordCheck($("#password").val(),"#password-error");
	});
	$('#c-password').blur(function(){
		cPasswordCheck("#password","#c-password","#cpassword-error");
	});
	/* Below function for check name only contain alphabets only */	
	$('#name').blur(function(){
		alphabets($("#name").val(), "#name-error");
	});
	
	/* Below function for check name only contain digits only */
	$('#mobile').blur(function(){
		numberCheck($("#mobile").val(),"#mobile-error");		
	});
	  $('#hobby').blur(function(){
			dropCheck($(this[this.selectedIndex]).val(),"#drop-error");
		}); 
		$('#hobby').focus(function(){
			genderMust();
		});
		/* Below function check date like (1. date is below 31 (2. month is below 12  (3. year is less then current year  */	
		$('#birthdate').blur(function(){
			birthDateCheck();				
		});

		
		function imageCheck(imgval,errorField){
			if(imgval.files.length === 0){
				$(errorField).text("Please select image");
				return false;	
			}
			else{
				$(errorField).text("");
				return true;
			}
		}
		  function dropCheck(dropval,errorField){
				if(dropval != "not"){
					$(errorField).text("");
					return true;					
				}
				else{
					$(errorField).text("Please select value");
					return false;	

				}
			}
		     
			function birthDateCheck(){
				var dt = new Date( $("#birthdate").val());
				console.log(dt.getFullYear());
				console.log(dt.getMonth());
				console.log(dt.getDate());
				if(dt.getFullYear() > 0){
					if( new Date().getFullYear() < dt.getFullYear() && dt.getMonth() <= 12 && dt.getDate() <= 31){
						$("#birthdate-error").text("Please enter valid date");
						return false;	
					}
					else{
						$("#birthdate-error").text("");
						return true;
					}
					
				}
				else{
					$("#birthdate-error").text("Please select date");
				}
				
			}
			
			function genderMust(){
				if($('input[name="gender"]:checked').length == 0){
					$("#radio-error").text("Please select gender");
					return false;	
				}
				else{
					$("#radio-error").text("");
					return true;
				}
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
			function pincodeCheck(fValue,errorField){
				if(nullCheck(fValue,errorField) && fValue.length != 6){
						$(errorField).text("Please enter 6 digit in pincode.");
						return false;
				}	
				else{
						return true;
				}
			}
			function alphabets(fValue,errorField){
				var regex = /^[A-Za-z ]+$/;		
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
						$(errorField).text("Please enter alphabets only");
						return false;
				}	
				else{
						return true;
				}
			}
			
			function numberCheck(fValue,errorField){
				var regex = /^[1-9]{1}[0-9]{9}$/;
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
					$(errorField).text("Please enter number only");
					return false;
				}	
				else{
						return true;
				}
			}
			
			function emailCheck(fValue,errorField){
				var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;	
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
					$(errorField).text("Please enter valid email.");
					return false;
				}	
				else{
					
						$.ajax({
							url : "EmailCheck",
							type : "post",
							data : {
								cuEmail : fValue
							},
							success : function(data) {
									$("#email-error").text(data);
							}
						});
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
					console.log(fValue2);
					$(errorField).text("Password and confirm password not same");
					return false;
				}	
				else{
						return true;
				}
			
			}
});
