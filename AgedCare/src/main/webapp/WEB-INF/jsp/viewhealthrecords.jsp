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
<div class="home"><a href="/agedcare/adminhome" class="home_a">Home</a></div>
<div  class="nurse_visiting"><a href="/agedcare/nursevisiting" class="nurse_visiting_a">NURSE VISITING</a></div>
<div  class="contact_admin"><a href="/agedcare/admincontact" class="contact_admin_a">CONTACT ADMIN</a></div>
<!-- <div  class="g_i_f_d"><a href="/agedcare/getinformationdoctor" class="g_i_f_d_a">GET INFORMATION FROM DOCTOR</a></div> -->
<div  class="logout"><a href="/agedcare/logout" class="logout_a">LOGOUT</a></div>
</div>

<div class="table">
<div class="menu-title">Health Records</div>
<table border="0" cellpadding="2" cellspacing="2"  width="90%" align="center"> 
	<tr><td align="right" class="textbold"><font color="blue"><a href="/agedcare/healthrecord/addhealthrecord">Add New</a></font> </td></tr>
	</table>
<c:if test="${!empty healthRecords}">
	<table align="center" border="2" cellpadding="2" width="90%">
		<tr>
			<th align="center">Health id</th>
			<th align="center">Health Info</th>
			<th align="center">Health Summary</th>
			<th align="center">Claims</th>
			<th align="center">Medicare</th>
			<th align="center">Age</th>
			<th align="center">Emergency Contact</th>
			<th align="center">Delete</th>
			
			
		</tr>
		<c:forEach items="${healthRecords}" var="healthRecord">
			<tr>
				<td><c:out value="${healthRecord.healthId}"/></td>
				<td><c:out value="${healthRecord.healthInfo}"/></td>
				<td><c:out value="${healthRecord.healthSummary}"/></td>
				<td> <c:out value="${healthRecord.claims}"/></td>
				<td> <c:out value="${healthRecord.medicare}"/></td>				 
				<td><c:out value="${healthRecord.age}"/></td>
				<td><c:out value="${healthRecord.emergencyContact}"/></td>
				<td><a href="/agedcare/deletehealthrecord/${healthRecord.healthId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
</c:if>


</div>
</body>
</html>