<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	welcome:Admin<br>
<%--
	User ID : ${ pageContext.request.userPrincipal.name} <br>
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>is Log-in</p>
	</c:if>
	<c:if test="${empty pageContext.request.userPrincipal}">
		<p>is Log-out</p>
	</c:if>
	<br>
 --%>
	User ID : <sec:authentication property="name"/><br>
	<sec:authorize access="isAuthenticated()">
		<p>is Log-in</p>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<p>is Log-out</p>
	</sec:authorize>
	<a href="/logout">로그 아웃</a><br>
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		관리자 혹은 사용자
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		관리자
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		사용자
	</sec:authorize>
</body>
</html>