<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Adding</title>
</head>
<body>

<form method="post" action="">
    <label>Name:</label><br>
    <input type="text" name="name" pattern="\b[^\d\W]+\b"><br>
    <label>Surname:</label><br>
    <input type="text" name="surname" pattern="\b[^\d\W]+\b"><br>
    <label>Age:<input type="number" name="age" required></label>
    <input type="submit" name="Ok" value="Ok"><br>
</form>

</body>
</html>
