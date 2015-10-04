<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<H3>Registartion Form</H3>
<form action="${pageContext.request.contextPath}/registration" method="post">
  NameFulname: <input type="text" name="loginParam"/><br>
  <%--Password: <input type="password" name="passwd"/><br>--%>
  Specialization: <input type="text" name="specialization"/><br>
  Email: <input type="email" name="email"/><br>
  <input type="submit" value="submit"/>

</form>


</body>
</html>
