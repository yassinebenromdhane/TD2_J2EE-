<%--
  Created by IntelliJ IDEA.
  User: mre
  Date: 14/02/2024
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout produit</title>
</head>
<body>
<%
    if (session == null || session != null && session.getAttribute("nom") == null || session.getAttribute("nom").equals("")) {
        response.sendRedirect("index.jsp");
    } else {
%>
<form action="/traitement" method="post">
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required>
    <br>
    <label for="qte">Quantité:</label>
    <input type="text" id="qte" name="qte" required>
    <br>
    <br>
    <input type="submit" value="Ajouter">
</form>
<%
    }
%>
</body>
</html>
