<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>${book.id == null ? 'Add' : 'Edit'} Book</h1>
    <form:form modelAttribute="book" method="post" action="/books">
        <form:hidden path="id" />
        <label>Title:</label> <form:input path="title" /><br>
        <label>Genre:</label> <form:input path="genre" /><br>
        <label>Author:</label>
        <form:select path="author.id">
            <c:forEach var="author" items="${authors}">
                <form:option value="${author.id}">${author.name}</form:option>
            </c:forEach>
        </form:select><br>
        <input type="submit" value="Save">
    </form:form>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
</body>
</html>
