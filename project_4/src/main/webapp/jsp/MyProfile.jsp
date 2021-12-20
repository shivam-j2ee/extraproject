<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MY Profile</title>
<style type="text/css">
#po4 {
	padding: 10px;
	margin: 10px;
}

#po3 {
	font-size: 25px;
}

.button1 {
	font-size: 20px;
	margin: 10px;
	padding: 10px 40px;
	border-radius: 12px;
}
</style>
</head>
<body>
	<form action="">
	<center>
		<table>
			<tr><td><h1>My Profile</h1></td></tr>
			<tr>
				<td id="po3">Login ID*</td>
				<td></td>
			</tr>

			<tr>
				<td id="po3">First Name*</td>
				<td><input type="text" name="name" id="po4" size="60"></td>
			</tr>
			<tr>
				<td id="po3">Last Name*</td>
				<td><input type="text" name="lname" id="po4" size="60"></td>
			</tr>
			<tr>
				<td id="po3">Gender*</td>
				<td><input type="text" name="gender" id="po4" size="60"></td>
			</tr>
			<tr>
				<td id="po3">Mobile No</td>
				<td><input type="text" name="mobile" id="po4" size="60"></td>
			</tr>
			<tr>
				<td id="po3">Date Of Birth</td>
				<td><input type="text" name="dob" id="po4" size="60"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="button" value="Change Password"
					class="button1" style="background-color: #4775d1;"> &nbsp;
					<input type="button" class="button1" value="Save"
					style="background-color: #4775d1;"></td>
			</tr>
		</table>
</center>
	</form>
</body>
	<%@ include file="Footer.jsp"%>

</html>