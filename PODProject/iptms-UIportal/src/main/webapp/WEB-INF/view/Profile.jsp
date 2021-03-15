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
    <link href="/style/profilestyle.css" rel="stylesheet">
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
  
    <%@ include file = "ProfileHeader.jsp" %>
    <div class="container-fluid justified-content-center">
        
        <!--header-->
       
        <h1 class="text-center mt-4">Patient Details</h1>
        <br>
        <!--main start here-->
        <div class="container justified-content-center" id="patientprofile">
        	<br>
            <div class="card-deck justified-content-center">
                <div class="card border-info mb-3 h-50">
                <c:set var="patient" value="${patientDetail}"/>
                <c:set var="plan" value="${treatmentPlan}"/>
                    <div class="card-header" id="patient">Patient Details</div>
                    <div class="card-body text-info d-flex flex-column">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <p class="card-text p-2">Name: <span class="detail" id="pname"> ${patient.name} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Age: <span class="detail" id="age"> ${patient.age} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Ailment: <span class="detail" id="ailment"> ${patient.ailment} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Treatment Start Date: <span class="detail" id="startdate"> ${treatmentCommencementDate} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Treatment End Date: <span class="detail" id="enddate"> ${treatmentEndDate}</span></p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="card border-info mb-3">

                    <div class="card-header" id="treatmentplan">Treatment Details</div>
                    <div class="card-body text-info d-flex flex-column">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <p class="card-text p-2">Package Name: <span class="detail" id="packagename"> ${plan.packageName} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Test Details: <span class="detail" id="testdetails"> ${plan.testDetail} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Specialist: <span class="detail" id="specialist"> ${plan.specialist} </span></p>
                            </li>

                            <li class="list-group-item">
                                <p class="card-text p-2">Treatment Cost: <span class="detail" id="cost"> ${plan.cost} </span></p>
                            </li>
                            <li class="list-group-item">
                                <p class="card-text p-2">Treatment Status: <span class="detail" id="status"> ${plan.status} </span></p>
                            </li>

                        </ul>

                    </div>
                </div>


            </div>

        </div>
        
    </div>
</body>
</html>