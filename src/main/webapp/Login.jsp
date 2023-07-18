<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1><%= "Login" %>
</h1>
<%
    String message= (String)request.getAttribute("error");
    if(message!=null){
        response.getWriter().println(message);
    }
%>
<form action="Login" method="post">
    <label for="llogin">Login :</label>
    <input type="text" name="llogin" id="llogin"><br>
    <label for="pwd">Password :</label>
    <input type="text" name="pwd" id="pwd"><br>
    <input type="submit" value="Envoyer">
    <label for=""><a href="creerCompte">Creer un compte</a> </label>
</form>
<br/>
</body>
</html>