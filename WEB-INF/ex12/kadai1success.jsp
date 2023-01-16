<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex12.*" %>
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
<%--ポイント: sessionから，Ex12Kadai1Servletにて設定したKadai1Beanを
取得して，そしてbeanに格納させてください．
1行で，かつキャストさせてください --%>
<%
Kadai1Bean bean = (Kadai1Bean)session.getAttribute("info");
%>

<%--以下のIDから性別まで，beanに入っている値を表示させてください． --%>
ID:<%= bean.getId() %><br>
Password:<%=bean.getPassword() %><br>
名前: <%= bean.getName() %><br>
住所: <%= bean.getAddress() %><br>
性別: <%= bean.getGender() %><br>
</body>
</html>
