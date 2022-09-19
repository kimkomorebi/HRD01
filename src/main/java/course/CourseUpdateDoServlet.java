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
		String id = request.getParameter("ID");//���� �ڵ�
		String name = request.getParameter("NAME");//�����
		String tname = request.getParameter("T_NAME");//�����
		String credit = request.getParameter("CREDIT");//����
		String week = request.getParameter("WEEK");//����
		String start = request.getParameter("START");//���� �ð�
		String end = request.getParameter("END");//���� �ð�
		Courses c = new Courses();//DTO
		c.setId(id);//�����ڵ� ����
		c.setC_name(name);//����� ����
		c.setCredit(Integer.parseInt(credit));//���� ����
		c.setDay(Integer.parseInt(week));//���� ����
		c.setStart_hour(Integer.parseInt(start));//���� �ð� ����
		c.setEnd_hour(Integer.parseInt(end));//���� �ð� ����
		DBExpert dbe = new DBExpert();
		int code = dbe.getLecturerCode(tname);//�����ڵ� �˻�
		c.setL_code(String.valueOf(code));//���� �ڵ� ����
		boolean result = dbe.courseUpdate(c);//���� ���� ����
		if(result) {//������ ������ ���
			response.sendRedirect("updateResult.jsp?R=Y");
		}else {//������ ������ ���
			response.sendRedirect("updateResult.jsp?R=N");
		}
	}

}
