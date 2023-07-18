<%@ page import="com.example.bo.Utilisateur" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultat</title>
</head>
<body>
    <p>Partie terminée !</p>
    <%  Utilisateur user =(Utilisateur)request.getSession().getAttribute("current_user");
        int score= (int)request.getAttribute("score");
        Integer bestScore= (Integer) request.getAttribute("bestScore");

    %><p>| Votre score : <%=score%> | Meilleur score : <%= user.getBestScore()%>|</p>
    <p>Meilleur score de tous les joueurs: <%=bestScore%></p>
    <br/>
</body>
</html>