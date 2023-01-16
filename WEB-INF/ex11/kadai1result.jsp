<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課題1結果ページ</title>
</head>
<body>
<%--ポイント: 学籍番号と氏名を記入してください． --%>
学籍番号: C0A21145 <br>
氏名: 内野彰紀<br>
<%--ポイント: Ex11Kadai1Servletにて設定したresult_okashiの値を表示させてください． --%>
好きなお菓子: <%=request.getAttribute("result_okashi") %> <br>

<%--ポイント: Ex11Kadai1Servletにて設定したresult_kudamonoの値を表示させてください． --%>
好きなフルーツ: <%=request.getAttribute("result_kudamono") %>
</body>
</html>
