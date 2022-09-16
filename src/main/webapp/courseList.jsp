<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<header>
	<h1 align="center">���� ��û ����� ����Ʈ</h1>
</header>
<section>
<%
	ArrayList<Courses> clist =(ArrayList<Courses>)request.getAttribute("CLIST");
	int cnt = (int)request.getAttribute("COUNT");
%>
	<div align="left">�� <%= cnt %>���� �������� �ֽ��ϴ�.</div><br/>
	<table border="1" align="center">
		<tr>
			<th>�����ڵ�</th>
			<th>�����</th>
			<th>����</th>
			<th>��簭��</th>
			<th>����</th>
			<th>���۽ð�</th>
			<th>����ð�</th>
			<th>����</th>
		</tr>
<%
	for(Courses c :clist){
%>
	<form action="courseUpdate.do" method="post">
		<input type="hidden" value="<%= c.getId() %>" name="ID"/>
		<tr>
			<td><%= c.getId() %></td>
			<td><%= c.getC_name() %></td>
			<td><%= c.getCredit() %></td>
			<td><%= c.getL_name() %></td>
			<td><%= c.getWeek() %></td>
			<td><%= c.getStart() %></td>
			<td><%= c.getEnd() %></td>
			<td>
				<input type="submit" value="����" name="BTN"/>
				<input type="submit" value="����" name="BTN"/>
			</td>
		</tr>
	</form>
<%
	}
%>
	<tr>
		<td colspan="8" align="right">
			<form action="entryCourse.do">
				<input type="submit" value="�� ��"/>
			</form>
		</td>
	</tr>
	</table>
</section>
<footer>
	<h3 align="center">Copyright 2018 ����ó�������� All Right Reserved</h3>
</footer>
</body>
</html>