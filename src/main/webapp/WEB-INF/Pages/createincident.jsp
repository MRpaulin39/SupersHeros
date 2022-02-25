<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Création d'un incident</title>
    <%@ include file="Composants/headCommun.jsp" %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
          integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
          crossorigin=""/>

    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
            integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
            crossorigin=""></script>
</head>
<body>
    <%@ include file="Composants/menu.jsp" %>

    <h1 class="CenterText">Créer un incident</h1>

    <c:if test="${ !empty erreur }"><p style="color:red;" class="CenterText"><c:out value="${ erreur }" /></p></c:if>

    <%--    S'affiche lors de la requête GET--%>
    <c:if test="${ !empty listTypeIncident }">
        <div class="Form">
            <form method="post" action="CreateIncident">
                <fieldset>
                    <legend>Signaler un incident</legend>

                    <ul class="CenterText">
                        <li>
                            <label for="CityHero">Nom de la ville</label>
                        </li>
                        <li>
                            <input placeholder="Nom de la ville" id="CityHero" name="CityHero" value="<c:if test="${ !empty CityHero }"><c:out value="${ CityHero }"></c:out></c:if>"/>
                            <input id="CityHeroLat" name="CityHeroLat" type="hidden" value="<c:if test="${ !empty CityHeroLat }"><c:out value="${ CityHeroLat }"></c:out></c:if>"/>
                            <input id="CityHeroLong" name="CityHeroLong" type="hidden" value="<c:if test="${ !empty CityHeroLong }"><c:out value="${ CityHeroLong }"></c:out></c:if>"/>
                        </li>
                    </ul>

                    <div id="map"></div>

                    <script type="text/javascript" src="JS/map.js"></script>

                    <ul class="CenterText">
                        <li>
                            <label for="IdIncident">Type d'incident</label>
                        </li>
                        <li>
                            <select name="IdIncident" id="IdIncident">
                                <option value="0">--Choisir une option--</option>

                                <c:if test="${ !empty listTypeIncident }">
                                    <c:forEach items="${listTypeIncident}" var="map">
                                        <option value="${map.id}">${map.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </li>

                    </ul>

                    <ul class="CenterText">
                        <li>
                            <input type="submit" value="Valider" name="SubmitIncident"/>
                        </li>
                    </ul>
                </fieldset>

            </form>

        </div>
    </c:if>

    <%--S'affiche lors de la requête POST--%>
    <c:if test="${ !empty listHeroIncident }">

        <table class="CenterText" id="tableResultHero">
            <tr>
                <td>Nom du héro</td>
                <td>Distance</td>
                <td>Téléphone</td>
            </tr>

            <c:if test="${ !empty listHeroIncident }">
                <c:forEach items="${listHeroIncident}" var="map">
                    <tr>
                        <td>${map.nameHero}</td>
                        <td>${map.cityDistance} km</td>
                        <td>${map.phone}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>


    </c:if>

</body>
</html>
