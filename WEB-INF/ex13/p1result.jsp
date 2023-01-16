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
<%
ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("retList");
Iterator<HashMap<String, String>> lIte = list.iterator();
%>
<table><tr><td>employee_id</td><td>first_name</td><td>last_name</tr>

<table>
<%
while(lIte.hasNext()){
	HashMap<String, String> map = lIte.next();

%>
	<tr>
		<td><%= map.get("employee_id")%></td>
		<td><%= map.get("first_name") %></td>
		<td><%= map.get("last_name") %></td>
	</tr>
<%
}
%>
</table>
</body>
</html>