package course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Courses;

/**
 * Servlet implementation class CourseUpdateDoServlet
 */
@WebServlet("/courseUpdateDo.do")
public class CourseUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseUpdateDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");//과목 코드
		String name = request.getParameter("NAME");//과목명
		String tname = request.getParameter("T_NAME");//강사명
		String credit = request.getParameter("CREDIT");//학점
		String week = request.getParameter("WEEK");//요일
		String start = request.getParameter("START");//시작 시간
		String end = request.getParameter("END");//종료 시간
		Courses c = new Courses();//DTO
		c.setId(id);//과목코드 설정
		c.setC_name(name);//과목명 설정
		c.setCredit(Integer.parseInt(credit));//학점 설정
		c.setDay(Integer.parseInt(week));//요일 설정
		c.setStart_hour(Integer.parseInt(start));//시작 시간 설정
		c.setEnd_hour(Integer.parseInt(end));//종료 시간 설정
		DBExpert dbe = new DBExpert();
		int code = dbe.getLecturerCode(tname);//강사코드 검색
		c.setL_code(String.valueOf(code));//강사 코드 설정
		boolean result = dbe.courseUpdate(c);//과목 변경 실행
		if(result) {//변경이 성공한 경우
			response.sendRedirect("updateResult.jsp?R=Y");
		}else {//변경이 실패한 경우
			response.sendRedirect("updateResult.jsp?R=N");
		}
	}

}
