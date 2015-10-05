<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<H3>Add Doctors Form</H3>
<form action="${pageContext.request.contextPath}/doctors" method="post">
  NameFulname: <input type="text" name="fullname"/><br>
  Specialization: <input type="text" name="spec"/><br>
  Email: <input type="email" name="email"/><br>
  <input type="submit" value="submit"/>

</form>


</body>
</html>
