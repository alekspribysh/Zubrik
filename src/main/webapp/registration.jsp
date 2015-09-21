<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

 <H3>Registartion Form</H3>
<form action="${pageContext.request.contextPath}/login" method="post">
  Login: <input type="text" name="loginParam"/><br>
  Password: <input type="password" name="passwd"/><br>
  Repeat Password: <input type="repeatpassword" name="passwd2"/><br>
  Full Name: <input type="fullname" name="fullname"/><br>
  Email: <input type="email" name="email"/><br>
  <input type="submit" value="submit"/>

</form>


</body>
</html>
