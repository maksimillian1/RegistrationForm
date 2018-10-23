<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<div align="center">List of all users</div>

<c:forEach var="user" items="${requestScope.users}">

    <ul>
        <li> <c:out value="${user.getFirstName()}"/></li>
        <li> <c:out value="${user.getLastName()}"/></li>
        <li> <c:out value="${user.getDateOfBirth()}"/></li>
        <%--<form method="post" action="<c:url value='/delete'/>">--%>
            <%--<input type="submit" name="Delete" value="Delete">--%>
        <%--</form>--%>
        <hr>
    </ul>

</c:forEach>

<form method="post" action="<c:url value='/'/>">
<input type="submit" name="Add user" value="Add user">
</form>

</body>
</html>