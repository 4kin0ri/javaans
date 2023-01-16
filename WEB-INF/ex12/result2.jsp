<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex12.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果ページ</title>
</head>
<body>
<% UserInfo info = (UserInfo)session.getAttribute("userinfo"); %>
名前: <%=info.getName() %></br>
性別: <%=info.getGender() %></br>
<a href="./nextpage.jsp">次のページへ進む</a>
</body>
</html>