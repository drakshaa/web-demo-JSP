<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>

<h1>Signup</h1>
<hr>

<form action="SignupServlet" method="post" style="font-family: Arial; font-size: 20px;">

  First Name: <input type="text" name="FirstName"><br><br>
  Last Name: <input type="text" name="LastName"><br><br>
  Username: <input type="text" name="Username"><br><br>
  Password: <input type="password" name="Password"><br><br>
  <input type="submit" value="Signup">

</form>

<hr>
<a href="index.jsp">Back</a>

</body>
</html>
