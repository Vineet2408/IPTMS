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
	text-decoration: underline;
}

body{
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100% 100%;
    background-image: url('http://www.keshlata.com/wp-content/uploads/2018/03/hospital-background-images-hd-9.jpg');
}


#patientdetailtable{
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
.navbar{
	padding: 0 1rem !important;
}
.material-icons{
    font-size:1.5rem;
    vertical-align: middle;
    padding-right: 5px;
    padding-bottom: 10px;
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
  
        

	
<div class="container-fluid">
	
	
	<c:set var="count" value="1"/>
		<!-- header............................................................................................. -->
	
			<!-- main start here -->
	
        <div class="container-fluid justified-content-center">
            
                <h1 class="text-center">Applications for Insurance Claim</h1>
            
        </div>

        <div id="patientdetailtable" class="conatiner-fluid ">
                     
             <table class="table table-bordered border-dark">
               <thead>
               <tr>
              <th>S.No</th>
        <th>Patient Name</th>
        <th>Ailment</th>
        <th>Treatment Package</th>
        <th>Treatment Cost</th>
         <th>Treatment Start Date</th>
          <th>Select</th>
        </tr>
    </thead>
    <tbody>
   <c:forEach var="treatmentPlan" items="${treatmentPlanList}">
    <tr>
    <td>${count}</td>
    <c:set var="count" value="${count+1}"/>
    <td> ${treatmentPlan.patientDetail.name}</td>
    <td> ${treatmentPlan.patientDetail.ailment}</td>
    <td> ${treatmentPlan.packageName}</td>
    <td> ${treatmentPlan.cost}</td>
    <td> ${treatmentPlan.treatmentCommencementDate}</td>
    <td class="justified-content-center"> <a href="/insurance/selectInsurance/?tpid=${treatmentPlan.treatmentPlanId}">Select Insurance Package</a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
               
                
        </div>
       
		
		
</body>
</html>