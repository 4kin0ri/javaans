<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex12.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功ページ</title>
</head>
<body>
ログインに成功しました．<br>
<%--ポイント: 学籍番号と氏名を記入してください． --%>
学籍番号: C0A21145 <br>
氏名: 内野彰紀<br>
<%--ポイント: sessionから，Ex12Kadai2Servletにて設定したmapを
取得して，そしてbeanに格納させてください．
1行で，かつキャストさせてください --%>
<%
HashMap map = (HashMap)session.getAttribute("info");
%>

<%--以下のIDから性別まで，mapに入っている値を表示させてください． --%>

ID:<%= (String)map.get("id") %><br>
Password:<%= (String)map.get("password")  %><br>
名前: <%=(String)map.get("name")%><br>
住所: <%=(String)map.get("address")%><br>
性別: <%=(String)map.get("gender")%><br>
</body>
</html>
