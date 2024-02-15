<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentification</title>
</head>
<body>
<%
    // Vérifier si la session est créée et si l'objet "nom" existe et n'est pas vide
    if (session != null && session.getAttribute("nom") != null && !session.getAttribute("nom").equals("")) {
        // Redirection vers la page menu.jsp
        response.sendRedirect("menu.jsp");
    } else {
%>
<form action="/connexion-auth" method="get">
    <label for="login">Login:</label>
    <input type="text" id="login" name="login" required>
    <br>
    <label for="mdp">Mot de passe:</label>
    <input type="password" id="mdp" name="mdp" required>
    <br>
    <br>
    <input type="submit" value="Se connecter">
</form>
<%
    }
%>
</body>
</html>
