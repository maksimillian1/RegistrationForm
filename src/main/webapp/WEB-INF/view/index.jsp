<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
Hello from Hell, bitch!

<c:forEach var="user" items="${requestScope.users}">

    <ul>
        <li> <c:out value="${user.getName()}"/></li>
        <li> <c:out value="${user.getSurname()}"/></li>
        <li> <c:out value="${user.getAge()}"/></li>
        <hr>
    </ul>

</c:forEach>

<form method="post", action="">
    <label> <input type="text" name="name">Name</label><br>
    <label> <input type="text" name="surname">Surname</label><br>
    <label> <input type="number" name="age">Age</label><br>
    <input type="submit" name="Ok" value="Ok"><br>
</form>


</body>
</html>