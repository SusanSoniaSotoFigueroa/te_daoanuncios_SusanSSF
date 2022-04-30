<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Avisousuario"%>
<%
    Avisousuario avisousuario = (Avisousuario) request.getAttribute("avisousuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        
        
         <form action="AvisoControllerUsuario" method="post">
            <input type="hidden" name="id" value="${avisousuario.id}" />
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${avisousuario.nombre}" /></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="correo" value="${avisousuario.correo}" /></td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td><input type="text" name="clave" value="${avisousuario.clave}" /></td>
                </tr>
               
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
