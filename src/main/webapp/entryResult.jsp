<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String result = request.getParameter("R");
	if(result.equals("YES")){
%>
	<script type="text/javascript">
		alert("과목이 등록되었습니다.");
	</script>
<%
	}else {
%>
	<script type="text/javascript">
		alert("과목이 등록되지 않았습니다. 관리자에게 문의하세요.");
	</script>
<%
	}
		
%>
	<script type="text/javascript">
		location.href="courseList.do";
	</script>
</body>
</html>