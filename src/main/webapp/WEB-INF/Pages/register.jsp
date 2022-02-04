<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Inscription</title>
    <%@ include file="Composants/headCommun.jsp" %>
</head>
<body>
    <h1 class="CenterText">Page d'inscription</h1>

    <%@ include file="Composants/menu.jsp" %>

    <c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>

    <%-- Todo : Ajouter latitude longitude --%>

    <div class="Form">
        <form action="${pageContext.request.contextPath}/Register">

            <fieldset>
                <legend>Inscription</legend>

                <fieldset>
                    <legend>Vos coordonnées</legend>

                    <ul class="CenterText">
                        <li>
                            <label for="NameHero">Nom du super héro</label>
                        </li>
                        <li>
                            <input placeholder="Nom du héro" id="NameHero" name="NameHero" />
                        </li>
                    </ul>

                    <ul class="CenterText">
                        <li>
                            <label for="PhoneHero">Numéro de téléphone</label>
                        </li>
                        <li>
                            <input placeholder="Numéro de téléphone" id="PhoneHero" name="PhoneHero"/>
                        </li>
                    </ul>

                    <ul class="CenterText">
                        <li>
                            <label for="CityHero">Ville</label>
                        </li>
                        <li>
                            <input placeholder="Votre ville" id="CityHero" name="CityHero"/>
                        </li>
                    </ul>

                </fieldset>

                <fieldset>
                    <legend>Votre mot de passe</legend>

                    <ul class="CenterText">
                        <li>
                            <label for="PasswordHero">Mot de passe</label>
                        </li>
                        <li>
                            <input placeholder="Mot de passe" id="PasswordHero" name="PasswordHero"/>
                        </li>
                    </ul>

                    <ul class="CenterText">
                        <li>
                            <label for="PasswordCheckHero">Confimer le mot de passe</label>
                        </li>
                        <li>
                            <input placeholder="Confirmer le mot de passe" id="PasswordCheckHero" name="PasswordCheckHero"/>
                        </li>
                    </ul>


                </fieldset>

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

                </fieldset>

                <ul class="CenterText">
                    <li>
                        <input type="submit" value="Inscription" name="SubmitRegister"/>
                    </li>
                </ul>

            </fieldset>

        </form>

    </div>

</body>
</html>
