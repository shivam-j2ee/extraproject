<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Marksheet</title>
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
<table>
<tr>
<td><h1>Edit Marksheet</h1></td>
<td></td>
</tr>
<tr>
<td id="po3">Roll No* </td>
<td></td>
</tr>
<tr>
<td id="po3">Name *</td>
<td><input type="text" name="name" id="po4" size="60"></td>
</tr>
<tr>
<td id="po3">Physics</td>
<td><input type="text" name="physics" id="po4" size="60"></td>
</tr>
<tr>
<td id="po3">Chemistry</td>
<td><input type="text" name="chemistry" id="po4" size="60"></td>
</tr>
<tr>
<td id="po3">Maths</td>
<td><input type="text" name="maths" id="po4" size="60"></td>
</tr>
<tr>
<td></td>
<td align="right"><input type="button" value="Save"
					class="button1" style="background-color: #4775d1;"> &nbsp;
                      <input type="button" value="Cancel"
					class="button1" style="background-color: #4775d1;"> &nbsp;
					<input type="button" class="button1" value="Delete"
					style="background-color: #4775d1;"></td>
</tr>

</table>



</form>
</body>
<%@ include file="Footer.jsp"%>
</html>