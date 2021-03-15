<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login</title>
<%@ include file="headlink.jsp"%>
<link rel="stylesheet" href="/style/style.css">
</head>
<body class="d-flex flex-column min-vh-100 text-warning">
	<nav class="navbar navbar-expand-lg navbar-dark">
		<a href="#" class="navbar-brand"><i
			class="material-icons">bloodtype</i><span id="navtitle">International
				Patient Treatment Management Service</span></a>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul id="navlink" class="navbar-nav float-right text-right ml-auto">
			</ul>

		</div>
	</nav>

	<div class="container mt-8">

		<div class="card text-white text-center col-6 mx-auto card-login">

			<div class="card-body">
				<h2 id="formheading" class="card-title mb-4">Login</h2>

				<form name="loginform" method="post" action="/loginuser">

					<div class="form-row">
						<div class="form-group col-sm-12">

							<label for="name">Username</label> <input type="text"
								class="form-control" name="name" id="name" placeholder="User Name"
								required> <br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-sm-12">

							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password" placeholder="Password"
								required> </input> <br>
						</div>
					</div>


					<div class="form-row">
						<div class="form-group col-sm-12">

							<input class="btn btn-success btn-block btn-lg" type="submit"
								name="submit" value="Login">

						</div>
						<p>${message}</p>

					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>