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
.nurse_visiting{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
}
a {
	text-decoration: none;
	color: #000;
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
<table border="0" cellpadding="2" cellspacing="2"  width="60%" align="center"> 
	<tr><td align="right" class="textbold"><font color="blue"><a href="/agedcare/nursevisit/addnursevisit">Add New</a></font> </td></tr>
	</table>
<c:if test="${!empty patientRelations}">
	<table align="center" border="2" cellpadding="2" width="60%">
		<tr>
			<th align="center">Patient ID</th>
			<th align="center">Nurse ID</th>
			<th align="center">Doctor ID</th>
			<th align="center">Nurse Visiting Day</th>
			<th align="center">Nurse Reason</th>
			<th align="center">Delete</th>
		</tr>
		<c:forEach items="${patientRelations}" var="patientRelation">
			<tr>
				<td ><c:out value="${patientRelation.patientId}"/></td>
				<td><c:out value="${patientRelation.nurseId}"/></td>
				<td><c:out value="${patientRelation.doctorId}"/></td>
				<td><c:out value="${patientRelation.nurseVisitingDate}"/></td>
				<td> <c:out value="${patientRelation.reason}"/></td>
				<td align="center"><a href="/agedcare/deletenursevisit/${patientRelation.pat_relationId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
</c:if>


</div>
</body>
</html>