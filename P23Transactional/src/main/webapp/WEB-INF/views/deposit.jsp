<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
</head>
<body>
	<p>입금</p>
	<form action="deposit_process">
		계좌:<input type="text" name="accountid"><br>
		입금액:<input type="text" name="amount"><br>
		에러 발생 여부:<input type="text" name="error" value="0"><br>
		<input type="submit" value="입금"><br>
	</form>
</body>
</html>