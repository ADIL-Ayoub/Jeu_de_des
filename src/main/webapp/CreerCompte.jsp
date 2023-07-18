<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><%= "Login" %>
</h1>
<form action="creerCompte" method="post">
    <label for="nom">Nom  :</label>
    <input type="text" name="nom" id="nom"><br/>
    <label for="prenom">Prenom  :</label>
    <input type="text" name="prenom" id="prenom"><br/>
    <label for="login">Login  :</label>
    <input type="text" name="login" id="login"><br/>
    <label for="pw">Mot de passe :</label>
    <input type="text" name="pw" id="pw"><br/>
    <input type="submit" value="Envoyer">
</form>
<br/>
</body>
</html>