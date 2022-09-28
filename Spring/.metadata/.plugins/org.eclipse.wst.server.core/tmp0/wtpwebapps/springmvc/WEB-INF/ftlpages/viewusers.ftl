<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
		html,body{
		    margin: 0%;
		    padding: 0%;
		    background-color: rgb(234, 228, 239);
		    
		}
		.form-section2 {
			margin:5%;
			height: auto;
			min-height: 510px;
		}
		
		#csv-btn {
			margin-top: 3%;
			margin-left: 43%;
		}
		
</style>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
</head>
<body>
	<section class="form-section2">
		<table id="table_id" class="ui celled table" style="width: 100%">
			<thead>
				<tr>
					<th>Emp ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
			</thead>
			<#list users as user>
				<tbody>
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.gender}</td>
					
						<td><a href="EditProfile"  class="btn btn-success">Edit</a></td>
						<td><a id='' class="btn btn-danger del-user">Delete</a></td>
					</tr>
				</tbody>
			</#list>
		</table>
		<div id="csv-btn">
			<a class="btn btn-success" href="CSVPrint">Generate CSV File</a>
		</div>	
	</section>




	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>


</body>
</html>