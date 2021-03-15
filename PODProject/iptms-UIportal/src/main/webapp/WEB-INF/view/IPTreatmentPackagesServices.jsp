<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<%@ include file="headlink.jsp"%>
<link rel="stylesheet" href="/style/style.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark">
		<a href="/main-portal" id="navheading" class="navbar-brand text-white"><i
			class="material-icons navicon">bloodtype</i><span id="navtitle">International
				Patient Treatment Management Service</span></a>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="truyumbar">
			<ul class="navbar-nav ml-auto">

				<li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
			</ul>
		</div>


	</nav>


	<div class="container-fluid">
		<form action="/searchPackage">
			<div class="container">
				<div class="row">
					<div class="col-md-5">

						<label for="packageName"><b>Package Name</b></label> <input
							type="text" class="form-control" id="packageName"
							name="packageName" placeholder="Enter Package Name">

					</div>
					<div class="col-md-5">
						<label for="ailmet"><b>Ailment</b></label> <input type="text"
							class="form-control" id="ailment" name="ailment"
							placeholder="Enter Ailment">
					</div>

					<div class="col-md-2 " style="margin-top:8px;">
						<button type="submit" class="mt-4 btn btn-success float-right">Search
						</button>
					</div>
				</div>
			</div>

		</form>
		<div class="text-center"><p><b>${message}</b></p></div>
	</div>

	<div class="container-fluid  wrapper flex-grow-1">
		<div class="row mr-2 ml-2">
			<c:forEach var="iptreatmentPackage" items="${iptreatmentPackageList}">
				<div class="col-lg-4 col-md-6 col-sm-12 mt-2 mb-2">
					<div class="card-deck">
						<div class="card">
							<h5 class="card-title text-white text-center mb-2 mt-2">${iptreatmentPackage.ailmentCategory}</h5>
							<img class="card-img-top"
								src="https://images.unsplash.com/photo-1556742208-999815fca738?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80"
								height="240">
							<div class="card-body text-white">
								<div class="mb-1 ">
									<h5 class="d-inline-block ">${iptreatmentPackage.packageDetail.treatmentPackageName}</h5>
									<span class="float-right cost">Rs ${iptreatmentPackage.packageDetail.cost}</span>
								</div>
								<div class="mb-2">
									Test Details <span class="float-right">${iptreatmentPackage.packageDetail.testDetails}</span>
								</div>
								<div class="mb-1">
									<i class="material-icons">schedule</i> <span
										class="badge bg-info text-light">Duration</span> <span
										class="float-right">${iptreatmentPackage.packageDetail.treatmentDuration} Weeks</span>
								</div>
								<div class="mb-1">
									<a href="/patient/getTreatment/?id=${iptreatmentPackage.id}"
										class="btn btn-success treatment-btn text-white float-right">Get Treatment</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>




</body>
</html>