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
		String code = request.getParameter("CODE");//���� �ڵ�
		String name = request.getParameter("NAME");//�����
		String lec = request.getParameter("LEC");//�����
		//���� �̸����� ���� �ڵ带 select �Ѵ�.
		String credit = request.getParameter("CREDIT");//����
		String week = request.getParameter("WEEK");//����
		String start = request.getParameter("START");//���� �ð�
		String end = request.getParameter("END");//���� �ð�
		Courses c = new Courses();//DTO
		c.setId(code);//���� �ڵ� ����
		c.setC_name(name);//����� ����
		c.setCredit(Integer.parseInt(credit));//���� ����
		DBExpert dbe = new DBExpert();
		int l_code = dbe.getLecturerCode(lec);//�����ڵ�(����)
		c.setL_code(String.valueOf(l_code));//�����ڵ�(���ڿ�)
		c.setDay(Integer.parseInt(week));//���ϼ���
		c.setStart_hour(Integer.parseInt(start));//���� �ð� ����
		c.setEnd_hour(Integer.parseInt(end));//���� �ð� ����
		c.setL_name(lec);//�����
		boolean result = dbe.putCourse(c);//���� ����
		if(result) {//���� �����ΰ��
			//������(JSP) ��ȯ
			response.sendRedirect("entryResult.jsp?R=YES");
		}else {//���� ������ ���
			//������(JSP) ��ȯ
			response.sendRedirect("entryResult.jsp?R=NO");
		}
	}

}
