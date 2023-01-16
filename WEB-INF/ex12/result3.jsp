<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex12.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果ページ</title>
</head>
<body>
<% HashMap info = (HashMap)session.getAttribute("userinfo"); %>
名前: <%=(String)info.get("name") %></br>
性別: <%=(String)info.get("gender") %></br>
</body>
</html>