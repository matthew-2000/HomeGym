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
    <%@include file="header.jsp"%>

    <%String message = (String) request.getAttribute("message");%>

    <div class="">
        <h2>Attenzione, errore!</h2>
        <h4><%=message%></h4>
    </div>

    <%@include file="footer.jsp"%>

</body>
</html>
