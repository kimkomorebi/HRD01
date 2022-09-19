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
	//Connection con = null;;
	//PreparedStatement pstmt = null;
	
	
	public boolean courseUpdate(Courses c) {
		String update = "update course_tbl set name=?, credit=?,"
		+" lecturer=?, week=?, start_hour=?, end_end=?"
		+" where id =?";
		boolean flag = false;//변경 성공 유무를 위한 변수 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, c.getC_name());
			pstmt.setInt(2, c.getCredit());
			pstmt.setString(3, c.getL_code());//강사 코드 설정
			pstmt.setInt(4, c.getDay());//요일 설정
			pstmt.setInt(5, c.getStart_hour());
			pstmt.setInt(6, c.getEnd_hour());
			pstmt.setString(7, c.getId()); // where 과목 코드 설정
			pstmt.executeUpdate();
			flag = true; //변경 성공을 의미
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	public Courses getCourse(String id) {
		String select = "select c.id, c.name, l.name, c.credit, c.week, "
				+ "c.start_hour, c.end_end"
				+ " from course_tbl c, lecturer_tbl l"
				+ " where c.lecturer = l.idx"
				+ " and c.id = ?";
		Courses c = null;//조회 결과를 저장할 변수 선언
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회 결과로 이동
				c = new Courses(); //조회 결과를 저장할 DTO
				c.setId(rs.getString(1));//과목 코드 설정
				c.setC_name(rs.getString(2));//과목 이름
				c.setL_name(rs.getString(3));//강사 이름
				c.setCredit(rs.getInt(4));//학점
				c.setDay(rs.getInt(5));//요일
				c.setStart_hour(rs.getInt(6));//시작 시간(숫자)
				c.setStart(String.format("%04d", c.getStart_hour()));
				c.setEnd_hour(rs.getInt(7));//종료 시간(숫자)
				c.setEnd(String.format("%04d", c.getEnd_hour()));
			}
		}catch(Exception e) {
			
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		return c;
	}
	
	public boolean deleteCourse(String id) {
		String delete = "delete from course_tbl where "
		+ "id = ?";
		boolean result = false; // 삭제 성공 유무를 위한 변수 선언
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, id);//첫 번째 물음표 코드 설정
			pstmt.executeUpdate();
			con.commit();//commit 실행
			result = true;//삭제 성공
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean putCourse(Courses c) {
		String insert = "insert into course_tbl values("
		+"?,?,?,?,?,?,?)";
		boolean flag = false; // 삽인 결과를 저장할 변수 선언
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, c.getId());//과목 코드
			pstmt.setString(2, c.getC_name());//과목명
			pstmt.setInt(3, c.getCredit());//학점
			pstmt.setString(4, c.getL_code());//교수코드
			pstmt.setInt(5, c.getDay());//요일
			pstmt.setInt(6, c.getStart_hour());//시작 시간
			pstmt.setInt(7, c.getEnd_hour());//종료 시간
			pstmt.executeUpdate(); //insert
			con.commit();//commit 실행
			flag = true; // 삽입 성공
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return flag;
	}
	
	public int getLecturerCode(String name) {
		String select = "select idx from lecturer_tbl where "+
		"name = ?";
		int idx = -1;
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) idx = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return idx;
	}
	
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
				c.setId(rs.getString(1));//과목코드
				c.setC_name(rs.getString(2));//과목명
				c.setCredit(rs.getInt(3));//학점
				c.setL_name(rs.getString(4));//강사명
				c.setDay(rs.getInt(5));//요일(숫자)
				switch(c.getDay()) {
					case 1:c.setWeek("월"); break;
					case 2:c.setWeek("화"); break;
					case 3:c.setWeek("수"); break;
					case 4:c.setWeek("목"); break;
					case 5:c.setWeek("금"); break;
					case 6:c.setWeek("토"); break;
				}
				c.setStart_hour(rs.getInt(6));//시작시간(숫자)
				c.setStart(String.format("%04d", c.getStart_hour()));
				c.setEnd_hour(rs.getInt(7));//종료시간(숫자)
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
