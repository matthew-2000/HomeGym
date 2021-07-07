<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 07/07/2021
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Errore</title>
</head>
<body>
    <%String message = (String) request.getAttribute("message");%>
    <%=message%>
</body>
</html>
