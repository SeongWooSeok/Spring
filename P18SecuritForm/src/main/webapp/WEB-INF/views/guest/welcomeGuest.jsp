<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
   User ID:<sec:authentication property="name"/><br>
   <sec:authorize access="isAuthenticated()">
      <p>로<span style="font-align:center; color:blue; font-wegite:bold;">그Log-in</span>인</p>
   </sec:authorize>
   <sec:authorize access="!isAuthenticated()">
      <p>로그아웃</p>
   </sec:authorize>
   <a href="/logout">로그 아웃</a> <br>
   <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
      관리자 <del>또는</del> 사용자
   </sec:authorize>
   
   <sec:authorize access="hasRole('ROLE_ADMIN')">
      <em>아마도</em><mark><em>관리자</em></mark>
   </sec:authorize>
   
   <sec:authorize access="hasRole('ROLE_USER')">
       <em>사용자</em>
   </sec:authorize>
</body>
</html>