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
			<form action="courseUpdateDo.do" method="post" onSubmit="">
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
						<td>
							<%
								if(c.getDay() == 1){
							%>
								��<input type="radio" name="WEEK" value="1" checked="checked"/>
							<%
								}else {
							%>
								��<input type="radio" name="WEEK" value="1"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 2){
							%>
								ȭ<input type="radio" name="WEEK" value="2" checked="checked"/>
							<%
								}else {
							%>
								ȭ<input type="radio" name="WEEK" value="2"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 3){
							%>
								��<input type="radio" name="WEEK" value="3" checked="checked"/>
							<%
								}else {
							%>
								��<input type="radio" name="WEEK" value="3"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 4){
							%>
								��<input type="radio" name="WEEK" value="4" checked="checked"/>
							<%
								}else {
							%>
								��<input type="radio" name="WEEK" value="4"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 5){
							%>
								��<input type="radio" name="WEEK" value="5" checked="checked"/>
							<%
								}else {
							%>
								��<input type="radio" name="WEEK" value="5"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 6){
							%>
								��<input type="radio" name="WEEK" value="6" checked="checked"/>
							<%
								}else {
							%>
								��<input type="radio" name="WEEK" value="6"/>
							<%	
								}
							%>
						</td>
					</tr>
					<tr>
						<th>���۽ð�</th>
						<td>
							<input type="text" name="START" value="<%= c.getStart() %>"/>
						</td>
					</tr>
					<tr>
						<th>����ð�</th>
						<td>
							<input type="text" name="END" value="<%= c.getEnd()%>"/>
						</td>
					</tr>
				</table>
				<br/>
				<div align="center">
					<input type="button" value="���" onClick="goList()"/>
					<input type="submit" value="����"/>
					<input type="reset" value="���"/>
				</div>
			</form>
		</div>
	</section>
	<footer>
		<h3 align="center">Copyright 2018 ����ó�������� All Right Reserved</h3>
	</footer>
	<script type="text/javascript">
		function goList(){
			location.href="courseList.do";//���� ����� ȣ���ϴ� ���� ����
		}
	</script>
</body>
</html>