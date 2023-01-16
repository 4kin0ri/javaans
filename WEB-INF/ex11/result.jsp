<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果ページ</title>
</head>
<body>
名前: <%=request.getAttribute("result_name") %>
性別: <%=request.getAttribute("result_gender") %>
</body>
</html>