<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
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
		<div align="center"><h2>������ �߰�</h2></div>
		<%
			ArrayList<String> names = (ArrayList<String>)request.getAttribute("NAMES");
		%>
	<form action="">
		<table border="1" align="center">
			<tr>
				<th>������ �ڵ�</th>
				<td>
					<input type="text" name="CODE"/>
				</td>
			</tr>
			<tr>
				<th>�����</th>
				<td>
					<input type="text" name="NAME"/>
				</td>
			</tr>
			<tr>
				<th>��簭��</th>
				<td>
					<select name="LEC">
						<%
							for(String name : names){
						%>
							<option><%= name %></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<input type="text" name=""/>
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<label for="mon">��</label><input type="radio" value="1" name="WEEK" id="mon"/>
					<label for="tue">ȭ</label><input type="radio" value="2" name="WEEK" id="tue"/>
					<label for="wed">��</label><input type="radio" value="3" name="WEEK" id="wed"/>
					<label for="thr">��</label><input type="radio" value="4" name="WEEK" id="thr"/>
					<label for="fri">��</label><input type="radio" value="5" name="WEEK" id="fri"/>
					<label for="set">��</label><input type="radio" value="6" name="WEEK" id="set"/>
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<input type="text" name="START"/>
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<input type="text" name="END"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="���"/>
					<input type="submit" value="�Ϸ�"/>
				</td>
			</tr>
		</table>
	</form>
	</section>
	<footer>
		<h3 align="center">Copyright 2018 û��ó�������� All Right Reserved</h3>
	</footer>
</body>
</html>