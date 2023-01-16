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
<%--ポイント:
sessionから，"userList"という属性名として取得し，HashMap<String, Object>を要素にもつArrayListに格納してください．
--%>
<%
ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>)session.getAttribute("userList");
Iterator<HashMap<String, Object>> lIte = list.iterator();
%>
<table><tr><td>employee_id</td><td>first_name</td><td>last_name</td><td>salaly</td></tr>
<%
while(lIte.hasNext()){
	HashMap<String, Object> map = lIte.next();

%>
	<tr>
	<%--ポイント: mapから，employee_id~salaryまでの値を取得するようにメソッド名を書いてください． --%>
		<td><%= map.get("employee_id")%></td>
		<td><%= map.get("first_name") %></td>
		<td><%= map.get("last_name") %></td>
		<td><%= map.get("salary") %></td>
		<td></td>
	</tr>
<%
}
%>
</table>
<%--/javabweb/ex14/Ex14Kadai22Servletを呼び出す． --%>
<form action="./Ex14Kadai22Servlet" method="GET">
<%--salary(給料)の降順にソートした結果を表示させるリクエストを投げる --%>
上記の検索結果に対し，Salary(給料)の降順にソートします．
<input type="submit" value="ソート">
</form>
</body>
</html>
