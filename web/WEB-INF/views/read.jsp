<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read from cats table</title>
</head>
<body>
    <h2>Cat names:</h2>
    <c:forEach items="${read}" var="cat" varStatus="status">
        <ul>
            <li>${cat.name}</li>
        </ul>
    </c:forEach>
</body>
</html>
