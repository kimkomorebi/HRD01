package course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Courses;

@WebServlet("/courseEntry.do")
public class CourseEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseEntryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String code = request.getParameter("CODE");//과목 코드
		String name = request.getParameter("NAME");//과목명
		String lec = request.getParameter("LEC");//강사명
		//강사 이름으로 강사 코드를 select 한다.
		String credit = request.getParameter("CREDIT");//학점
		String week = request.getParameter("WEEK");//요일
		String start = request.getParameter("START");//시작 시간
		String end = request.getParameter("END");//종료 시간
		Courses c = new Courses();//DTO
		c.setId(code);//과목 코드 설정
		c.setC_name(name);//과목명 설정
		c.setCredit(Integer.parseInt(credit));//학점 설정
		DBExpert dbe = new DBExpert();
		int l_code = dbe.getLecturerCode(lec);//강사코드(숫자)
		c.setL_code(String.valueOf(l_code));//강사코드(문자열)
		c.setDay(Integer.parseInt(week));//요일설정
		c.setStart_hour(Integer.parseInt(start));//시작 시간 설정
		c.setEnd_hour(Integer.parseInt(end));//종료 시간 설정
		c.setL_name(lec);//강사명
		boolean result = dbe.putCourse(c);//과목 삽입
		if(result) {//삽입 성공인경우
			//페이지(JSP) 전환
			response.sendRedirect("entryResult.jsp?R=YES");
		}else {//삽입 실패인 경우
			//페이저(JSP) 전환
			response.sendRedirect("entryResult.jsp?R=NO");
		}
	}

}
