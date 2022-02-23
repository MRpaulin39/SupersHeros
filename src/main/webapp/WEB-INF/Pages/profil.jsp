<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <%--    <%@ include file="Composants/headCommun.jsp" %>--%>
    <%@ include file="Composants/headCommun.jsp" %>
</head>
<body>
    <h1 class="CenterText">Super Hero</h1>

    <h2 class="CenterText">Profil de <c:if test="${ !empty NameHero }"><c:out value="${ NameHero }"></c:out></c:if></h2>

    <%@ include file="Composants/menu.jsp" %>

    <c:if test="${ !empty erreur }"><p style="color:red;" class="CenterText"><c:out value="${ erreur }" /></p></c:if>
    <c:if test="${ !empty succes }"><p style="color:lightskyblue;" class="CenterText"><c:out value="${ succes }" /></p></c:if>

    <p class="CenterText">
        Vous êtes capable de gérer les incidents suivants :
    </p>

    <%--Afficher les 3 évenements (max) que l'utilisateur peux gérer--%>
    <ul class="CenterText">
    <c:if test="${ !empty listIncidentProfil }">

        <c:forEach items="${listIncidentProfil}" var="map">

            <li>${map.name}</li>

        </c:forEach>

    </c:if>
    </ul>

    <%--Formulaire pour changer les évènements d'un héro--%>
    <div class="Form">
        <form method="post" action="Profil">
            <fieldset class="CbList">
                <legend>Vos incidents - Choisir entre 1 et 3 incidents que vous pouvez gérer</legend>


                <table>
                    <c:if test="${ !empty listTypeIncident }">

                        <c:forEach items="${listTypeIncident}" var="map">
                            <tr>
                                <td>
                                    <input id="Cb${map.id}" name="Cb${map.id}" type="checkbox" />
                                </td>
                                <td>
                                    <label for="Cb${map.id}">${map.name}</label>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>

                </table>


                <ul class="CenterText">
                    <li>
                        <input type="submit" value="Mise à jour" name="SubmitProfilUpdate"/>
                    </li>
                </ul>
            </fieldset>

        </form>
    </div>

</body>
</html>
