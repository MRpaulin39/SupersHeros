<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
<%--    <%@ include file="Composants/headCommun.jsp" %>--%>
    <%@ include file="Composants/headCommun.jsp" %>
</head>
<body>
    <h1 class="CenterText">Super Hero</h1>

    <h2 class="CenterText">Bienvenue sur le site répertoriant les super héros !</h2>

    <%@ include file="Composants/menu.jsp" %>

    <c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>

</body>
</html>
