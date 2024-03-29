<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeGym - Errore</title>
    <link rel="stylesheet" type="text/css" href="./css/error.css">
</head>
<body>
    <%@include file="header.jsp"%>

    <%
        String message = (String) request.getAttribute("message");
        if (message == null)
            message = "";
    %>
    <div id="empty-message">
        <h2>Attenzione, errore!</h2>
        <h2><%=message%></h2>
        <c:forEach items="${errors}" var="error">
            <h2>${error}</h2>
        </c:forEach>
    </div>

    <%@include file="footer.jsp"%>

</body>
</html>
