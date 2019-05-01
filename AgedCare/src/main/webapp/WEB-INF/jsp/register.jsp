<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function validateNumeric(evt){  
	var charCode = (evt.which) ? evt.which : event.keyCode	
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}
</script>
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
.loginHead{
text-align: center;
height: 30px;
width: 175px;
font-family: arial;
font-size: 20px;
font-style: normal;
font-weight: bold;
border: 1px solid;
margin: 0 auto;
padding: 4px 0px 0px 0px;
}
.formbody{
margin: 5px 0px 0px 0px;
text-align: center;
height: 350px;
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
	text-align: center;	padding: 5px 10px;margin: 0 auto;
	display: inline-block;
	
}
.data-text{
	padding: 5px 10px;
}
input {
	height: 20px;
}
.signin {
	padding: 4px 18px 21px 18px;
	border-radius: 4px;
	/* text-align: center; */
}
.reg {
	display: inline-block;
	padding: 6px 10px;
	border: 1px solid;
	border-radius: 5px;
	/* text-decoration: none; */
	margin: 30px 10px;
}
.reg_a, .admin_a {
	text-decoration: none;
}
.admin {
	display: inline-block;
	padding: 5px 10px;
	border: 1px solid;
	margin: 30px 10px;
	border-radius: 5px;
}
.back {
	display: inline-block;
	padding: 5px 10px;
	border: 1px solid;
	border-radius: 5px;
	margin: 10px 0px;
}
.back_a{
	text-decoration: none;
	color: #000;
}
</style>

<meta charset="ISO-8859-1">
<title>AgedCare</title>
</head>
<body>
<div class="head">Aged Care Management System </div>
<div class="loginHead">Patient Register </div>
<br/>
<form action="/agedcare/savepatient" method="post">
<div  class="formbody">
	<div class="data-text"><input type="text" name="patientName" placeholder="PATIENT NAME" > </div>
	<div class="data-text"><input type="password"  name="patientPassword" placeholder="PASSWORD"></div>
	<div class="data-text"><input type="text"  name="patientaddress" placeholder="ADDRESS"></div>
	<div class="data-text"><input type="text"  name="patientemail" placeholder="MAIL ID"></div>
	<div class="data-text"><input type="text"  name="patientage" placeholder="AGE" onkeypress="return validateNumeric(event);"></div>
	<div class="data-text"><input type="text"  name="patientdisease" placeholder="DISEASE" ></div>
	<div class="data-text"><input type="text"  name="patientContactnumber" placeholder="CONTACT NUMBER" onkeypress="return validateNumeric(event);"></div>
	
	<div class="data-button">
			<input type="submit" class="signin"  name="submit" value="SIGNIN"> 
	</div><div class="back"><a href="/agedcare/logout" class="back_a">BACK</a></div>
</div>



</form>


</body>
</html>