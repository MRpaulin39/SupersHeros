<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
<%--    <%@ include file="Composants/headCommun.jsp" %>--%>
    <%@ include file="Composants/headCommun.jsp" %>
</head>
<body>
    <%@ include file="Composants/menu.jsp" %>

    <c:if test="${ !empty erreur }"><p style="color:red;" class="CenterText"><c:out value="${ erreur }" /></p></c:if>

    <h2 class="CenterText">Bienvenue sur votre site de Supers Heros</h2>

    <div class="ImgHome">
        <img src="${pageContext.request.contextPath}/IMG/home.jpg">
    </div>


    <h3 class="CenterText">Vous êtes témoin d'un accident, d'un braquge ou bien d'une invasion de serpent ? Signaler le en <a href="${pageContext.request.contextPath}/CreateIncident">cliquant ici</a></h3>

    <h3 class="CenterText">Vous êtes un super héro et vous souhaitez proposer vos services à la communauté ? Inscrivez vous en <a href="${pageContext.request.contextPath}/Register">cliquant ici</a></h3>


</body>
</html>
