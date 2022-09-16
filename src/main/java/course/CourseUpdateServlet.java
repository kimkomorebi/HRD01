package course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Courses;

/**
 * Servlet implementation class CourseUpdateServlet
 */
@WebServlet("/courseUpdate.do")
public class CourseUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CourseUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String btn = request.getParameter("BTN");//버튼
		String id = request.getParameter("ID");//과목 코드
		DBExpert dbe = new DBExpert();
		if(btn.equals("수정")) {
			Courses c = dbe.getCourse(id);//과목 검색
			ArrayList<String> names = dbe.getLecturerName();
			request.setAttribute("C", c);
			request.setAttribute("NAMES", names);
			RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
			rd.forward(request, response);
		}else if(btn.equals("삭제")) {
			boolean r = dbe.deleteCourse(id);
			if(r) {
				response.sendRedirect("deleteResult.jsp?R=Y");
			}else {
				response.sendRedirect("deleteResult.jsp?R=N");
			}
		}
	}

}
