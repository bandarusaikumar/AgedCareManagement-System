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
.contact_admin{
background-color: #AFF4FF;
}
.table{
margin: 30px 0px 2px 0px;
}
.formbody{
margin: 5px 0px 0px 0px;
text-align: center;
height: 250px;
width: 30%;
font-family: arial;
font-size: 14px;
font-style: normal;
font-weight: bold;
border: 1px solid;
margin: 0 auto;
padding: 15px 0px 0px 0px;
}

.data-button{
	text-align: center;	padding: 5px 10px;	width: 40%;	margin: 0 auto;
}
.data-text{
	padding: 5px 10px;
}
input {
	height: 20px;
}
.signin {
	padding: 4px 18px 21px 18px;
	/* text-align: center; */
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
<form action="/agedcare/contactadmin/${adminContact.adminContactId}" method="post">
<div  class="formbody">
	<div class="data-text"><input type="text"  name=adminContactId  value="${adminContact.adminContactId}" readonly="readonly"></div>
	<div class="data-text"><input type="text"  name="patientId"  value="${adminContact.patientId}" readonly="readonly"></div>
	<div class="data-text"><input type="text"  name="patientMailId"  value="${adminContact.patientMailId}" readonly="readonly"></div>
	<div class="data-text"><input type="text"  name="query"  value="${adminContact.query}" readonly="readonly"></div>
	<div class="data-text"><input type="text"  name="answer" placeholder="ANSWER" value="${adminContact.answer}"></div>
	<div class="data-button">
			<input type="submit" class="signin"  name="submit" value="SUBMIT"> 
	</div>
</div>
</form>


</body>
</html>