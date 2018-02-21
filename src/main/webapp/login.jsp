<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 19/02/2018
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form method="POST" action="login/iniciar">
        <div class="center">
            <table>
                <tr>
                    <td>
                        <form:input path="nombreUsuario" placeholder="Usuario" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:input path="password" placeholder="Contraseña" type="password" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Ingresar"/>
                    </td>
                </tr>
            </table>
        </div>
    </form:form>
</body>
</html>
