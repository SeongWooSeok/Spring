<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
</head>
<body>
	<%
		String conPath = request.getContextPath();
	%>
	<form action="<%=conPath%>/done">
		작성자:<input type="text" name="writer" value="${dto.writer}"/><br>
		내용:<input type="text" name="content" value="${dto.content}"/><br>
		<input type="submit" value="전송"/><br>
	</form>
</body>
</html>