package course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Courses;

public class DBExpert {
	final String driver = "oracle.jdbc.OracleDriver";
	final String  url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	
	public ArrayList<String> getLecturerName() {
		String select = "select name from lecturer_tbl";
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString(1);
				list.add(name);
			}
		}catch(Exception e) {
			
		}finally {
			try {
				con.close(); rs.close(); pstmt.close();
			}catch(Exception e) {}
		}
		return list;
	}
	public int getCourseCount() {
		String select = "select count(*) from course_tbl";
		int result = -1;
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<Courses> getAllCourse() {
		String select = "select c.id, c.name, c.credit, l.name, c.week, c.start_hour, c.end_end "
				+"from course_tbl c, lecturer_tbl l "
				+"where c.lecturer = l.idx";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Courses> list = new ArrayList<Courses>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Courses c = new Courses();//DTO
				c.setId(rs.getString(1));//�����ڵ�
				c.setC_name(rs.getString(2));//�����
				c.setCredit(rs.getInt(3));//����
				c.setL_name(rs.getString(4));//�����
				c.setDay(rs.getInt(5));//����(����)
				switch(c.getDay()) {
					case 1:c.setWeek("��"); break;
					case 2:c.setWeek("ȭ"); break;
					case 3:c.setWeek("��"); break;
					case 4:c.setWeek("��"); break;
					case 5:c.setWeek("��"); break;
					case 6:c.setWeek("��"); break;
				}
				c.setStart_hour(rs.getInt(6));//���۽ð�(����)
				c.setStart(String.format("%04d", c.getStart_hour()));
				c.setEnd_hour(rs.getInt(7));//����ð�(����)
				c.setEnd(String.format("%04d", c.getEnd_hour()));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
