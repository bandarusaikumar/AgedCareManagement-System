<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
.head{
text-align: center;
height: 50px;
width: 100%;
font-family: arial;
font-size: 20px;
font-style: normal;
font-weight: bold;
border-bottom: 1px solid;
margin: 0px 0px 2px 0px;
}
.menu{
text-align: center;
height: 50px;
width: 100%;
font-family: arial;
font-size: 20px;
font-style: normal;
border-bottom: 1px solid;
margin: 0px 0px 2px 0px;
}
.home, .nurse_visiting, .contact_admin , .g_i_f_d, .logout {
	display: inline-block;
	padding: 5px 10px;
	border: 1px solid;
	border-radius: 5px;
	margin: 10px 0px;
}
.home_a, .nurse_visiting_a, .contact_admin_a , .g_i_f_d_a, .logout_a{
	text-decoration: none;
	color: #000;
}
.g_i_f_d{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
}
.menu-title {
	text-align: center;
	font-weight: bold;
	font-size: 14px;
	padding: 5px 0px;
}
.textbold{
text-align: right;
}
</style>

<meta charset="ISO-8859-1">
<title>AgedCare</title>
</head>
<body>
<div class="head">Aged Care Management System </div>
<div class="menu">
<div class="home"><a href="/agedcare/patienthome/${patient.patientId}" class="home_a">Home</a></div>
<div  class="nurse_visiting"><a href="/agedcare/nursevisiting/${patient.patientId}" class="nurse_visiting_a">NURSE VISITING</a></div>
<div  class="contact_admin"><a href="/agedcare/admincontact/${patient.patientId}" class="contact_admin_a">CONTACT ADMIN</a></div>
<div  class="g_i_f_d"><a href="/agedcare/getinformationdoctor/${patient.patientId}" class="g_i_f_d_a">GET INFORMATION FROM DOCTOR</a></div>
<div  class="logout"><a href="/agedcare/logout" class="logout_a">LOGOUT</a></div>
</div>

<div class="table">
<div class="menu-title">Health Records</div>
<c:if test="${!empty getDocInfoBeans}">
	<table align="center" border="2" cellpadding="2" width="90%">
		<tr>
			<th align="center">Health id</th>
			<th align="center">Doctor Name</th>
			<th align="center">Nurse Name</th>
			<th align="center">Health Info</th>
			<th align="center">Health Summary</th>
			<th align="center">Claims</th>
			<th align="center">Medicare</th>
			<th align="center">Age</th>
			<th align="center">Emergency Contact</th>	
			
		</tr>
		<c:forEach items="${getDocInfoBeans}" var="getDocInfoBean">
			<tr>
				<td><c:out value="${getDocInfoBean.healthId}"/></td>
				<td><c:out value="${getDocInfoBean.doctorName}"/></td>
				<td><c:out value="${getDocInfoBean.nurseName}"/></td>
				<td><c:out value="${getDocInfoBean.healthInfo}"/></td>
				<td><c:out value="${getDocInfoBean.healthSummary}"/></td>
				<td> <c:out value="${getDocInfoBean.claims}"/></td>
				<td> <c:out value="${getDocInfoBean.medicare}"/></td>				 
				<td><c:out value="${getDocInfoBean.age}"/></td>
				<td><c:out value="${getDocInfoBean.emergencyContact}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
</c:if>


</div>
</body>
</html>