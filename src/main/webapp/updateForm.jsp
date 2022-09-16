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
			<form action="">
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
						<td>라디오 버튼으로 해당 요일을 출력</td>
					</tr>
					<tr>
						<th>시작시간</th>
						<td>
							<input type="text" name="START" value="<%= c.getStart_hour() %>"/>
						</td>
					</tr>
					<tr>
						<th>종료시간</th>
						<td>
							<input type="text" name="END" value="<%= c.getEnd_hour()%>"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<footer>
		<h3 align="center">Copyright 2018 정보처리산업기사 All Right Reserved</h3>
	</footer>
</body>
</html>