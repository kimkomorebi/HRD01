package model;

public class Courses {
	private String id; //과목코드
	private String c_name;//과목명
	private Integer credit;//학점
	private String l_name;//강사명
	private String l_code;//강사코드
	private String week;//요일
	private Integer day;//숫자 요일
	private String start;//시작시간
	private Integer start_hour;//숫자 시작 시간
	private String end;//종료시간
	private Integer end_hour;//숫자 종료 시간
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_code() {
		return l_code;
	}
	public void setL_code(String l_code) {
		this.l_code = l_code;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public Integer getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(Integer start_hour) {
		this.start_hour = start_hour;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(Integer end_hour) {
		this.end_hour = end_hour;
	}
}
