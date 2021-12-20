<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
#po1{
padding:10px;
margin: 20px;
}
.button1{
font-size:20px;
margin:10px;
padding:10px 40px;
border-radius:12px;
}
</style>
</head>
<body>
	<center>
		<form action="">
			<table>
				<tr>
					<td><h1>Login</h1></td>
				</tr>
				<tr>
					<td style="font-size: 25px;">User ID *</td>
					<td ><input type="text" name="userId"  size="50" id="po1" ></td>
				</tr>
				<tr>
					<td style="font-size: 25px;">Password *</td>
					<td ><input type="text" name="userId" size="50" id="po1"></td>
				</tr>
                 <tr>
                 <td></td>
                 <td align="right" ><input type="button"  value="Sign In"  class="button1" style="background-color: #99b3e6;"> &nbsp;
                 <input type="button" class="button1" value="Sign Up" style="background-color: #4775d1;" ></td>
                 </tr>
                  <tr>
                  <td></td>
                  <td align="right"><a href="" style="color:black;font-size: 20px;">Forget My Password</a></td>
                  </tr>
                  </table>


		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>