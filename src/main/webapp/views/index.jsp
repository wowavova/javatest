<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wowa
  Date: 22.10.2018
  Time: 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello

${vseUser}

<c:forEach
items="${vseUser}" var="u">
    <p>${u.id} ${u.name} ${u.age}</p>

</c:forEach>

</body>
</html>
