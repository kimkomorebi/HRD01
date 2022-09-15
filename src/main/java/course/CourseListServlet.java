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

@WebServlet("/courseList.do")
public class CourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		ArrayList<Courses> list = dbe.getAllCourse();
		int count = dbe.getCourseCount();
		request.setAttribute("COUNT", count);
		request.setAttribute("CLIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("courseList.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
