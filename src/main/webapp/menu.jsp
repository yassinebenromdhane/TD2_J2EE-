<%--
  Created by IntelliJ IDEA.
  User: mre
  Date: 13/02/2024
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>

    <%
        // Vérifier si la session est créée et si l'objet "nom" existe et n'est pas vide
        if (session == null || session != null && session.getAttribute("nom") == null || session.getAttribute("nom").equals("")) {
            response.sendRedirect("index.jsp");
        } else {
    %>

</head>
<body>
<p>
session 1: <%= session.getAttribute("nom") != null ? session.getAttribute("nom") : "Not logged in" %>
</p>
</br>
<ul>
    <li>
        <a href="ajout.jsp"> Ajout produit </a>
    </li>
    <li>
        <a href="chercher.jsp"> Chercher produit </a>
    </li>
</ul>

<h5><%= request.getAttribute("msg") != null ? request.getAttribute("msg") : "" %>

</h5>




</body>
</html>
<%
    }
%>