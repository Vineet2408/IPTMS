<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>User Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="profilestyle.css" rel="stylesheet">
</head>
<body>
        <header>
           <nav class="navbar navbar-expand-lg navbar-dark"> <a
		id="navheading" class="navbar-brand"><i class="material-icons">bloodtype</i><span
		id="navtitle">International Patient Treatment Management
			Service</span></a>


	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>	
	 <div class="container">
                        <div class="collapse navbar-collapse" id="truyumbar">
                            <ul class="navbar-nav ml-auto">
                            	 <li class="nav-item"><a href="/main-portal" class="nav-link">Main Portal</a></li>
                                <li class="nav-item"><a href="/insurance/viewApplications" class="nav-link">Insurance Claim</a></li>

                                <li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

        </header>
</body>
</html>