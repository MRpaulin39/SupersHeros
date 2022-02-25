<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Connexion</title>
    <%@ include file="Composants/headCommun.jsp" %>
</head>
<body>
  <%@ include file="Composants/menu.jsp" %>

  <h1 class="CenterText">Page de connexion</h1>

  <c:if test="${ !empty erreur }"><p style="color:red;" class="CenterText"><c:out value="${ erreur }" /></p></c:if>


    <div class="Form">
        <form method="post" action="Login">
            <fieldset>
                <legend>Connexion</legend>

                <c:if test="${ !empty login.message }"><c:out value="${ login.message }"></c:out></c:if>

                <ul class="CenterText">
                    <li>
                        <label for="NameHero">Nom du super héro</label>
                    </li>
                    <li>
                        <input placeholder="Nom du héro" id="NameHero" name="NameHero" value="<c:if test="${ !empty NameHero }"><c:out value="${ NameHero }"></c:out></c:if>">
                    </li>
                </ul>

                <ul class="CenterText">
                    <li>
                        <label for="PasswordHero">Mot de passe</label>
                    </li>
                    <li>
                        <input placeholder="Mot de passe" type="password" id="PasswordHero" name="PasswordHero"/>
                    </li>
                </ul>

                <ul class="CenterText">
                    <li>
                        <input type="submit" value="Connexion" name="SubmitLogin"/>
                    </li>
                </ul>

            </fieldset>

            <a href="${pageContext.request.contextPath}/Register"><p class="CenterText">Pas de compte ? Inscrivez-vous !<p></p></a>

        </form>

    </div>
</body>
</html>
