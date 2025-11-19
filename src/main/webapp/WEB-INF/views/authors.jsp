<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authors</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>Authors</h1>
    <a href="/authors/new">Add New Author</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Biography</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.biography}</td>
                <td><a href="/authors/edit/${author.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <h2>Books</h2>
    <a href="/books">View Books</a>
</body>
</html>
