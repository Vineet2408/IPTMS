<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   
<html>
<head>
<%@ include file="headlink.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<style>

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
#insurertable{
margin:0 auto;

}
td{
font-weight:bold;
}
.table{
background-color:#FFFFFF;
}
th{
background-color:#000000;
color:#FFFFFF;
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
  
        
	<c:set var="count" value="1"/>
	<div class="container-fluid">
		
		
		 <div class="conatiner-fluid justify-content-center">
           
                <h4 class="text-center ">  Insurance Packages  </h4>
            </div>
        </div>
       
        <div id="insurertable" class="conatiner-fluid  col-8">
                     
             <table class="table table-bordered border-dark">
               <thead>
               <tr>
              <th>S.No</th>
        <th>Insurer Name</th>
        <th>Package Name</th>
        <th>Amount Limit</th>
        <th>Disbursement Duration</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="insurancePackage" items="${insurancePackagesList}">
    <tr>
    <td>${count}</td>
    <c:set var="count" value="${count+1}"/>
    <td>${insurancePackage.insurerName}</td>
    <td>${insurancePackage.insurerPackageName}</td>
    <td> ${insurancePackage.insuranceAmountLimit}</td>
    <td> ${insurancePackage.disbursementDuration}</td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
               
                
        </div>
       
		
		
	
</body>
</html>