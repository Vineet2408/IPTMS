<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="headlink.jsp"%>

</head>
<body class="d-flex flex-column min-vh-100 text-warning">
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark">
				<a href="/main-portal" class="navbar-brand"><i
					class="material-icons">bloodtype</i><span id="navtitle">International
						Patient Treatment Management Service</span></a>
		
		
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
		
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul id="navlink" class="navbar-nav float-right text-right ml-auto">
						<li class="nav-item"><a href="/insurance/viewApplications"
							class="nav-link">Patients</a></li>
						<li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
					</ul>
		
				</div>
		</nav>

	</header>

</body>
</html>