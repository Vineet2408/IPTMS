<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<%@ include file="headlink.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Patient Details Form</title>
<link rel="stylesheet" href="/style/style.css">

</head>
<body  class="d-flex flex-column min-vh-100 text-warning">
	
	<%@ include file="RegistrationHeader.jsp" %>
	
	<div class="container mt-8 mx-auto">

		<div class="card text-white text-center col-6 mx-auto">

			<div class="card-body">
				<h2 id="formheading" class="card-title mb-4">Registration Form</h2>

				<form name="registrationform" method="post" action="/patient/processform">

					<div class="form-row">
						<div class="form-group col-sm-12">

							<label for="name">Patient Name</label> <input type="text"
								class="form-control" name="name" id="name" placeholder="Enter Patient Name"
								required> <br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-sm-12">

							<label for="age">Patient Age</label> <input type="number"
								class="form-control" name="age" id="age" min="1" placeholder="Enter Patient's Age"
								required> </input> <br>
						</div>
					</div>


					<div class="form-row">
						<div class="form-group col-sm-12">

							<input class="btn btn-success btn-block btn-lg" type="submit"
								name="submit" value="Register">

						</div>
						<p>${message}</p>

					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>