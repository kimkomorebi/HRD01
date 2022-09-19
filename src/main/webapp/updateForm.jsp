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
		<h1 align="center">수강 신청 도우미 사이트</h1>
	</header>
	<section>
		<h2 align="left">교과목 수정</h2>
		<div align="center">
<%
	Courses c = (Courses)request.getAttribute("C");
	ArrayList<String> names = (ArrayList<String>)request.getAttribute("NAMES");
%>
			<form action="courseUpdateDo.do" method="post" onSubmit="">
				<table border="1">
					<tr>
						<th>교과목 코드</th>
						<td>
							<input type="text" name="ID" value="<%= c.getId() %>" readOnly="readOnly"/>
						</td>
					</tr>
					<tr>
						<th>과목명</th>
						<td>
							<input type="text" name="NAME" value="<%= c.getC_name() %>"/>
						</td>
					</tr>
					<tr>
						<th>담당강사</th>
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
						<th>학 점</th>
						<td>
							<input type="text" name="CREDIT" value="<%= c.getCredit()%>"/>
						</td>
					</tr>
					<tr>
						<th>요 일</th>
						<td>
							<%
								if(c.getDay() == 1){
							%>
								월<input type="radio" name="WEEK" value="1" checked="checked"/>
							<%
								}else {
							%>
								월<input type="radio" name="WEEK" value="1"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 2){
							%>
								화<input type="radio" name="WEEK" value="2" checked="checked"/>
							<%
								}else {
							%>
								화<input type="radio" name="WEEK" value="2"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 3){
							%>
								수<input type="radio" name="WEEK" value="3" checked="checked"/>
							<%
								}else {
							%>
								수<input type="radio" name="WEEK" value="3"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 4){
							%>
								목<input type="radio" name="WEEK" value="4" checked="checked"/>
							<%
								}else {
							%>
								목<input type="radio" name="WEEK" value="4"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 5){
							%>
								금<input type="radio" name="WEEK" value="5" checked="checked"/>
							<%
								}else {
							%>
								금<input type="radio" name="WEEK" value="5"/>
							<%	
								}
							%>
							<%
								if(c.getDay() == 6){
							%>
								토<input type="radio" name="WEEK" value="6" checked="checked"/>
							<%
								}else {
							%>
								토<input type="radio" name="WEEK" value="6"/>
							<%	
								}
							%>
						</td>
					</tr>
					<tr>
						<th>시작시간</th>
						<td>
							<input type="text" name="START" value="<%= c.getStart() %>"/>
						</td>
					</tr>
					<tr>
						<th>종료시간</th>
						<td>
							<input type="text" name="END" value="<%= c.getEnd()%>"/>
						</td>
					</tr>
				</table>
				<br/>
				<div align="center">
					<input type="button" value="목록" onClick="goList()"/>
					<input type="submit" value="수정"/>
					<input type="reset" value="취소"/>
				</div>
			</form>
		</div>
	</section>
	<footer>
		<h3 align="center">Copyright 2018 정보처리산업기사 All Right Reserved</h3>
	</footer>
	<script type="text/javascript">
		function goList(){
			location.href="courseList.do";//과목 목록을 호출하는 서블릿 매핑
		}
	</script>
</body>
</html>