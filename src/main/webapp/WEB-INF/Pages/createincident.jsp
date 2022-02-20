<%--
  Created by IntelliJ IDEA.
  User: Paulin
  Date: 02/02/2022
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Création d'un incident</title>
    <%@ include file="Composants/headCommun.jsp" %>
</head>
<body>
    <h1 class="CenterText">Créer un incident</h1>

    <%@ include file="Composants/menu.jsp" %>

    <div class="Form">
        <form>
            <fieldset>
                <legend>Signaler un incident</legend>

                <ul class="CenterText">
                    <li>
                        <label for="NameCity">Nom de la ville</label>
                    </li>
                    <li>
                        <input placeholder="Nom de la ville" id="NameCity" name="NameCity"/>
                    </li>
                </ul>

                <ul class="CenterText">
                    <li>
                        <label for="NameIncident">Type d'incident</label>
                    </li>
                    <li>
                        <select name="NameIncident" id="NameIncident">
                            <%-- //TODO Faire en sorte que les options se remplissent via la BDD--%>
                            <option value="0">--Choisir une option--</option>
                            <option value="1">Incendie</option>
                            <option value="2">Accident Routier</option>
                            <option value="3">Accident Fluviale</option>
                            <option value="4">Accident Aérien</option>
                            <option value="5">Eboulement</option>
                            <option value="6">Invasion de serpent</option>
                            <option value="7">Fuite de gaz</option>
                            <option value="8">Manifestation</option>
                            <option value="9">Braquage</option>
                            <option value="10">Evasion de prisonnier</option>
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

</body>
</html>
