<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="ex13.*" %>
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
ArrayList<EmployeesDTO> list = (ArrayList<EmployeesDTO>)request.getAttribute("retList");
Iterator<EmployeesDTO> lIte = list.iterator();
%>
<table><tr><td>employee_id</td><td>first_name</td><td>last_name</tr>

<table>
<%
while(lIte.hasNext()){

	EmployeesDTO dto = lIte.next();

%>
	<tr>
	<%--ポイント: dtoから，employee_id, first_name, last_nameの値をgetして，表示させてください． --%>
		<td><%= dto.getEmployee_id() %></td>
		<td><%= dto.getFirst_name() %></td>
		<td><%= dto.getLast_name() %></td>
	</tr>
<%
}
%>
</table>
</body>
</html>
