<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>
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
		<h2 align="left">������ ����</h2>
		<div align="center">
<%
	Courses c = (Courses)request.getAttribute("C");
	ArrayList<String> names = (ArrayList<String>)request.getAttribute("NAMES");
%>
			<form action="">
				<table border="1">
					<tr>
						<th>������ �ڵ�</th>
						<td>
							<input type="text" name="ID" value="<%= c.getId() %>" readOnly="readOnly"/>
						</td>
					</tr>
					<tr>
						<th>�����</th>
						<td>
							<input type="text" name="NAME" value="<%= c.getC_name() %>"/>
						</td>
					</tr>
					<tr>
						<th>��簭��</th>
						<td>
							<select name="T_NAME">
								<%
									for(String name : names){
										if(name.equals(c.getL_name())){
								%>
									<option selected="selected"><%= name %></option>
								<%
										}else {
								%>
									<option><%= name %></option>
								<%
										}
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>�� ��</th>
						<td>
							<input type="text" name="CREDIT" value="<%= c.getCredit()%>"/>
						</td>
					</tr>
					<tr>
						<th>�� ��</th>
						<td>���� ��ư���� �ش� ������ ���</td>
					</tr>
					<tr>
						<th>���۽ð�</th>
						<td>
							<input type="text" name="START" value="<%= c.getStart_hour() %>"/>
						</td>
					</tr>
					<tr>
						<th>����ð�</th>
						<td>
							<input type="text" name="END" value="<%= c.getEnd_hour()%>"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<footer>
		<h3 align="center">Copyright 2018 ����ó�������� All Right Reserved</h3>
	</footer>
</body>
</html>