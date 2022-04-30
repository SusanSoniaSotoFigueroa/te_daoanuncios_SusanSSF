<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Avisousuario"%>
<%@page import="java.util.List"%>
<%
    List<Avisousuario> avisos = (List<Avisousuario>)request.getAttribute("avisosusuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado Anuncios</h1>
        
         <p><a href="AvisoControllerUsuario?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Clave</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${avisosusuario}">
              <tr>
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.correo}</td>
                <td>${item.clave}</td>
                <td><a href="AvisoControllerUsuario?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="AvisoControllerUsuario?action=delete&id=${item.id}">Eliminar</a></td>
            </tr>              
            </c:forEach>
        </table>
    
        
    </body>
</html>
