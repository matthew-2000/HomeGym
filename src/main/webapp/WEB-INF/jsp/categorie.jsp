<%--
  Created by IntelliJ IDEA.
  User: jacop
  Date: 14/05/2021
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HomeGym - Categorie</title>
    <link rel="stylesheet" href="./css/categorie.css" type="text/css">
</head>
<body>

    <%@include file="header.jsp"%>

    <div class="container-categorie">
        <div class="box">
            <h2>List Categories</h2>
            <ul>
                <li><div class="div-categoria">
                    <span>1</span>Item One
                </div></li>
                <li><span>2</span>Item Two</li>
                <li><span>3</span>Item Five</li>
                <li><span>4</span>Item Four</li>
                <li><span>5</span>Item Five</li>
                <li><span>6</span>Item Six</li>
            </ul>
        </div>
    </div>


    <%@include file="footer.jsp"%>

</body>
</html>
