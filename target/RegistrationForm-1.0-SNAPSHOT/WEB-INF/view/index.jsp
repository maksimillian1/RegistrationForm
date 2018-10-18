<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
Hello from Hell, bitch!

<form method="get">
<c:forEach var="user" items="${requestScope.users}">

    <ul>
        <li> <c:out value="${user.getName()}"/></li>
        <li> <c:out value="${user.getSurname()}"/></li>
        <li> <c:out value="${user.getAge()}"/></li>
        <hr>
    </ul>

</c:forEach>
</form>

<form method="post", action="">

    <label> Name</label><br> <input type="text" name="name">
    <label> Surname</label><br> <input type="text" name="surname">
    <label> Age</label><br> <input type="number" name="age">
    <input type="submit" name="Ok" value="Ok"><br>
</form>


</body>
</html>