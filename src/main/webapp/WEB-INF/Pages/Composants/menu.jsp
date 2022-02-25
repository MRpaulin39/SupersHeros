<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <h1 class="CenterText">Super Hero</h1>

  <h2 class="CenterText">Bienvenue sur le site répertoriant les super héros !</h2>

  <nav>
    <ul>
      <li>
        <a href="${pageContext.request.contextPath}/">Accueil</a>
        <a href="${pageContext.request.contextPath}/CreateIncident">Déclarer un incident</a>
        <c:if test="${ empty CookieNameHero }"><a href="${pageContext.request.contextPath}/Login">Connexion</a></c:if>
        <c:if test="${ empty CookieNameHero }"><a href="${pageContext.request.contextPath}/Register">Inscription</a></c:if>
        <c:if test="${ !empty CookieNameHero }"><a href="${pageContext.request.contextPath}/Profil">Profil</a></c:if>
        <c:if test="${ !empty CookieNameHero }"><a href="${pageContext.request.contextPath}/Logout">Déconnexion</a></c:if>
      </li>
    </ul>
  </nav>