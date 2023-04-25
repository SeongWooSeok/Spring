<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>model and view</title>
</head>
<body>
	<%
		out.println("Model : view");
	%>
	<br>
	${ObjectTest }
	<br>
	${lists }
	<br><br>
	<c:forEach var="myList" items="${lists }">
		${mylist } <br>
	</c:forEach>
	<br><br>
	이름 : ${name }
</body>
</html>