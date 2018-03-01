<%-- 
    Document   : livros
    Created on : 26/02/2018, 20:36:33
    Author     : Rafael.Soares
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Livros</h1>
        <table>
            <thead>
                <td>autor</td>
                <td>editora</td>
                <td>titulo</td>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listalivro}" var="liv">
                    <tr>
                        <td>${liv.autor}</td>
                        <td>${liv.editora}</td>
                        <td>${liv.titulo}</td>
                    </tr>
                </c:forEach>
            </tbody>
                
                
        </table>
    </body>
</html>
