<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome : Admin
	<br>
	<br>
	<!-- 
	${pageContext.request.userPrincipal.name}
	<c:if test="${not empty pageContext.request.userPrincipal.name}">
	<p>is Log-in</p>
	</c:if>
	<c:if test="${empty pageContext.request.userPrincipal.name}">
	<p>is Log-out</p>
	</c:if>
	 -->
	 user ID : <sec:authentication property="name"/><br>
	<sec:authorize access="isAuthenticated()">
		<p>is Log-in</p>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<p>is Log-in</p>
	</sec:authorize>
	<a href="/logout">로그아웃</a><br><br>
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