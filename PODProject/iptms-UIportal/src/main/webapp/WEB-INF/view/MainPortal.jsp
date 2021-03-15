<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="headlink.jsp"%>
<title>Main Portal</title>
<link rel="stylesheet" href="/style/style.css">

</head>
<body class="d-flex flex-column min-vh-100 text-warning">

	<div class="contianer-fluid">
	<%@ include file="MainPortalHeader.jsp"%>
	
	<div class="container-fluid  wrapper flex-grow-1">
		<div class="row mr-2 ml-2">
			<div class="col-lg-4 col-md-6 col-sm-12 mt-2">
				<div class="card-deck">
					<div class="card cardmainportal">
						<a href="/patient/registerPatient"><h5 class="card-title text-white text-center mb-2 mt-2">Patient Register
								Form</h5></a> <img
							src="https://images.unsplash.com/photo-1556742208-999815fca738?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80"
							height="240">
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12 mt-2">
				<div class="card-deck">
					<div class="card cardmainportal">
						<a href="/insurance/viewApplications"><h5 class="card-title text-white text-center mb-2 mt-2">Applications of Insurance Claim</h5></a> <img
							src="application-form.jpg"
							height="240">
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12 mt-2">
				<div class="card-deck">
					<div class="card cardmainportal">
						<a href="/insurance/viewAllPackages"><h5 class="card-title text-white text-center mb-2 mt-2">Insurance Packages</h5></a> <img
							src="https://www.tomorrowmakers.com/sites/default/files/2020-07/Health-insurance-min_1.jpg"
							height="240">
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12 mt-2">
				<div class="card-deck">
					<div class="card cardmainportal">
						<a href="/listAllTreatmentPackages"><h5 class="card-title text-white text-center mb-2 mt-2">Treatment Packages</h5></a> <img
							src="https://www.rubyhospital.com/images/cardiology.jpg"
							height="240">
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12 mt-2">
				<div class="card-deck">
					<div class="card cardmainportal">
						<a href="/listAllSpecialist"><h5 class="card-title text-white text-center mb-2 mt-2">Specialists</h5></a> <img
							src="https://image.freepik.com/free-vector/doctor-character-background_1270-84.jpg"
							height="240">
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>