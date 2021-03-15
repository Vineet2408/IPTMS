<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    isELIgnored="false"
    %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="headlink.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<style>
.detail{
            float:right;
        }
       
nav {
	background-color: black;
}

#navheading {
	color: #ffffff;
}

#navname {
	color: #fff3d4;
}

#navlink {
	color: #DFA362;
	text-decoration: underline;
}

body{
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100% 100%;
    background-image: url('http://www.keshlata.com/wp-content/uploads/2018/03/hospital-background-images-hd-9.jpg');
}
.navbar{
	padding: 0 1rem !important;
}

.material-icons{
    font-size:1.5rem;
    vertical-align: middle;
    padding-right: 5px;
    padding-bottom: 10px;
}
.card-deck,.card-border{
margin: auto;
width: 60%;

padding: 10px;
}

</style>

</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark"> <a
		id="navheading" class="navbar-brand"><i class="material-icons">bloodtype</i><span
		id="navtitle">International Patient Treatment Management
			Service</span></a>


	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>	

                        <div class="collapse navbar-collapse" id="truyumbar">
                            <ul class="navbar-nav ml-auto">
                             	<li class="nav-item"><a href="/main-portal" class="nav-link">Main Portal</a></li>
                                <li class="nav-item"><a href="/insurance/viewApplications" class="nav-link">Patients</a></li>                              
                                <li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
                            </ul>
                        </div>
                    
	
	</nav>
	<div class="container-fluid" id="balancedetails">
        	<br>
            <div class="card-deck w-50" id="balancecard">
                <div class="card border-dark mb-3" style="max-width: 30rem;">
               <c:set var="initiateClaim" value="${initiateClaim}"/>
                
                    <div class="card-header" id="balance">Balance Amount Payment Details</div>
                    <div class="card-body text-dark d-flex flex-column">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <p class="card-text p-2">Patient Name: <span class="detail" id="pname">${initiateClaim.patientName}</span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Ailment: <span class="detail" id="ailment"> ${initiateClaim.ailment} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Insurer Name: <span class="detail" id="iname"> ${initiateClaim.insurerName} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Treatment Cost: <span class="detail" id="cost"> ${initiateClaim.treatmentCost} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Balance Amount to Pay: <span class="detail" id="balance"> ${initiateClaim.balance}</span></p>
                            </li>
                        </ul>
                    </div>
                </div>
                </div>
                </div>
</body>
</html>