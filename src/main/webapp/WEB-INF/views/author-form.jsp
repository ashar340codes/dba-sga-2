<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author Form</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>${author.id == null ? 'Add' : 'Edit'} Author</h1>
    <form:form modelAttribute="author" method="post">
        <form:hidden path="id" />
        <label>Name:</label> <form:input path="name" /><br>
        <label>Biography:</label> <form:textarea path="biography" /><br>
        <input type="submit" value="Save">
    </form:form>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
</body>
</html>
