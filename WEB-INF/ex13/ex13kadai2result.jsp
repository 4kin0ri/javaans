<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取得結果</title>
</head>
<body>
<%--ポイント: 学籍番号と氏名を記入してください． --%>
学籍番号: C0A21145 <br>
氏名: 内野彰紀<br>

<%--
ポイント: requestから，"retList"という名前で，取得した情報をlistへ格納させてください．
--%>
<%
ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("retList");
Iterator<HashMap<String, String>> lIte = list.iterator();
%>
<table><tr><td>department_id</td><td>department_name</td><td>location_id</tr>

<table>
<%
while(lIte.hasNext()){
	HashMap<String, String> map = lIte.next();

%>
	<tr>
		<%--ポイント: mapから，department_id, department_name, location_idの値をgetして，表示させてください． --%>
		<td><%= map.get("department_id") %></td>
		<td><%= map.get("department_name") %></td>
		<td><%= map.get("location_id") %></td>
	</tr>
<%
}
%>
</table>
</body>
</html>
