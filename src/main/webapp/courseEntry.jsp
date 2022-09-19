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
		<h1 align="center">수강 신청 도우미 사이트</h1>
	</header>
	<section>
		<div align="center"><h2>교과목 추가</h2></div>
		<%
			ArrayList<String> names = (ArrayList<String>)request.getAttribute("NAMES");
		%>
	<form action="courseEntry.do" method="post">
		<table border="1" align="center">
			<tr>
				<th>교과목 코드</th>
				<td>
					<input type="text" name="CODE"/>
				</td>
			</tr>
			<tr>
				<th>과목명</th>
				<td>
					<input type="text" name="NAME"/>
				</td>
			</tr>
			<tr>
				<th>담당강사</th>
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
				<th>학점</th>
				<td>
					<input type="text" name="CREDIT"/>
				</td>
			</tr>
			<tr>
				<th>요일</th>
				<td>
					<label for="mon">월</label><input type="radio" value="1" name="WEEK" id="mon"/>
					<label for="tue">화</label><input type="radio" value="2" name="WEEK" id="tue"/>
					<label for="wed">수</label><input type="radio" value="3" name="WEEK" id="wed"/>
					<label for="thr">목</label><input type="radio" value="4" name="WEEK" id="thr"/>
					<label for="fri">금</label><input type="radio" value="5" name="WEEK" id="fri"/>
					<label for="set">토</label><input type="radio" value="6" name="WEEK" id="set"/>
				</td>
			</tr>
			<tr>
				<th>시작</th>
				<td>
					<input type="text" name="START"/>
				</td>
			</tr>
			<tr>
				<th>종료</th>
				<td>
					<input type="text" name="END"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="목록" onClick="courseList()"/>
					<input type="submit" value="완료"/>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
			function courseList(){
				location.href="courseList.do";
			}
		</script>
	</form>
	</section>
	<footer>
		<h3 align="center">Copyright 2018 정보처리산업기사 All Right Reserved</h3>
	</footer>
</body>
</html>