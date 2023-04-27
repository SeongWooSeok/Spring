<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write form</title>
</head>
<body>
<form action="writing" method="post">
	작성자:<input type="text" name="writer" size="100"><br>
	제목:<input type="text" name="title" size="100"><br>
	내용:<input type="text" name="content" size="100"><br>
	<input type="submit" value="입력"><br>
	<a href="list">목록</a>
</form>
</body>
</html>