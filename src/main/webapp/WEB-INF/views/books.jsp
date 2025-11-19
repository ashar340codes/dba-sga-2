<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>Books</h1>
    <a href="/books/new">Add New Book</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.genre}</td>
                <td>${book.author.name}</td>
                <td><a href="/books/edit/${book.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <h2>Joined Data (Books with Authors)</h2>
    <table>
        <tr>
            <th>Book Title</th>
            <th>Author Name</th>
        </tr>
        <c:forEach var="item" items="${joinedData}">
            <tr>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/authors">View Authors</a>
</body>
</html>
